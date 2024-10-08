package Day3;

import org.testng.annotations.Test;

import io.restassured.internal.http.Status;
import io.restassured.internal.support.FileReader;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.*;
import java.io.*;

public class CookiesValidation {
	
	//Getting value of cookie
	//@Test(priority=1)
	void getCookies()
	{
		Response res=given()
		
		.when()
		.get("https://google.com/");
		String valueOfCookie=res.getCookie("AEC");
		System.out.println(valueOfCookie);
		
	}
	
	//Assertion of cookie
	
	//@Test(priority=2)
	void validationOfCookie() {
	
		given()
		
		.when()
		.get("https://google.com")
		.then()
		.cookies("AEC","Ae3NU9OJ3F4_iEdK2-_HymliUUiHgAWOs3vPGoikTClXh_Da1rZiTVGcy4E")
		.log().all()
		;
	}
	
	//getting all the cookies 
	//@Test(priority=1)
	void getAllCookies() {
		
		Response res=given()
		
		.when()
		.get("https://google.com");
		//get single cookie info
		//String valueOfCookie=res.getCookie("AEC");
		//System.out.println(valueOfCookie);
		//To get all cookies info
		
		Map<String, String> cookies_Value = res.getCookies();
		//System.out.println(cookies_Value);
		
		System.out.println(cookies_Value.keySet());
		
		for(String k:cookies_Value.keySet()) {
			
			String cookie_Value=res.getCookie(k);
			System.out.println(k+"     "+cookie_Value);
		}
		
	} 

	
	@Test
	void getAllCookiesInfo() {
		Response res=given()
		.when()
		.get("https://google.com");
		
		Map<String, String> cookies_Values = res.getCookies();
		
		for(String k:cookies_Values.keySet()) {
			
			String ValueOfCookie = res.getCookie(k);
			System.out.println(k+"    "+ValueOfCookie);
			
		}
		
		
	}
	
}
