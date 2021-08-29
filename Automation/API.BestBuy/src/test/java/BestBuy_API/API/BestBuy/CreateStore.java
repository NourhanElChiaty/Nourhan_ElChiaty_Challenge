package BestBuy_API.API.BestBuy;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateStore {
  @Test(priority=1)
  public void createStore() {
	  String requestBody= "{\n" + 
	  		"            \"name\": \"TestStore\",\n" + 
	  		"            \"type\": \"TestType\",\n" + 
	  		"            \"address\": \"TestAdress\",\n" + 
	  		"            \"address2\": \"\",\n" + 
	  		"            \"city\": \"Test\",\n" + 
	  		"            \"state\": \"Test\",\n" + 
	  		"            \"zip\": \"55305\",\n" + 
	  		"            \"lat\": 44.969658,\n" + 
	  		"            \"lng\": -93.449539,\n" + 
	  		"            \"hours\": \"Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8\"\n" + 
	  		"          \n" + 
	  		"}";
		new RestAssured();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject reqparam = new JSONObject();

		request.body(reqparam.toJSONString());
		Response response = request.body(requestBody).post("http://localhost:3030/stores");
		int statusCode = response.statusCode();
		String statusCodeString = Integer.toString(statusCode);
		try {
			assertEquals(statusCodeString, "201");
			System.out.println("Test case 1 is passed");
		} catch (AssertionError e) {
			System.out.println("Test case 1 is failed");
			System.out.println("Expected 200 but found " + statusCode);
		}

	}

	@Test(dependsOnMethods = "createStore")
	public void createStorewithoutBody() {
		String requestBody = "";
		new RestAssured();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject reqparam = new JSONObject();

		request.body(reqparam.toJSONString());
		Response response = request.body(requestBody).post("http://localhost:3030/stores");
		int statusCode = response.statusCode();
		String statusCodeString = Integer.toString(statusCode);
		try {
			assertEquals(statusCodeString, "400");
			System.out.println("Test case 2 is passed");
		} catch (AssertionError e) {
			System.out.println("Test case 2 is failed");
			System.out.println("Expected 400 but found " + statusCode);
		}

	}
}
