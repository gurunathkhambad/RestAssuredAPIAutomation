package Day3;

import io.restassured.http.Headers;
import io.restassured.internal.http.Status;
import io.restassured.internal.support.FileReader;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.*;
import org.testng.annotations.Test;

import java.io.*;


public class Header {
	
	//Assertion of the header
	//@Test
	void gettingHeaderValue() {
		given()
		.when()
		.get("https://google.com")
		.then()
		.header("Server", "gws")
		.log().headers();
	}
	
	//Getting header data
	
	//@Test
	void gettingHeaderData() {
		
		Response res=given()
		
		.when()
		.get("https://google.com");
		String header_Value = res.header("Server");
		System.out.println("Header value of Server : "+header_Value);
	}
	
	@Test
	void getAllHeaderValues() {
		
		Response res=given()
		.when()
		.get("https://www.google.com");
		
		 Headers headerValues = res.getHeaders();
		 
		 for(io.restassured.http.Header hd :headerValues) {
			 
		 System.out.println(hd.getName()+"   "+hd.getValue());
		 }
		
		
	}
}
