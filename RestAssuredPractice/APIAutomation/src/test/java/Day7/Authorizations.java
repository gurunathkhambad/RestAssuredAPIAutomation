package Day7;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;


public class Authorizations {

	//@Test (priority=1)
	void testBasicAuthentication()
	{
		given()
		 	.auth().basic("postman","password")
		
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all()
		;
	}
	
	//@Test (priority=2)
	void testDigestAuthentication()
	{
		given()
			.auth().digest("postman", "password")
		.when()
			.get("https://postman-echo.com/digest-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all()
		;
	}
	
	//@Test (priority=3)
	void testPremptiveAuthentication()
	{
		given()
		 	.auth().preemptive().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
		;
		
	}
	
	@Test(priority=4)
	void apiKeyAuthentication()
	{
		
		//Approach
		given()
			.queryParam("appid","5362da9f0501b1b93aa1b9a029804859")
//			.queryParam("q", "Dehli")
//			.queryParam("cnt", "3")
//			.pathParam("myPath", "data/2.5/forecast/daily")
//			
		
		.when()
			.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=dehli&cnt=6")
		
		.then()
		.log().all();
		
		//Approach
		given()
		.queryParam("appid","5362da9f0501b1b93aa1b9a029804859")
		.queryParam("q", "Dehli")
		.queryParam("cnt", "3")
		.pathParam("myPath", "data/2.5/forecast/daily")
		
	
	.when()
		.get("https://api.openweathermap.org/{myPath}")
	
	.then()
	.log().all();
		
	}
}
