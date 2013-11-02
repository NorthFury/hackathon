/**
 * 
 */
package hackathon.doit.rest;

import hackathon.doit.model.Account;
import hackathon.doit.model.AccountTask;
import hackathon.doit.model.Task;

import com.avaje.ebean.Ebean;

import spark.Request;
import spark.Response;

/**
 * @author Ariel-Laptop
 *
 */
public class PutTaskRoute extends JsonTransformer {

	protected PutTaskRoute(String path) {
		super(path);
	}

	@Override
	public Object handle(Request request, Response response) {
		
		String username = request.params(":username");
		String taskId = request.params(":taskId");
		
		Task task = Ebean.find(Task.class, taskId);
		
		Account account = Ebean.find(Account.class).where()
				.eq("username", username).findUnique();
		
		if (!account.getTasks().contains(task)) {
			return getError(response);
		} else {
			AccountTask accountTask = Ebean.find(AccountTask.class).where().eq("task", task).findUnique();
			accountTask.setTask(task);
			
			Ebean.save(accountTask);
			
			response.status(201); // 201 Created
	        
			// return updated task
	        return task;
		}
	}
	
	private Object getError(Response response) {
		response.status(404); // 404 Not found
		
		return createErrorResponse("Not found");
	}

}
