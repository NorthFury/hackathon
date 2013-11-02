/**
 * 
 */
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
public class PutTaskRoute extends JsonTransformer {

	protected PutTaskRoute(String path) {
		super(path);
	}

	@Override
	public Object handle(Request request, Response response) {
		
		String userId = request.params(":userId");
		Long taskId = Long.parseLong(request.params(":taskId"));
		
		Task task = Ebean.find(Task.class, taskId);
		
		Account account = Ebean.find(Account.class, userId);
		
		if (!account.getTasks().contains(task)) {
			return getError(response);
		} else {
			AccountTask accountTask = Ebean.find(AccountTask.class).where().eq("task", task).findUnique();
			
			Task jsonTask = null;
			
			try {
				jsonTask = mapper.readValue(request.body(), Task.class);
				jsonTask.setId(taskId);
			} catch (IOException e) {
				return getError(response);
			}
			
			accountTask.setTask(jsonTask);
	        
			Ebean.update(jsonTask);
			
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
