package Day8;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class DeleteUser {

	
		
		@Test 
		void deleteUser(ITestContext context)
		{
			String BT= "076630dc9e960cb1e0abfa11c05f72d2a3e50f304eac0ec132a5a7aef6000734";
			
			int id=(Integer) context.getAttribute("user-id");
			given()
			
			.contentType(ContentType.JSON)
			.headers("Authorization","Bearer "+ BT)
			.pathParam("id", id)
			
			.when()
				.delete("https://gorest.co.in/public/v2/users/{id}")
			
			.then()
				.log().status();
			
			
		}

	}

	

