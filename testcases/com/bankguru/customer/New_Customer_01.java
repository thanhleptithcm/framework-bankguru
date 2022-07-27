package com.bankguru.customer;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGenerateManager;
import pageObjects.customer.NewCustomerPageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class New_Customer_01  extends BaseTest{
	
	private WebDriver driver;
	private NewCustomerPageObject newCustomerPage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	
	public String userID, userPassword;
	private String customerName, gender, dateOfBirth, addressInput, addressOutput, city, state, pinNumber, phoneNumber, email, password;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGenerateManager.getUserLoginPage(driver);
		
		customerName = "Le Thanh";
		gender = "male";
		dateOfBirth = "1990-01-31";
		addressInput = "123 Los Angeles\nUnited States";
		addressOutput = "123 Los Angeles United States";
		city = "New York";
		state = "California";
		pinNumber = "632565";
		phoneNumber = "0987569584";
		email = "matas" + generateFakeNumber() + "@mail.vn";
		password = "123456";
		
		ExtentTestManager.getTest().log(Status.INFO, "Pre-Condition - Step 01: Click To Here Link");
		registerPage = loginPage.clickToHereLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Pre-Condition - Step 02: Input Email Address With Value: " + email);
		registerPage.inputToTextboxByName(driver, "emailid", email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Pre-Condition - Step 03: Click To Login Button");
		registerPage.clickToButtonByName(driver, "btnLogin");

		ExtentTestManager.getTest().log(Status.INFO, "Pre-Condition - Step 04: Get Text User ID");
		userID = registerPage.getTextUserId();
		
		ExtentTestManager.getTest().log(Status.INFO, "Pre-Condition - Step 05: Get Text Password");
		userPassword = registerPage.getTextPassword();
		
		ExtentTestManager.getTest().log(Status.INFO, "Pre-Condition - Step 06: Open Login Page");
		loginPage = registerPage.openLoginPage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Pre-Condition - Step 07: Input User ID With Value: " + userID);
		loginPage.inputToTextboxByName(driver, "uid", userID);
		
		ExtentTestManager.getTest().log(Status.INFO, "Pre-Condition - Step 08: Input Password With Value: " + userPassword);
		loginPage.inputToTextboxByName(driver, "password", userPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Pre-Condition - Step 09: Click To Login Button");
		loginPage.clickToButtonByName(driver, "btnLogin");
	}

	@Test
	public void Customer_01_New_Account(Method method) {
		ExtentTestManager.startTest(method.getName(), "New Customer");
		ExtentTestManager.getTest().log(Status.INFO, "New Customer - Step 01: Click To New Customer Link");
		newCustomerPage = loginPage.clickToNewCustomer();
		
		ExtentTestManager.getTest().log(Status.INFO, "New Customer - Step 02: Input Email with value: " + customerName);
		newCustomerPage.inputToTextboxByName(driver, "name", customerName);
		
		ExtentTestManager.getTest().log(Status.INFO, "New Customer - Step 03: Input DOB with value: " + dateOfBirth);
		newCustomerPage.inputToTextboxByName(driver, "dob", dateOfBirth);
		
		ExtentTestManager.getTest().log(Status.INFO, "New Customer - Step 04: Input Address with value: " + addressInput);
		newCustomerPage.inputToTextboxByName(driver, "addr", addressInput);
		
		ExtentTestManager.getTest().log(Status.INFO, "New Customer - Step 05: Input City with value: " + city);
		newCustomerPage.inputToTextboxByName(driver, "city", city);
		
		ExtentTestManager.getTest().log(Status.INFO, "New Customer - Step 06: Input State with value: " + state);
		newCustomerPage.inputToTextboxByName(driver, "state", state);
		
		ExtentTestManager.getTest().log(Status.INFO, "New Customer - Step 07: Input Pin Number with value: " + pinNumber);
		newCustomerPage.inputToTextboxByName(driver, "pinno", pinNumber);
		
		ExtentTestManager.getTest().log(Status.INFO, "New Customer - Step 08: Input Phone Number with value: " + phoneNumber);
		newCustomerPage.inputToTextboxByName(driver, "telephoneno", phoneNumber);
		
		ExtentTestManager.getTest().log(Status.INFO, "New Customer - Step 09: Input Email with value: " + email);
		newCustomerPage.inputToTextboxByName(driver, "emailid", email);
		
		ExtentTestManager.getTest().log(Status.INFO, "New Customer - Step 10: Input Password with value: " + password);
		newCustomerPage.inputToTextboxByName(driver, "password", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "New Customer - Step 11: Click To Submit Button");
		newCustomerPage.clickToButtonByName(driver, "sub");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
