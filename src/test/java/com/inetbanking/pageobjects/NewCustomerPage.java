package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

public class NewCustomerPage {
	
	WebDriver driver;
	
	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,\"addcustomer\")]")
	@CacheLookup
	WebElement linkNewCustomer;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement textCustomerName;
	
	@FindBy(xpath="(//input[@name='rad1'])[1]")
	@CacheLookup
	WebElement radiobtnMale;
	
	@FindBy(xpath="(//input[@name='rad1'])[2]")
	@CacheLookup
	WebElement radiobtnFemale;
	
	@FindBy(id="dob")
	@CacheLookup
	WebElement textDOB;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement textAddress;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement textCity;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement textState;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement textPin;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement textPhoneno;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement textEmail;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement textPassword;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(name="res")
	@CacheLookup
	WebElement btnReset;
	
	public void clickNewCustomerLink() {
		linkNewCustomer.click();
	}
	
	public void setCustomerName(String customername) {
		textCustomerName.sendKeys(customername);
	}
	
	public String getCustomerName() {
		String customername = textCustomerName.getAttribute("value");
		return customername;	
	}
	
	public void clickGenderRadiobtn(String gender) {
		if(gender.equalsIgnoreCase("Male")) {
			radiobtnMale.click();	
		}
		else
			radiobtnFemale.click();
	}
	
	
	public void setDOB(String date, String month, String year) {
		textDOB.sendKeys(date);
		textDOB.sendKeys(month);
		textDOB.sendKeys(year);
	}
	
	public void setAddress(String address) {
		textAddress.sendKeys(address);
	}
	
	public void setCity(String city) {
		textCity.sendKeys(city);
	}
	
	public void setState(String state) {
		textState.sendKeys(state);
	}
	
	public void setPIN(int pin) {
		textPin.sendKeys(String.valueOf(pin));
	}
	
	public void setMobileNumber(String mobilenumber) {
		textPhoneno.sendKeys(mobilenumber);
	}
	
	public void setEmail(String email) {
		textEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		textPassword.sendKeys(password);
	}
	
	public void clickSubmitbtn() {
		btnSubmit.click();
	}
	
	public void clickResetbtn() {
		btnReset.click();
	}
	
	
	

}
