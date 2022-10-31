package no_bdd_style;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete_demo {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httprequest= RestAssured.given();
		
	Response response=	httprequest.delete("/api/users/2");
	
	int status_code=response.getStatusCode();
	String status_line=response.getStatusLine();
	System.out.println(status_code);
	System.out.println(status_line);
	Headers header=	response.headers();
	for(Header h:header)
	{
		System.out.println("name is   "+h.getName()+"      value is   "+h.getValue());
	}
	}

}
