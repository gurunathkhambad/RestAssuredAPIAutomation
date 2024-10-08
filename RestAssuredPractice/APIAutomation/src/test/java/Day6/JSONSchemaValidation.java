package Day6;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import com.github.fge.jsonschema.messages.JsonSchemaValidationBundle;
public class JSONSchemaValidation {

	@Test 
	void jsonSchemaValidation() 
	{
	
		given()
		
		.when()
		 	.post("http://localhost:3000/students")
		.then()
		// .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath) //Getting an error 
		 ;
		
		
	}
}
