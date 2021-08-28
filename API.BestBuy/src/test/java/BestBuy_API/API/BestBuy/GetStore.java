package BestBuy_API.API.BestBuy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetStore {
	@Test(priority = 1)
	public void GetAllStores() {
		new RestAssured();
		RequestSpecification request = RestAssured.given();
		request.baseUri("http://localhost:3030");

		Response response = request.get("/stores");
		int statusCode = response.statusCode();
		String statusCodeString = Integer.toString(statusCode);
		try {
			assertEquals(statusCodeString, "200");
			System.out.println("Test case 1 is passed");
		} catch (AssertionError e) {
			System.out.println("Test case 1 is failed");
			System.out.println("Expected 200 but found" + statusCode);
		}
	}

	@Test(dependsOnMethods = "GetAllStores")
	public void GetExistingStore() {
		new RestAssured();
		RequestSpecification request = RestAssured.given();
		request.baseUri("http://localhost:3030");

		Response response = request.param("id", "10").get("/stores");
		int statusCode = response.statusCode();
		String statusCodeString = Integer.toString(statusCode);
		try {
			assertEquals(statusCodeString, "200");
			System.out.println("Test case 2 is passed");
		} catch (AssertionError e) {
			System.out.println("Test case 2 is failed");
			System.out.println("Expected 200 but found " + statusCode);
		}
	}

	@Test(dependsOnMethods = "GetExistingStore")
	public void GetNotExistingStore() {
		new RestAssured();
		RequestSpecification request = RestAssured.given();
		request.baseUri("http://localhost:3030");

		Response response = request.param("id", "5").get("/stores");
		int statusCode = response.statusCode();
		String statusCodeString = Integer.toString(statusCode);
		try {
			assertEquals(statusCodeString, "404");
			System.out.println("Test case 3 is passed");
		} catch (AssertionError e) {
			System.out.println("Test case 3 is failed");
			System.out.println("Expected 404 but found " + statusCode);
		}
	}
}
