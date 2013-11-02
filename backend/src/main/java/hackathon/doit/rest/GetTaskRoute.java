package hackathon.doit.rest;

import hackathon.doit.model.Account;
import hackathon.doit.model.Task;
import spark.Request;
import spark.Response;

import com.avaje.ebean.Ebean;

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
		String userId = request.params(":userId");
		Account account = Ebean.find(Account.class, userId);
		
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
