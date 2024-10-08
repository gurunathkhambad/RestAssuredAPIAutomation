package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	
	public static Response createUser(User userpayload)
	{
		Response response=given()
		
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(userpayload)
		
		.when()
		.post(Routes.post_url);
		return response;
	
	}
	
	public static Response ReadUser(String Username)
	{
		Response response=given()
		
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", Username)
		
		.when()
		.get(Routes.get_url);
		return response;
	
	}
	
	public static Response updateUser(String Username , User payload)
	{
		Response response=given()
		
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", Username)
		.body(payload)
		
		.when()
		.put(Routes.update_url);
		return response;
	}
	
	public static Response deleteUser(String Username)
	{
		Response response=given()
		
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", Username)
		
		.when()
		.delete(Routes.delete_url);
		return response;
	
	}
}










