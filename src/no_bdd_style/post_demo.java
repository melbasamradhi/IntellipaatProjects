package no_bdd_style;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class post_demo {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification httprequest= RestAssured.given();
		httprequest.header("Content-Type", "application/json");
		// to send the payload
		JSONObject jo = new JSONObject(); 
		  jo.put("name","morpheus");
		  jo.put("job","leader");
		httprequest.body(jo.toJSONString());
		
		Response response=httprequest.post("/api/users");
		System.out.println(response.getStatusLine());
	System.out.println(response.body().asPrettyString());
	
Headers header=	response.headers();
for(Header h:header)
{
	System.out.println("name is   "+h.getName()+"      value is   "+h.getValue());
}
	}

}
