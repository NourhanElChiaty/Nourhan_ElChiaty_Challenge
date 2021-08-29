package Facebook_Test.Test.Facebook;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P0_Registration extends PageBase {

	public P0_Registration(WebDriver browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	public WebElement createAccount() {
		WebElement createAccount = browser.findElement(By.xpath("//*[text()=\"Create New Account\"]"));
		return createAccount;
	}

	//
	public WebElement firstName() {
		WebElement firstName = browser.findElement(By.name("firstname"));
		return firstName;

	}

	public WebElement surName() {
		WebElement surName = browser.findElement(By.name("lastname"));
		return surName;

	}

	public WebElement email() {
		WebElement surName = browser.findElement(By.name("reg_email__"));
		return surName;

	}

	public WebElement re_enterEmail() {
		WebElement surName = browser.findElement(By.name("reg_email_confirmation__"));
		return surName;

	}

	public WebElement password() {
		WebElement password = browser.findElement(By.name("reg_passwd__"));
		return password;

	}

	public WebElement dayOfBirth() {
		List<WebElement> days = browser.findElements(By.xpath("//select[@id=\"day\"]/option"));
		int daysSize = days.size();
		int randomDay = ThreadLocalRandom.current().nextInt(1, daysSize);
		WebElement selectedDay = days.get(randomDay);
		return selectedDay;
	}

	public WebElement monthOfBirth() {
		List<WebElement> months = browser.findElements(By.xpath("//select[@id=\"month\"]/option"));
		int monthsSize = months.size();
		int randomMonth = ThreadLocalRandom.current().nextInt(1, monthsSize);
		WebElement selectedDay = months.get(randomMonth);
		return selectedDay;
	}

	public WebElement yearOfBirth() {
		List<WebElement> years = browser.findElements(By.xpath("//select[@id=\"year\"]/option"));
		int yearsSize = years.size();
		int randomyear = ThreadLocalRandom.current().nextInt(1, yearsSize);
		WebElement selectedDay = years.get(randomyear);
		return selectedDay;
	}

	public WebElement gender() {
		List<WebElement> gender = browser.findElements(By.xpath("//span[@class=\"_5k_3\"]/span/input"));
		// int genderSize = gender.size();
		int randomGender = ThreadLocalRandom.current().nextInt(0, 2);
		WebElement selectedDay = gender.get(randomGender);
		return selectedDay;
	}

	public WebElement signUpBtn() {
		WebElement signUpBtn = browser.findElement(By.name("websubmit"));
		return signUpBtn;
	}

	public WebElement errorMsg() {
		WebElement errorMsg = browser.findElement(By.id("reg_error_inner"));
		return errorMsg;
	}
}
