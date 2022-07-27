package pageObjects.customer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class NewCustomerPageObject extends BasePage{
	
	private WebDriver driver;
	
	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
