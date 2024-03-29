package com.bankguru.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGenerateManager;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class User_01_Register_Login extends BaseTest{
	
	private WebDriver driver;
	private String emailAddress;
	public static String userID, userPassword;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGenerateManager.getUserLoginPage(driver);

		emailAddress = "matas" + generateFakeNumber() + "@mail.vn";
	}

	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "Start Register");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click To Here Link");
		registerPage = loginPage.clickToHereLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Input Email Address With Value: " + emailAddress);
		registerPage.inputToTextboxByName(driver, "emailid", emailAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Click To Login Button");
		registerPage.clickToButtonByName(driver, "btnLogin");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Get Text User ID");
		userID = registerPage.getTextUserId();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Get Text Password");
		userPassword = registerPage.getTextPassword();
	}
	
	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "Start Login");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Open Login Page");
		loginPage = registerPage.openLoginPage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input User ID With Value: " + userID);
		loginPage.inputToTextboxByName(driver, "uid", userID);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Input Password With Value: " + userPassword);
		loginPage.inputToTextboxByName(driver, "password", userPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click To Login Button");
		loginPage.clickToButtonByName(driver, "btnLogin");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify Text Header");
		verifyEquals(loginPage.getTextHeaderLoginSuccess(), "Welcome To Manager's Page of Guru99 Bank");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Verify Manger Id: " + userID);
		verifyEquals(loginPage.getTextMangerID(), "Manger Id : " + userID);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
