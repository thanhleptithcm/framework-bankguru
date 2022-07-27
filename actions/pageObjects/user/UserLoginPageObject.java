package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.LocatorType;
import commons.PageGenerateManager;
import pageObjects.customer.NewCustomerPageObject;
import pageUIs.customer.NewCustomerPageUI;
import pageUIs.user.LoginPageUI;

public class UserLoginPageObject extends BasePage{
	
	private WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserRegisterPageObject clickToHereLink() {
		waitForElementClickable(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageGenerateManager.getUserRegisterPage(driver);
	}
	
	public NewCustomerPageObject clickToNewCustomer() {
		waitForElementClickable(driver, NewCustomerPageUI.NEW_CUSTOMER_LINK, LocatorType.XPATH);
		clickToElement(driver, NewCustomerPageUI.NEW_CUSTOMER_LINK, LocatorType.XPATH);
		return PageGenerateManager.getNewCustomerPage(driver);
	}

	public String getTextHeaderLoginSuccess() {
		waitForElementVisible(driver, LoginPageUI.HEADER_H3_TEXTBOX, LocatorType.CSS);
		return getElementText(driver, LoginPageUI.HEADER_H3_TEXTBOX, LocatorType.CSS);
	}

	public String getTextMangerID() {
		waitForElementVisible(driver, LoginPageUI.MANGER_ID, LocatorType.CSS);
		return getElementText(driver, LoginPageUI.MANGER_ID, LocatorType.CSS);
	}
}
