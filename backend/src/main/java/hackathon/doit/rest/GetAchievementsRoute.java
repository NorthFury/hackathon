package hackathon.doit.rest;

import hackathon.doit.model.Achievement;
import spark.Request;
import spark.Response;

import com.avaje.ebean.Ebean;

public class GetAchievementsRoute extends JsonTransformer {

	public GetAchievementsRoute(String path) {
		super(path);
	}

	public GetAchievementsRoute(String path, String acceptType) {
		super(path, acceptType);
	}

	@Override
	public Object handle(Request request, Response response) {
		return Ebean.find(Achievement.class).findList();
	}

}
