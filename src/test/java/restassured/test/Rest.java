package restassured.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rest {
public static void main(String[] args) {
	RequestSpecification reqSpec;
     reqSpec = RestAssured.given();
    // reqSpec.header("accept","application/json");
     //1.PATH PARAMETER
     //reqSpec.pathParam("page", "2");
     //Response response = reqSpec.get("https://reqres.in/api/users/{page}");
     
    //2.QUERY PARAMETER
     //reqSpec.queryParam("page", "2");
    // Response response = reqSpec.get("https://reqres.in/api/users/2");
     
     //3.POST
    // reqSpec.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}");
   //  Response response = reqSpec.post("https://reqres.in/api/users");
     
     //4.PUT
    // reqSpec.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}");
     //Response response = reqSpec.put("https://reqres.in/api/users/2");
     
     //5.Delete
     Response response = reqSpec.delete("https://reqres.in/api/users/2");
     
     
     
     
     
     int statusCode = response.getStatusCode();
     System.out.println(statusCode);
     String asString = response.asString();
     System.out.println(asString);
     String asPrettyString = response.asPrettyString();
     System.out.println(asPrettyString);
}
}
