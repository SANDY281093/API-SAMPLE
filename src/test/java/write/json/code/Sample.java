package write.json.code;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sample {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		File file = new File(
				"C:\\Users\\PRADEEP KUMAR\\eclipse-workspace\\Api\\src\\test\\resources\\write.json");
		ObjectMapper mapper = new ObjectMapper();
		Support s =new Support("https://reqres.in/#support-heading","To keep ReqRes free, contributions towards server costs are appreciated!");
		
		List<Datum> data = new ArrayList <Datum>();
		Datum e1=new Datum(7,
	            "michael.lawson@reqres.in",
	            "Michael",
	            "Lawson",
	            "https://reqres.in/img/faces/7-image.jpg");
		Datum e2=new Datum(8,
	            "lindsay.ferguson@reqres.in",
	            "Lindsay",
	            "Ferguson",
	            "https://reqres.in/img/faces/8-image.jpg");
		Datum e3=new Datum(9,
	            "tobias.funke@reqres.in",
	            "Tobias",
	            "Funke",
	            "https://reqres.in/img/faces/9-image.jpg");
		Datum e4=new Datum(10,
	            "byron.fields@reqres.in",
	            "Byron",
	            "Fields",
	            "https://reqres.in/img/faces/10-image.jpg");
		Datum e5=new Datum(11,
	            "george.edwards@reqres.in",
	            "George",
	            "Edwards",
	            "https://reqres.in/img/faces/11-image.jpg");
		Datum e6=new Datum(12,
	            "rachel.howell@reqres.in",
	            "Rachel",
	            "Howell",
	            "https://reqres.in/img/faces/12-image.jpg");
		data.add(e1);
		data.add(e2);
		data.add(e3);
		data.add(e4);
		data.add(e5);
		data.add(e6);
		

		
	     Root  r =new Root(2, 6, 12, 2, data , s);
	     mapper.writeValue(file, r);

	}}

