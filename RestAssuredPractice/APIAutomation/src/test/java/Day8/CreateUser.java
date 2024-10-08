package Day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Locale;

import org.json.JSONObject;


public class CreateUser {
	
	@Test 
	void createUser(ITestContext context)
	{
//		JSONObject data=new JSONObject();
//		
//		Faker faker=new Faker();
//		
//		Faker faker1 = new Faker(new Locale("en-IND"));
//		
//		data.put("name", faker.name().firstName() );
//		data.put("location", faker1);
//		data.put("phone", faker.phoneNumber());
//		
//		String BT="076630dc9e960cb1e0abfa11c05f72d2a3e50f304eac0ec132a5a7aef6000734";
//		given()
//		.contentType(ContentType.JSON)
//		.body(data.toString())
//		
//		.headers("Authorization", "Bearer "+ BT)
//		.when()
//			.get("https://gorest.co.in/public/v2/users/2138969")
//		
//		.then()
//		.log().all()
//		;
//		
		
		JSONObject data= new JSONObject();
		
		Faker faker=new Faker();
		
		data.put("name", faker.name().firstName());
		data.put("email", faker.internet().emailAddress());
		data.put("gender","Male");
		data.put("status", "inactive");
		
		String BT= "076630dc9e960cb1e0abfa11c05f72d2a3e50f304eac0ec132a5a7aef6000734";
		
		int id=given()
		
		.contentType(ContentType.JSON)
		.body(data.toString())
		.headers("Authorization", "Bearer "+ BT)
		
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		
		System.out.println(id);
		context.setAttribute("user-id", id);
		
		
	}

}
