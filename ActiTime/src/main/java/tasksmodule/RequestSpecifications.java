package tasksmodule;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecifications {

	public static void main(String[] args) {

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://gorest.co.in").setContentType(ContentType.JSON).build();
		ResponseSpecification response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		
		
		 Response res = RestAssured.given().spec(req).when().get("/public-api/users/123/posts").then().spec(response).extract().response();
		 
		 System.out.println(res.asString());
		
		
		
	}
}
