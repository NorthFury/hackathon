package hackathon.doit.rest.util;

public class JsonResponseCreator {
	public static Object getJsonResponse(String callback, Object responseBody) {
		return callback + "(" + responseBody.toString() + ")";
	}
}
