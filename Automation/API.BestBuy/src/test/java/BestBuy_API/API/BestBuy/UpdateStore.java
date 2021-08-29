package BestBuy_API.API.BestBuy;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateStore {
  @Test(priority=1)
  public void updateStore() {
	  String requestBody="{\n" + 
	  		"            \"name\": \"Minnetonka\",\n" + 
	  		"            \"type\": \"BigBoxTest\",\n" + 
	  		"            \"address\": \"13513 Ridgedale Dr\",\n" + 
	  		"            \"address2\": \"\",\n" + 
	  		"            \"city\": \"Hopkins\",\n" + 
	  		"            \"state\": \"MN\",\n" + 
	  		"            \"zip\": \"55305\",\n" + 
	  		"            \"lat\": 44.969658,\n" + 
	  		"            \"lng\": -93.449539,\n" + 
	  		"            \"hours\": \"Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8\"\n" + 
	  		"}";
	  new RestAssured();
	RequestSpecification request = RestAssured.given();
	  request.header("Content-Type","application/json");
	  JSONObject reqparam = new JSONObject();
	 
	
	  
	  request.body(reqparam.toJSONString());
	  Response response = request.body(requestBody).put("http://localhost:3030/stores/4");
	  
	  int statusCode =response.statusCode();
	  String statusCodeString = Integer.toString(statusCode);
	  try {
	  assertEquals(statusCodeString, "200");
	  System.out.println("Test case is passed");
	  }
	  catch(AssertionError e) {
		  System.out.println("Test case is failed");
		  System.out.println("Expected 200 but found "+ statusCode);
	  }
  }
  
  @Test(dependsOnMethods="updateStore")
  public void updateStoreWithoutBody() {
	  String requestBody="";
	  new RestAssured();
	RequestSpecification request = RestAssured.given();
	  request.header("Content-Type","application/json");
	  JSONObject reqparam = new JSONObject();
	 
	
	  
	  request.body(reqparam.toJSONString());
	  Response response = request.body(requestBody).put("http://localhost:3030/stores/4");
	  
	  int statusCode =response.statusCode();
	  String statusCodeString = Integer.toString(statusCode);
	  try {
	  assertEquals(statusCodeString, "400");
	  System.out.println("Test case is passed");
	  }
	  catch(AssertionError e) {
		  System.out.println("Test case is failed");
		  System.out.println("Expected 200 but found "+ statusCode);
	  }
  
  }
	 @Test(dependsOnMethods="updateStoreWithoutBody")
	  public void updateNonExistingStore() {
		  String requestBody="{\n" + 
		  		"            \"name\": \"Minnetonka\",\n" + 
		  		"            \"type\": \"BigBoxTest\",\n" + 
		  		"            \"address\": \"13513 Ridgedale Dr\",\n" + 
		  		"            \"address2\": \"\",\n" + 
		  		"            \"city\": \"Hopkins\",\n" + 
		  		"            \"state\": \"MN\",\n" + 
		  		"            \"zip\": \"55305\",\n" + 
		  		"            \"lat\": 44.969658,\n" + 
		  		"            \"lng\": -93.449539,\n" + 
		  		"            \"hours\": \"Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8\"\n" + 
		  		"}";
		  new RestAssured();
		RequestSpecification request = RestAssured.given();
		  request.header("Content-Type","application/json");
		  JSONObject reqparam = new JSONObject();
		 
		
		  
		  request.body(reqparam.toJSONString());
		  Response response = request.body(requestBody).put("http://localhost:3030/stores/9000");
		  
		  int statusCode =response.statusCode();
		  String statusCodeString = Integer.toString(statusCode);
		  try {
		  assertEquals(statusCodeString, "404");
		  System.out.println("Test case is passed");
		  }
		  catch(AssertionError e) {
			  System.out.println("Test case is failed");
			  System.out.println("Expected 404 but found "+ statusCode);
		  }
	  }
}
