package integrate.api;

//import org.testng.annotations.Test;

import org.junit.Test;

import baseclass.BaseClass;
import io.restassured.response.Response;

public class Sample  extends BaseClass{
	@Test
	public void createUser() {
		addHeader("accept", "application/json");
		addbody("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}");
		Response response = requestType("POST", "https://reqres.in/api/users");
       int statusCode = getStatusCode(response);
       System.out.println(statusCode);
       String asPrettyString = getResBodyAsPrettyString(response);
       System.out.println(asPrettyString);
       
       
	}

	

}
