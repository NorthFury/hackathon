package hackathon.doit.rest;

import hackathon.doit.model.Account;
import hackathon.doit.model.AccountTask;
import hackathon.doit.model.Task;

import java.io.IOException;

import spark.Request;
import spark.Response;

import com.avaje.ebean.Ebean;

/**
 * @author Ariel-Laptop
 *
 */
public class PostTaskRoute extends JsonTransformer {

	protected PostTaskRoute(String path) {
		super(path);
	}

	@Override
    public Object handle(Request request, Response response) {
        Task task = null;
        String userId = request.params(":userId");
        
        Account account = Ebean.find(Account.class, userId);
        
        try {
        	task = mapper.readValue(request.body(), Task.class);
        } catch (IOException e) {
                
        	return getError(response);
        }
                
        AccountTask accountTask = new AccountTask();
        accountTask.setTask(task);
        
        account.getTasks().add(accountTask);
        
        Ebean.save(account);
		
		response.status(201); // 201 Created
        
        return task;
    }

}
