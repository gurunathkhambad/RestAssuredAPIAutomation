package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class HTTPRequests {
	
	int id;
	
//	@Test
//	void getUsers()
//	{
//		given()
//		
//		.when()
//		.get("https://reqres.in/api/users?page=2")
//		
//		.then()
//		.statusCode(200)
//		.body("page", equalTo(2))
//		.log().all(); 
//		}
//	
//	@Test
//	void getUser(){
//		
//		given()
//		
//		.when()
//		.get("https://reqres.in/api/users/2")
//		
//		.then()
//		.statusCode(200)
//		.log().all();
//	}
	
//	@Test
//	void addUser() {
//		
//		HashMap data=new HashMap();
//		data.put("name", "Guru");
//		data.put("job", "Student");
//		
//		given()
//		.contentType("application/json")
//		.body(data)
//		
//		.when()
//		.post("https://reqres.in/api/users")
//		
//		.then()
//		.statusCode(201)
//		.log().all();
//	}
	

	@Test(priority=1)
	void createUserAndCaptureId() {
		
		HashMap data=new HashMap();
		data.put("name", "Guru");
		data.put("job", "Student");
		id=
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
	}
	
	@Test(priority=2)
	void updateTheUser() {
		
		HashMap data=new HashMap();
		data.put("name", "Gurunath");
		data.put("job","Engineer");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(200)
		.log().all();
	}
	@Test(priority=3)
	void deleteUser() {
		
		given()
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log().all();
	}
	}



