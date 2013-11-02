package hackathon.doit.rest;

import hackathon.doit.model.Account;
import hackathon.doit.model.AccountTask;
import hackathon.doit.model.Task;
import spark.Request;
import spark.Response;

import com.avaje.ebean.Ebean;

/**
 * @author Ariel-Laptop
 *
 */
public class MarkDoneRoute extends JsonTransformer {

	protected MarkDoneRoute(String path) {
		super(path);
	}

	@Override
	public Object handle(Request request, Response response) {
		
		Long userId = Long.parseLong(request.params(":userId"));
		Long taskId = Long.parseLong(request.params(":taskId"));
		
		Task task = Ebean.find(Task.class, taskId);
		
		Account account = Ebean.find(Account.class, userId);
		
		if (account == null) {
			return getError(response);
		}
		
		if (!account.getTasks().contains(task)) {
			return getError(response);
		} else {
			AccountTask accountTask = Ebean.find(AccountTask.class).where().eq("task", task).findUnique();
			
			accountTask.setDone(true);
	        
			Ebean.update(accountTask);
			
			response.status(201); // 201 Created
	        
			// return updated task
	        return accountTask;
		}
	}

}
