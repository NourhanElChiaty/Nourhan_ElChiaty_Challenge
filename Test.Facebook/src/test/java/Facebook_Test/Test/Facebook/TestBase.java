package Facebook_Test.Test.Facebook;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

public class TestBase {
	WebDriver browser;
	PropertyFile property = new PropertyFile();

	@BeforeMethod
	public void beforeMethod() throws IOException {
		if (property.getProperty("browserName").equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			browser = new ChromeDriver();
		}
//		} else if (property.getProperty("browserName").equals("FireFox")) {
//			WebDriverManager.firefoxdriver().setup();
//			browser = new FirefoxDriver();
//		}

		browser.navigate().to(property.getProperty("baseURL"));
		System.out.println(property.getProperty("baseURL"));
		browser.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		browser.quit();
	}

}
