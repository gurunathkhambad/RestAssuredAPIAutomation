package Day5;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLResponse {
	
	//@Test
	void testMXLResponse()
	{
		
		//Approch 1
		
		/*given()
		
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
		.statusCode(200)
		.header("content-type",equalTo("application/xml; charset=utf-8"))
		//TravelerinformationResponse.page this a xml path 
		.body("TravelerinformationResponse.page", equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"))
		;*/
		
		//Approach 2
		
		Response res=given()
		
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		//Validation 
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.header("content-type"), "application/xml; charset=utf-8");
		Assert.assertEquals(res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[1].email"), "qweqw@mail.ru");
		
		String pageNo=res.xmlPath().get("TravelerinformationResponse.page").toString();
		
		Assert.assertEquals(pageNo, "1");
		
		String name=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[1].name").toString();
		
		Assert.assertEquals(name, "AS");
		
		
			
		
	}
	
	//Approch 3 this is a main parsing concept, here we are not hard coding any value
	
	@Test 
	void testXMLResponseBody()
	{
		
		Response res=given()
		
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xmlObj= new XmlPath(res.asString());
		
		List<String> travellers=xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		
		//System.out.println(travellers.size());
		Assert.assertEquals(travellers.size(), 10);
		
		List <String> travellers_names=xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		boolean Status=false;
		for(String travellerName: travellers_names)
		{
			//System.out.println(travellerName);
			
			if(travellerName.equalsIgnoreCase("Ashor"))
			{
				Status=true;
				break;
			}
		}
		Assert.assertEquals(Status, true);
		
	 }

}
