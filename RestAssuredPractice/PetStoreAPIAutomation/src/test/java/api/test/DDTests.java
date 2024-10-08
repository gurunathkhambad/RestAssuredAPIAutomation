package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.DDUser;
import api.payload.User;
import api.utilities.Dataprovider;
import io.restassured.response.Response;

public class DDTests {

	@Test (priority=1 , dataProvider="Data", dataProviderClass=Dataprovider.class)
	public void testPostUser(String UserId, String UserName, String FirstName, String LastName, String emailId, String pwd, String ph)
	{
		User userPayload= new User();
		userPayload.setIdNo(Integer.parseInt(UserId));
	 	userPayload.setUsername(UserName);
		userPayload.setFirstName(FirstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(emailId);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		
		Response response=UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	@Test(priority=2 , dataProvider="UserNames", dataProviderClass=Dataprovider.class)
	public void deleteUser(String Username)
	{
		Response response=UserEndPoints.deleteUser(Username);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
