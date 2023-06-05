package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage {
	WebDriver driver;
	ExtentTest test;
	
	public LoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(name="btnReset")
	@CacheLookup
	WebElement btnReset;
	
	@FindBy(xpath="//a[@href=\"Logout.php\"]")
	@CacheLookup
	WebElement btnLogout;
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
		test.log(LogStatus.INFO, "entered username");
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
		test.log(LogStatus.INFO, "entered password");
	}
	
	public void clickLoginButton() {
		btnLogin.click();
		test.log(LogStatus.INFO, "clicked on Login button");
	}
	
	public void clickResetButton() {
		btnReset.click();
		test.log(LogStatus.INFO, "Clicked on Reset button");
	}	
	
	public void clickLogoutButton() {
		btnLogout.click();
		test.log(LogStatus.INFO, "Clicked on Logout button");
	}	

}
