package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.UserLoginPageObject;

public class PageGenerateManager {
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
}
