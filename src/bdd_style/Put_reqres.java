package bdd_style;

import io.restassured.RestAssured;
import  static io.restassured.RestAssured.*;
public class Put_reqres {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in";
		
		//get the status line
		String status_line=given().log().all().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").when().put("/api/users/2").getStatusLine();
		System.out.println("status line is "+status_line);

	}

}
