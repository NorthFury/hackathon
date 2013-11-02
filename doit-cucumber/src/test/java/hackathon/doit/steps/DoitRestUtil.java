package hackathon.doit.steps;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;


public class DoitRestUtil {

	static {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/";
	}

	public static int getStatus(String path) {

		Response response = RestAssured.get(path);
		ResponseBody body = response.getBody();
		String status = body.asString();
		return Integer.parseInt(status);
	}
}
