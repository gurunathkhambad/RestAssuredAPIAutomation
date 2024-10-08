package Day2;

//import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.internal.http.Status;
import io.restassured.internal.support.FileReader;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import org.json.*;
import java.io.*;

public class DifferentWaysToCreatePostRequestBody {
	
	// Post request body using HashMap
	//@Test
	void testPostRequestusingHashMap() {
		
		HashMap data=new HashMap();
		
		data.put("name", "Harish");
		data.put("location", "India");
		data.put("phone", "8902345493");
		
		String courses[]= {"Java","Python"};
		data.put("courses", courses);	
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Harish"))
		.body("location", equalTo("India"))
		.log().all();
	}
	
	
	
	//Post request using Json Library
	//@Test
	void testPostRequestUsingJsonLibrary() {
		
		JSONObject data=new JSONObject();
		
		data.put("name", "Chetan");
		data.put("location", "Germany");
		data.put("phone", "8909876789");
		
		String courses[]= {"Postman","RestAPI"};
		data.put("courses", courses);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Chetan"))
		.body("courses[0]", equalTo("Postman"))
		.body("courses[1]", equalTo("RestAPI"))
		.log().all();
		
	}
	
	//Post request using POJO class
	
	//@Test
	void testPostRequestusingPOJOClass() {
		
		Pojo_PostRequest data= new Pojo_PostRequest();
		
		data.setName("Scott");
		data.setLocation("USA");
		data.setPhone("56789098765");
		
		String courses[]= {"Java", "Selenium"};
		data.setCourses(courses);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Scott"))
		.body("phone", equalTo("56789098765"))
		.body("courses[1]", equalTo("Selenium"));
	}
	
	// Post request using External json file
	@Test
	void testPostRequestUsingExternaljsonFile() throws FileNotFoundException {
		 	File f=new File(".\\body.json");
		 	
		 	java.io.FileReader fr=new java.io.FileReader(f);
		 	
		 	JSONTokener ft=new JSONTokener(fr);
		 	
		 	JSONObject data= new JSONObject(ft);
		 	
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Arya"))
		.body("courses[0]", equalTo("RestAPI"))
		.log().all()
		;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
