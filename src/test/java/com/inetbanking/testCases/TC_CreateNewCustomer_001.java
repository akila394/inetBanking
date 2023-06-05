package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.pageobjects.NewCustomerPage;
import com.inetbanking.utilities.Reporting;
import com.relevantcodes.extentreports.LogStatus;

public class TC_CreateNewCustomer_001 extends BaseClass {
	
	
  @Test
  public void createNewCustomerTest() throws InterruptedException, IOException {

		test = report.startTest("verify Adding new customer to the system");
		log.info("Navigated to login page");
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver, test);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLoginButton();
		
		NewCustomerPage ncp = new NewCustomerPage(driver);
		ncp.clickNewCustomerLink();
		log.info("Navigated to create new customer page");
		ncp.setCustomerName("Mark rest");
		ncp.clickGenderRadiobtn("male");
		ncp.setDOB("12", "04", "1991");
		ncp.setAddress("4 Perkins avenue");
		ncp.setCity("San Diego");
		ncp.setState("California");
		ncp.setPIN(345677);
		ncp.setMobileNumber("0453456785");
		ncp.setEmail(generateRandomEmail(8));
		ncp.setPassword("1234abcd");
		ncp.clickSubmitbtn();
		Thread.sleep(5000);	
		log.info("Clicked on Submit button");
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(result == true) {
			Assert.assertTrue(true);
			test.log(LogStatus.PASS, "TC_CreateNewCustomer_001 test passed");
			log.info("TC_CreateNewCustomer_001 test passed");
		}
		
		else {
			test.log(LogStatus.FAIL, "TC_CreateNewCustomer_001 test failed");
			log.info("TC_CreateNewCustomer_001 test failed");
			String screenshotPath = Reporting.captureScreenshot(driver, "TC_CreateNewCustomer_001");
            test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenshotPath));
			Assert.assertTrue(false);
			
		}
		
		
//		if(isAlertPresent())
//		{
//			System.out.print("result");
//			Assert.assertTrue(false);
//			test.log(LogStatus.FAIL, "TC_CreateNewCustomer_001 test failed");
//		}
		
  }
  
  
  
}
