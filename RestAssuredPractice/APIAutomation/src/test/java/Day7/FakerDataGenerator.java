package Day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {

	@Test 
	void fakerGenerator()
	{
		Faker faker=new Faker();
		
		String firstName=faker.name().firstName();
		String lastName=faker.name().lastName();
		String fullName=faker.name().fullName();
		String userName=faker.name().username();
		String email=faker.internet().emailAddress();
		String pwd=faker.internet().password();
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(fullName);
		System.out.println(userName);
		System.out.println(email);
		System.out.println(pwd);
		
	}
}
