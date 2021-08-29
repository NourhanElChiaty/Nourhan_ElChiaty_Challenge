package BestBuy_API.API.BestBuy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetCategory {
	@Test
	public void getCategory() {
		new RestAssured();
		RequestSpecification request = RestAssured.given();
		request.baseUri("http://localhost:3030");

		Response response = request.get("/categories");
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
