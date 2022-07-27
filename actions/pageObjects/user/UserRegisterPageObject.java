package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGenerateManager;
import pageUIs.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage{
	
	private WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextUserId() {
		waitForElementVisible(driver, RegisterPageUI.USER_ID_TEXTBOX);
		return getElementTextByXpath(driver, RegisterPageUI.USER_ID_TEXTBOX);
	}

	public String getTextPassword() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		return getElementTextByXpath(driver, RegisterPageUI.PASSWORD_TEXTBOX);
	}

	public UserLoginPageObject openLoginPage() {
		openPageUrl(driver, GlobalConstants.NORMAL_URL);
		return PageGenerateManager.getUserLoginPage(driver);
	}
}
