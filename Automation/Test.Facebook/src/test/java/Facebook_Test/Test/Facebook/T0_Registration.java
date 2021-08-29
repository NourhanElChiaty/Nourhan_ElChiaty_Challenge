package Facebook_Test.Test.Facebook;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T0_Registration extends TestBase {

//successful registration
	@Test
	public void successfulRegistration() throws EncryptedDocumentException, IOException, InterruptedException {
		P0_Registration registrationPage = new P0_Registration(browser);
		registrationPage.createAccount().click(); // press on create account btn
		Thread.sleep(2000);

		String firstName = ReadFile.getCellValue("TestUsers", "RegisterationData", 1, 0); // get first name in first row
		registrationPage.firstName().click();
		registrationPage.firstName().sendKeys(firstName); // enter first name
		String surName = ReadFile.getCellValue("TestUsers", "RegisterationData", 1, 1);// get sur name in first row
		registrationPage.surName().sendKeys(surName); // enter sur name
		String email = ReadFile.getCellValue("TestUsers", "RegisterationData", 1, 2);// get email in first row
		registrationPage.email().sendKeys(email); // enter email
		registrationPage.re_enterEmail().sendKeys(email);// re_enter email
		String password = ReadFile.getCellValue("TestUsers", "RegisterationData", 1, 3);// get password in first row
		registrationPage.password().sendKeys(password);// enter password
		Thread.sleep(2000);
		WebElement randomDay = registrationPage.dayOfBirth(); // get a random day
		randomDay.click();// click on it
		WebElement randomMonth = registrationPage.monthOfBirth();// get a random month
		randomMonth.click();// click on it

		WebElement randomYear = registrationPage.yearOfBirth();// get a random year
		randomYear.click();// click on it
		Thread.sleep(2000);

		WebElement randomGender = registrationPage.gender();// get a random gender
		randomGender.click();// click on it
		Thread.sleep(3000);
		registrationPage.signUpBtn().click(); // click on signup btn
		Thread.sleep(2000);	
		Boolean errorMsg = registrationPage.errorMsg().isDisplayed(); // check if any error msg is displayed
		String errorMsgString = errorMsg.toString();// convert it to string
		assertEquals(errorMsgString, "false"); // assert

	}

	@Test
	public void RegisterError() throws EncryptedDocumentException, IOException, InterruptedException {
		P0_Registration registerationPage = new P0_Registration(browser);
		registerationPage.createAccount().click();// press on create account btn
		Thread.sleep(2000);

		String firstName = ReadFile.getCellValue("TestUsers", "RegisterationData", 2, 0);// get first name in second row
		registerationPage.firstName().click();
		registerationPage.firstName().sendKeys(firstName);// enter first name
		String surName = ReadFile.getCellValue("TestUsers", "RegisterationData", 2, 1);// get sur name in second row
		registerationPage.surName().sendKeys(surName);// enter sur name
		String email = ReadFile.getCellValue("TestUsers", "RegisterationData", 2, 2);// get email in second row
		registerationPage.email().sendKeys(email);// enter email
		registerationPage.re_enterEmail().sendKeys(email);// re_enter email
		String password = ReadFile.getCellValue("TestUsers", "RegisterationData", 2, 3);// get password in second row
		registerationPage.password().sendKeys(password);// enter password
		Thread.sleep(2000);
		WebElement randomDay = registerationPage.dayOfBirth();// get a random day
		randomDay.click();// click on it
		WebElement randomMonth = registerationPage.monthOfBirth();// get a random month
		randomMonth.click();// click on it

		WebElement randomYear = registerationPage.yearOfBirth();// get a random year
		randomYear.click();// click on it
		Thread.sleep(2000);

		WebElement randomGender = registerationPage.gender();// get a random gender
		randomGender.click();// click on it
		Thread.sleep(3000);
		registerationPage.signUpBtn().click(); // click on signup btn
		Thread.sleep(3000);
		Boolean errorMsg = registerationPage.errorMsg().isDisplayed();// check if any error msg is displayed
		String errorMsgString = errorMsg.toString();// convert it to string
		assertEquals(errorMsgString, "true");//assert

	}

}
