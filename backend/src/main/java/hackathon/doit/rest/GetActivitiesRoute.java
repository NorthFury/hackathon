package hackathon.doit.rest;

import hackathon.doit.model.Activity;
import spark.Request;
import spark.Response;

import com.avaje.ebean.Ebean;

public class GetActivitiesRoute extends JsonTransformer {

	public GetActivitiesRoute(String path) {
		super(path);
	}

	public GetActivitiesRoute(String path, String acceptType) {
		super(path, acceptType);
	}

	@Override
	public Object handle(Request request, Response response) {
		return Ebean.find(Activity.class).findList();
	}

}