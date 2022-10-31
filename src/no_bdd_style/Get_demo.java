package no_bdd_style;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_demo {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.get();
		String s = response.asPrettyString();
		System.out.println("Response is " + s);

		// to check the status

		int status_code = response.getStatusCode();
		String status_line = response.getStatusLine();
		
		System.out.println("status code is "+status_code+" and the status line is "+status_line);

		// to parsn the response

		JsonPath js = response.jsonPath();
		int no_Of_books = js.get("books.size()");
		System.out.println(no_Of_books);

		String website = js.get("books[0].website");
		System.out.println("Website of book1 is" + website);

		Object title = js.get("books.title");
		System.out.println("Title of the books are " + title);
		
		//to get the response header
	Headers header=	response.headers();
	for(Header h:header)
	{
		System.out.println("Name:  "+h.getName()+"   value:  "+h.getValue());
	}
	
	String content_type=response.getHeader("content-Type");
	System.out.println("Content-Type in the response header is "+content_type);

	}

}
