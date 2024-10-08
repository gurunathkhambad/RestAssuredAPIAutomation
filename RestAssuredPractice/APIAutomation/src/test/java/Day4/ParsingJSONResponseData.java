package Day4;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONArray;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ParsingJSONResponseData {
	
	//Approach 1
	//@Test
	void testJSONResponse() {
		
		given()
		//.contentType("application/json")
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/book")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json")
		.body("[2].title", equalTo("Moby Dick"))
		;
		
	}
	
	
	@Test
	void testJSONResponseBodyData() {
		Response res=
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/list");
		
		//Validating the response using assertion
		/*Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json");*/
		
		//Here storing the value of the title and comparing with String, if the position of the jsonObject changed this logic will fail
		/*String title=res.jsonPath().get("[2].title").toString();
		
		//Assert.assertEquals(title, "Moby Dick");*/
		
		// Capturing the all book titles
	    //By using JSONObject we can transver of parse the json response 
		
	// I am getting an exception eventhough my code code is correct so I have added in the try catch 
    
		/*JSONArray jsonarray=new JSONArray(res.toString());
		
		 for (int i = 0; i < jsonarray.length(); i++) {
			 
			  JSONObject bookObject = jsonarray.getJSONObject(i);
              String bookTitle = bookObject.getString("title");
              System.out.println(bookTitle);
		 }*/
		
		// JSONObject json = new JSONObject(res.asString());
		 
//		 for(int i=0; i<json.length();i++)
//		 {
//			 json.getJSONArray("book").getJSONObject(i).get("title").toString();
//		 }
		 
		// Here capturing the all author names
		/*JSONArray jsonArr= new JSONArray(res.asString());
		 
		 int lenght=jsonArr.getJSONObject(0 ).getJSONArray("book").length();
		 System.out.println(lenght);
		
		 for(int i=0; i<lenght; i++)
		 {
			 String authorNames= jsonArr.getJSONObject(0).getJSONArray("book").getJSONObject(i).get("author").toString();
			 System.out.println(authorNames);
			 
		 }*/
		 
		 //Here adding all the book prices
		 
		 JSONArray JSONArr= new JSONArray(res.asString());
		 
		 int legnth= JSONArr.getJSONObject(0).getJSONArray("book").length();
		 
		 double totalBookPrice=0;
		 for(int i=0; i<legnth; i++)
		 {
			String price=JSONArr.getJSONObject(0).getJSONArray("book").getJSONObject(i).get("price").toString();
			System.out.println(price);
			double bookPrice=Double.parseDouble(price);
			totalBookPrice=totalBookPrice+bookPrice;
		 }
		 System.out.println(totalBookPrice);
		
	} 
   }
	


