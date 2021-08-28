package Facebook_Test.Test.Facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_Login extends PageBase {

	public P1_Login(WebDriver browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement email() {
		WebElement email = browser.findElement(By.id("email"));
		return email;
	}
	public WebElement password() {
		WebElement password = browser.findElement(By.id("pass"));
		return password;
	}
	
	public WebElement loginBtn() {
		WebElement btn = browser.findElement(By.name("login"));
		return btn;
	}
	
	public WebElement welcomeMsg() {
		WebElement welcome = browser.findElement(By.xpath("//div[@class=\"bcvklqu9 nzypyw8j\"]"));
		return welcome;
	}
	public WebElement wrongPassword() {
		WebElement wrongPassword = browser.findElement(By.partialLinkText("Forgotten password?"));
		return wrongPassword;
	}
	public WebElement emptyEmail() {
		WebElement emptyEmail = browser.findElement(By.partialLinkText("Find your account and log in."));
		return emptyEmail;
	}
}
