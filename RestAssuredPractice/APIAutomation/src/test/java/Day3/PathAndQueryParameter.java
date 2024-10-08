package Day3;

import org.testng.annotations.Test;

import io.restassured.internal.http.Status;
import io.restassured.internal.support.FileReader;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import org.json.*;
import java.io.*;

public class PathAndQueryParameter {

	@Test
	void pathAndQueryParameter() {
		
		//https://reqres.in/api/users?page=2&id=5
		given()
		.pathParam("mypath","users")
		.queryParam("page",2)
		.queryParam("id", 5)
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		.then()
		.log().body()
		;
	}
	
}
