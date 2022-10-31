package bdd_style;

import io.restassured.RestAssured;
import  static io.restassured.RestAssured.*;
public class post_reqres {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in";
		
		//get the status line
		String status_line=given().log().all().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").when().post("/api/users").getStatusLine();
		System.out.println("status line is "+status_line);
		
		//check the status code
		given().log().all().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").when().post("/api/users").then().log().all().assertThat().statusCode(201);

		//get the response body
		String response_body=given().log().all().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").when().post("/api/users").getBody().asString();
		System.out.println("Response body is "+response_body);
		
		//post..register successful
		int status_code=given().log().all().body("{\r\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"pistol\"\r\n"
				+ "}").when().post("api/register").getStatusCode();
		System.out.println("Status code is "+status_code);
	}

}
