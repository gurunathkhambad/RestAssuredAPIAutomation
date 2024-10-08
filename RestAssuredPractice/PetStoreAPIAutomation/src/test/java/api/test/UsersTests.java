package api.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;

public class UsersTests {

	Faker faker;
	User userpayload;
	
	@BeforeClass
	public void setupData()
	{
		faker=new Faker();
		userpayload=new User();
		
		userpayload.setId(Integer.toString(faker.idNumber().hashCode()));
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setUsername(faker.name().username());
		userpayload.setPassword(faker.internet().password());
		userpayload.setUserStatus(0);
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test (priority=1)
	public void testPostUser()
	{
		Response response=UserEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test (priority=2)
	public void testGetUser()
	{
	Response response=UserEndPoints.ReadUser(this.userpayload.getUsername());
	response.then().log().all();
	Assert.assertEquals(response.statusCode(), 200);
	
	}
	
	@Test(priority=3)
	public void testUpdateUser()
	{
		
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndPoints.updateUser(this.userpayload.getUsername(),userpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
	@Test (priority=4)
	public void testDeleteUser()
	{
		Response response=UserEndPoints.deleteUser(this.userpayload.getUsername());
		response.then().log().all();
	}
}
