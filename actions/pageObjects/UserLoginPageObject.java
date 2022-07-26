package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.LoginPageUI;

public class UserLoginPageObject extends BasePage{
	
	private WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

//	public UserHomePageObject clickToLoginButton() {
//		 waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
//		 clickToElement(driver, LoginPageUI.LOGIN_BUTTON);	  
//		 return PageGenerateManager.getUserHomePage(driver);
//	}

	public void inputPassword(String textValue) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, textValue);
	}

	public void clickToHereLink() {
		waitForElementClickable(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
	}

	public String getTextUserId() {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		return getElementTextByXpath(driver, LoginPageUI.USER_ID_TEXTBOX);
	}

	public String getTextPassword() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		return getElementTextByXpath(driver, LoginPageUI.PASSWORD_TEXTBOX);
	}

	public String getTextHeaderLoginSuccess() {
		waitForElementVisible(driver, LoginPageUI.HEADER_H3_TEXTBOX);
		return getElementTextByXpath(driver, LoginPageUI.HEADER_H3_TEXTBOX);
	}

	public String getTextMangerID() {
		waitForElementVisible(driver, LoginPageUI.MANGER_ID);
		return getElementTextByXpath(driver, LoginPageUI.MANGER_ID);
	}
}
