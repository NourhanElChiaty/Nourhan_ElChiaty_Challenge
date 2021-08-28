package BestBuy_API.API.BestBuy;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteStore {
	@Test
	public void deleteStore() {
		new RestAssured();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject reqparam = new JSONObject();

		

		request.body(reqparam.toJSONString());
		Response response = request.param("name", "TestStore").delete("http://localhost:3030/stores");

		int statusCode = response.statusCode();
		String statusCodeString = Integer.toString(statusCode);
		try {
			assertEquals(statusCodeString, "200");
			System.out.println("Test case is passed");
		} catch (AssertionError e) {
			System.out.println("Test case is failed");
			System.out.println("Expected 200 but found" + statusCode);
		}
	}
}
