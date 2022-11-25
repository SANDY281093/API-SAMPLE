package api.code;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class task2 {
	public static void main(String[] args) throws IOException, ParseException {
		FileReader filereader = new FileReader(
				"C:\\Users\\PRADEEP KUMAR\\eclipse-workspace\\Api\\src\\test\\resources\\ListUser.json");

		JSONParser jsonparser = new JSONParser();
		Object object = jsonparser.parse(filereader);

		JSONObject jsonobject = (JSONObject) object;
		Object jobject1 = jsonobject.get("data");
		JSONArray arry = (JSONArray)jobject1;
		for (int i = 0; i < arry.size(); i++) {
			Object object2 = arry.get(i);
			JSONObject jsonobject1 = (JSONObject)object2;
			Object object3 = jsonobject1.get("id");
			System.out.println(object3);
			Object object4 = jsonobject1.get("email");
			System.out.println(object4);
			Object object5 = jsonobject1.get("first_name");
			System.out.println(object5);
			Object object6 = jsonobject1.get("last_name");
			System.out.println(object6);
			Object object7 = jsonobject1.get("avatar");
			System.out.println(object7);
					
		}	
	}		
}
