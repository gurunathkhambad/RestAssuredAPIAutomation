package Day5;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.io.File;

public class FileUploadAndDownload {

	@Test 
	void singleFileUpload()
	{
		
		File myFile= new File("C:\\RahulShetty\\APITesting\\StudentsDetails.txt");
		given() 
		.multiPart("File",myFile)
		.contentType("multipart/form-data")
		.when()
		
		.then();
		
	}
}
