package api.code;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class task1 {
	public static void main(String[] args) throws IOException, ParseException {

		FileReader filereader = new FileReader(
				"C:\\Users\\PRADEEP KUMAR\\eclipse-workspace\\Api\\src\\test\\resources\\Filename.json");

		JSONParser jsonparser = new JSONParser();
		Object object = jsonparser.parse(filereader);

		JSONObject jsonobject = (JSONObject) object;
		Object jobject1 = jsonobject.get("data");

		JSONObject jsonobject1 = (JSONObject) jobject1;

		// id
		Object object2 = jsonobject1.get("id");
		String string7 = object2.toString();
		System.out.println(string7);

		// email
		Object object3 = jsonobject1.get("email");
		String string1 = (String) object3;
		System.out.println(string1);

		// first name
		Object object4 = jsonobject1.get("first_name");
		String string2 = (String) object4;
		System.out.println(string2);

		// last name
		Object object5 = jsonobject1.get("last_name");
		String string3 = (String) object5;
		System.out.println(object5);

		// avatar
		Object object6 = jsonobject1.get("avatar");
		String string4 = (String) object6;
		System.out.println(string4);

		// support
		Object jobject2 = jsonobject.get("support");

		JSONObject jsonobject2 = (JSONObject) jobject2;

		// url
		Object object7 = jsonobject2.get("url");
		String string5 = (String) object7;
		System.out.println(string5);

		// text
		Object object8 = jsonobject2.get("text");
		String string6 = (String) object8;
		System.out.println(string6);

	}

}
