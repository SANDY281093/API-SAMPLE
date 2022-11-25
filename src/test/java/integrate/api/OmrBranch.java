package integrate.api;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class OmrBranch extends BaseClass {
	String logtoken;
	String state_id;
	int stateId;
	int cityId;
	String address_id;
	@Test(priority=1)
	public void BasicAuthenication() {
		addHeader("accept", "application/login");
		basicAuth("santhos281093@gmail.com", "SANdy@93");
		Response response = requestType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode,200,"verify status code");
		
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String message = login_Output_Pojo.getMessage();
	    System.out.println(message);
		Assert.assertEquals(message,"Login successfully","verify login successfully");
	    logtoken = login_Output_Pojo.getData().getLogtoken();
	}

	
	@Test(priority=2)
	public void getStateList() {
		addHeader("accept", "application/login");
		Response response = requestType("GET", "https://omrbranch.com/api/stateList");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode,200,"verify status code");
		GetStateList_Output_Pojo getStateList_Output_Pojo = response.as(GetStateList_Output_Pojo.class);
		ArrayList<StateList> listState = getStateList_Output_Pojo.getData();
		for (StateList eachStateList : listState) {
			String StateName = eachStateList.getName();
			if (StateName.equals("Tamil Nadu")) {
				stateId = eachStateList.getId();
				state_id=String.valueOf(stateId);
				System.out.println(stateId);
				Assert.assertEquals(StateName,"Tamil Nadu","verify state name is Tamil Nadu");
				break;	
			}			
		}
	
	}
	@Test(priority=3)
	public void getCityList() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Content-Type","application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		
		GetCityList_Input_Pojo getCityList_Input_Pojo=new GetCityList_Input_Pojo(state_id);
		addBody(getCityList_Input_Pojo);
		Response response = requestType("POST", "https://omrbranch.com/api/cityList");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode,200,"verify status code");
		GetCityList_Output_Pojo getCityList_Output_Pojo = response.as(GetCityList_Output_Pojo.class);
		 
		ArrayList<CityList> listCityDetails = getCityList_Output_Pojo.getData();
		for (CityList eachCityList : listCityDetails) {
			String cityName = eachCityList.getName();
			if (cityName.equals("Tirunelveli")) {
				cityId = eachCityList.getId();
				System.out.println(cityId);
				Assert.assertEquals(cityName, "Tirunelveli","verify city name is Tirunelveli");
				break;
			}
			
		}
	
	}
	@Test(priority=4)
	public void addUserAddress() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Authorization","Bearer "+logtoken);
		Header h3=new Header("Content-Type","application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		AddUserAddress_Input_Pojo  addUserAddress_Input_Pojo=new AddUserAddress_Input_Pojo("SANTHOSH KUMAR","S","9489689561","MS",stateId,cityId,103,"TRICHY","621211","Home");
		addBody(addUserAddress_Input_Pojo);
		Response response = requestType("POST", "https://omrbranch.com/api/addUserAddress");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode,200,"verify status code");
		AddUserAddress_Output_Pojo 	addUserAddress_Output_Pojo =response.as(AddUserAddress_Output_Pojo.class ); 
		String message = addUserAddress_Output_Pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address added successfully","verify Address added successfully");
		int id = addUserAddress_Output_Pojo.getAddress_id();
		System.out.println(id);
		address_id = String.valueOf(id);
	}
	@Test(priority=5)
	public void updateUserAddress() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Authorization","Bearer "+logtoken);
		Header h3=new Header("Content-Type","application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Poj=new UpdateUserAddress_Input_Pojo(address_id,"SANDY","S","9489689561","MS",stateId,cityId,103,"621211","TRICHY","Home");
		addBody(updateUserAddress_Input_Poj);
		Response response = requestType("PUT", "https://omrbranch.com/api/updateUserAddress");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode,200,"verify status code");
		UpdateuserAddress_Output_Pojo updateuserAddress_Output_Pojo=response.as(UpdateuserAddress_Output_Pojo.class);
		String message = updateuserAddress_Output_Pojo.getMessage();
		System.out.println(message);
		
		Assert.assertEquals(message,"Address updated successfully","verify Address updated successfully");
		
	}
	@Test(priority=6)
	public void getUserAddress() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Authorization","Bearer "+logtoken);
		listHeader.add(h1);
		listHeader.add(h2);	
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		Response response = requestType("GET", "https://omrbranch.com/api/getUserAddress");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode,200,"verify status code");
		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo=response.as(GetUserAddress_Output_Pojo.class);
	    String message = getUserAddress_Output_Pojo.getMessage();
	    System.out.println(message);
	    Assert.assertEquals(message,"OK","verify get address OK");	
    }
	
	@Test(priority=7)
	public void deleteUserAddress() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Authorization","Bearer "+logtoken);
		Header h3=new Header("Content-Type","application/json");
		listHeader.add(h3);
		listHeader.add(h1);
		listHeader.add(h2);	
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo=new DeleteUserAddress_Input_Pojo(address_id);
		addBody(deleteUserAddress_Input_Pojo);
		
		Response response = requestType("DELETE", "https://omrbranch.com/api/deleteAddress");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode,200,"verify status code");
		
		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo=response.as(DeleteUserAddress_Output_Pojo.class);
		String message = deleteUserAddress_Output_Pojo.getMessage();	
		System.out.println(message);
		Assert.assertEquals(message,"Address deleted successfully","verify Address deleted successfully");	
		
   }
	@Test(priority=8)
	public void searchProduct() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Content-Type","application/json");	
		listHeader.add(h1);
		listHeader.add(h2);	
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
	
	ProductSearch_Input_Pojo productSearch_Input_Pojo=new  ProductSearch_Input_Pojo("nuts");
	addBody(productSearch_Input_Pojo);
	Response response = requestType("POST", "https://omrbranch.com/api/searchProduct");
	int statusCode = getStatusCode(response);
	System.out.println(statusCode);
	Assert.assertEquals(statusCode,200,"verify status code");
	ProductSearch_Output_Pojo productSearch_Output_Pojo = response.as(ProductSearch_Output_Pojo.class);
	String message = productSearch_Output_Pojo.getMessage();
	Assert.assertEquals(message, "OK","verify OK product search");
	
	}
	@Test(priority=9)
	public void changeProfilePic() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Content-Type","multipart/form-data");
		Header h3=new Header("Authorization","Bearer "+logtoken);
		listHeader.add(h1);
		listHeader.add(h2);	
		listHeader.add(h3);	
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		
	addForm("profile_picture", new File("C:\\Users\\PRADEEP KUMAR\\eclipse-workspace\\Api\\Images\\god-vinayagar-png-images-4593005.png"));
		
	Response response = requestType("POST", "https://omrbranch.com/api/changeProfilePic");
	int statusCode = getStatusCode(response);
	System.out.println(statusCode);
	Assert.assertEquals(statusCode,200,"verify status code");
	
	ChangeProfilePic_Output_Pojo changeProfilePic_Output_Pojo=response.as(ChangeProfilePic_Output_Pojo.class);
	String message = changeProfilePic_Output_Pojo.getMessage();
	
	Assert.assertEquals(message,"Profile updated Successfully","verify Profile updated Successfully");
	}
}
