package bdd_style;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Get_reqres {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";

		// to vaidate the status code
		given().log().all().when().get("api/unknown").then().log().all().assertThat().statusCode(200);

		// to get the status line
		String status_line = given().log().all().get("api/unknown/2").getStatusLine();
		System.out.println("Status line of the response " + status_line);

		// get the delayed response
		long res_time = given().log().all().queryParam("delay=3").when().get("api/users").getTime();
		System.out.println("Response time is " + res_time);

		// get the response body
		String res_body = given().log().all().queryParam("delay=3").when().get("api/users").getBody().asPrettyString();
		System.out.println("Response body is " + res_body);
		
		// get the server name from  response header
		String server_name=given().log().all().queryParam("delay=3").when().get("api/users").header("Server");
		System.out.println("server name is "+server_name);
		
		//validate that 'server' name from response header is 'cloudflare' and check the 'total' in the body;
		given().log().all().queryParam("delay=3").when().get("api/users").then().log().all().assertThat().body("total",equalTo(12)).header("Server","cloudflare");
		
		// to extract the response
		String response=given().log().all().when().get("api/users").then().log().all().extract().response().asPrettyString();
		System.out.println(response);
		
		//to parsn using jsonpath
		
		JsonPath js= new JsonPath(response);
		Object total=js.get("total");
		System.out.println("total is "+total);
		
		// to find the no of data ..since data is an array..we use data.size()
		int no_of_ID=js.getInt("data.size()");
		System.out.println(no_of_ID);
		
		Object id=js.getString("data.id");
		System.out.println("Id "+id);
		
		Object email=js.getString("data.email");
		System.out.println("Email "+email);
		
		Object email_1=js.getString("data[0].email");
		System.out.println("Email "+email_1);
		
	}

}
