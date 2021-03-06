package hackathon.doit.rest;

import hackathon.doit.model.Account;
import spark.Request;
import spark.Response;

import com.avaje.ebean.Ebean;

/**
 * @author Ariel-Laptop
 *
 */
public class GetTasksRoute extends JsonTransformer {

	protected GetTasksRoute(String path) {
		super(path);
	}

	@Override
	public Object handle(Request request, Response response) {
		String userId = request.params(":userId"); 
		
		Account user = Ebean.find(Account.class, userId);
		
		// get tasks from user
		return user.getTasks();
	}

}
