package apiscripts;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class ApiCommonLib {

	public static Response postService(String url, String request) {

		Response res = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Content-Type", "application/josn;charset:UTF-8").body(request).post(url);

		System.out.println("Reponse code" + res.getStatusCode());

		return res;
	}

	public static Response getService(String url) {

		Response res = null;
		try {
			res = RestAssured.given().config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
					.header("Content-Type", "application/josn;charset:UTF-8").get(url);
		} catch (Exception e) {
			e.getMessage();
		}

		System.out.println("Reponse code" + res.getStatusCode());

		return res;
	}
	
	
	
}
