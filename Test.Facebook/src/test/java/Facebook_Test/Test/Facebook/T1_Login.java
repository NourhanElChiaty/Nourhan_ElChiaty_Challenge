package Facebook_Test.Test.Facebook;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.annotations.Test;

public class T1_Login extends TestBase {

	@Test(priority=1)
	public void successfulLogin() throws EncryptedDocumentException, IOException, InterruptedException {
		P1_Login page = new P1_Login(browser);
		String email = ReadFile.getCellValue("TestUsers", "LoginData", 1, 0); //get email in first row
		page.email().sendKeys(email);//enter email
		String pass = ReadFile.getCellValue("TestUsers", "LoginData", 1, 1);//get password in first row
		page.password().sendKeys(pass);//enter password
		page.loginBtn().click(); //click on login btn
		Thread.sleep(2000);

		Boolean welcomeMsg = page.welcomeMsg().isDisplayed();//check if welcome msg is displayed
		String welcomeMsgString = welcomeMsg.toString();
		assertEquals(welcomeMsgString, "true");
	}

	@Test(dependsOnMethods="successfulLogin")
	public void logInWithWrongPassword() throws EncryptedDocumentException, IOException, InterruptedException {
		P1_Login page = new P1_Login(browser);
		String email = ReadFile.getCellValue("TestUsers", "LoginData", 2, 0);//get email in second row
		page.email().sendKeys(email);//enter email
		String pass = ReadFile.getCellValue("TestUsers", "LoginData", 2, 1);//get password in second row
		page.password().sendKeys(pass);//enter password
		page.loginBtn().click();//click on login btn
		Thread.sleep(2000);

		Boolean wrongPassword = page.wrongPassword().isDisplayed();//check if wrong password msg is displayed
		String wrongPasswordMsgString = wrongPassword.toString();
		assertEquals(wrongPasswordMsgString, "true");
	}
//login without entering any data
	@Test(dependsOnMethods="logInWithWrongPassword")
	public void logInWithEmptyEmail() throws EncryptedDocumentException, IOException, InterruptedException {
		P1_Login page = new P1_Login(browser);

		page.loginBtn().click();//click on login btn
		Thread.sleep(2000);

		Boolean wrongEmail = page.emptyEmail().isDisplayed();
		String wrongEmailMsgString = wrongEmail.toString();
		assertEquals(wrongEmailMsgString, "true");
	}

}
