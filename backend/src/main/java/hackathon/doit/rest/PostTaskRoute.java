package hackathon.doit.rest;

import hackathon.doit.model.Account;
import hackathon.doit.model.AccountTask;
import hackathon.doit.model.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.avaje.ebean.Ebean;

import spark.Request;
import spark.Response;

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
        String username = request.params(":username");
        
        Account account = Ebean.find(Account.class).where()
				.eq("username", username).findUnique();
        
        try {
        	task = mapper.readValue(request.body(), Task.class);
        } catch (IOException e) {
                
        	response.status(500); // Server-side error test
                
            return createErrorResponse("Task couldn't be saved because it's not in a valid format");
        }
                
        AccountTask accountTask = new AccountTask();
        accountTask.setTask(task);
        
        account.getTasks().add(accountTask);
        
        Ebean.save(account);
		
		response.status(201); // 201 Created
        
        return task;
    }

}
