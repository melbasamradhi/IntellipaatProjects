package no_bdd_style;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Put_demo {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httprequest= RestAssured.given();
		
		JSONObject j= new JSONObject();
		j.put("name","morpheus");
		j.put("job","zion resident");
		
		httprequest.body(j.toJSONString());
	Response response=	httprequest.put("/api/users/2");
	System.out.println(response.getBody().asPrettyString());
	
	Headers header=	response.headers();
	for(Header h:header)
	{
		System.out.println("name is   "+h.getName()+"      value is   "+h.getValue());
	}
	

	}

}
