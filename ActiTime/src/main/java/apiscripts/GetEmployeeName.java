package apiscripts;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetEmployeeName {

	@Test
	public static void getEmployeeNames(){

		String url = "https://gorest.co.in/public-api/users/123/posts";

		Response responce = ApiCommonLib.getService(url);

		String res = responce.asString();
		JsonPath json = new JsonPath(res);

		String count = json.get("data.employee_name.size()").toString();

		for (int i = 0; i < Integer.parseInt(count); i++) {
			String employee = json.getString("data.employee_name[" + i + "]");
			System.out.println(employee);
		}
	}
}
