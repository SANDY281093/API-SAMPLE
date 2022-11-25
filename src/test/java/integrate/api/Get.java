package integrate.api;

//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.junit.Test;

import baseclass.BaseClass;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class Get extends BaseClass {
	@Test

	public void getUser() throws ParseException {
		addHeader("accept","application/json");
		Response response = requestType("GET"," https://reqres.in/api/users?page=2");
		
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		
		String asPrettyString = getResBodyAsPrettyString(response);
		System.out.println(asPrettyString);
		
//		JSONParser jsonparser = new JSONParser();
//		Object object = jsonparser.parse(asPrettyString);
//		
//		JSONObject object2=(JSONObject) object;
//		Object object3 = object2.get("data");
//		
//		JSONArray array = (JSONArray)object3;
//		Object object4 = array.get(0);
//		//String string1 = (String) object4;
//		System.out.println(object4);
//		
//		JSONObject object5=(JSONObject) object4;
//		Object object6 = object5.get("first_name");
//		String string1 = (String) object6;
//		System.out.println(string1);
		
	//
		
		//Assert.assertEquals(object6, "Michael","Verify firstname");
				
		JsonPath jsonPath = response.jsonPath();
     	Object object = jsonPath.get("data[0]");
     //	String string1 = (String) object;
     	System.out.println(object);
//																		//		Map<String,String> s=(LinkedHashMap<String, String>)object;
																		//		Set<Entry<String, String>> entrySet = s.entrySet();
																		//		
																		//		for(Entry<String, String>x:entrySet ) {
																		//		System.out.println(x);
																		//		}
																		//		
		
		
		
	}
}