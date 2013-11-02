package hackathon.doit.rest;

import hackathon.doit.model.Account;
import hackathon.doit.model.Task;

import com.avaje.ebean.Ebean;

import spark.Request;
import spark.Response;

/**
 * @author Ariel-Laptop
 *
 */
public class GetTaskRoute extends JsonTransformer {

	protected GetTaskRoute(String path) {
		super(path);
	}

	@Override
	public Object handle(Request request, Response response) {
		String username = request.params(":username");
		Account account = Ebean.find(Account.class).where()
				.eq("username", username).findUnique();
		
		long taskId = Long.parseLong(request.params(":taskId"));
		Task task = Ebean.find(Task.class, taskId);
		// sanity check against the account's tasks
		if (!account.getTasks().contains(task)) {
			return getError(response);
		}
		
		if (task != null) {
			return task;
		} else {
			return getError(response);
		}
	}

	private Object getError(Response response) {
		response.status(404); // 404 Not found
		
		return createErrorResponse("Not found");
	}

}
