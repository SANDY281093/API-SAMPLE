package api.code;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Final {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

		FileReader file = new FileReader(
				"C:\\Users\\PRADEEP KUMAR\\eclipse-workspace\\Api\\src\\test\\resources\\Employee.json");
	
		
			ObjectMapper mapper = new ObjectMapper();
			Root readValue1 = mapper.readValue(file, Root.class);

			int page = readValue1.getPage();
			System.out.println(page);

			int per_page = readValue1.getPer_page();
			System.out.println(per_page);

			int total = readValue1.getTotal();
			System.out.println(total);

			int total_pages = readValue1.getTotal_pages();
			System.out.println(total_pages);

			ArrayList<Datum> data = readValue1.getData();
			for (Datum Datum : data) {
				System.out.println(Datum.getId());
				System.out.println(Datum.getEmail());
				System.out.println(Datum.getFirst_name());
				System.out.println(Datum.getLast_name());
				System.out.println(Datum.getAvatar());

			}

			Support support = readValue1.getSupport();

			String url = support.getUrl();
			System.out.println(url);

			String text = support.getText();
			System.out.println(text);

	}

}
