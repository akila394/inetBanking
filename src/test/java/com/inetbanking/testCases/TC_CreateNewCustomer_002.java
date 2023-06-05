package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.pageobjects.NewCustomerPage;
import com.inetbanking.utilities.Reporting;
import com.relevantcodes.extentreports.LogStatus;

public class TC_CreateNewCustomer_002 extends BaseClass {
	//This test case is for adding customer with wrong data and verify the Alert
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
			ncp.setCustomerName("Mark resto");
			ncp.clickGenderRadiobtn("male");
			ncp.setDOB("12", "04", "1991");
			ncp.setAddress("4 Perkins avenue");
			ncp.setCity("San Diego");
			ncp.setState(" ");
			ncp.setPIN(345677);
			ncp.setMobileNumber("0453456785");
			ncp.setEmail(generateRandomEmail(8));
			ncp.setPassword("1234abcd");
			ncp.clickSubmitbtn();
			Thread.sleep(5000);	
			
			
			
			if(isAlertPresent())
			{
				driver.switchTo().alert().accept();
				Assert.assertTrue(true);
				test.log(LogStatus.PASS, "TC_CreateNewCustomer_002 test passed");
				log.info("TC_CreateNewCustomer_002 test passed");
			}
			else {
				test.log(LogStatus.FAIL, "TC_CreateNewCustomer_002 test failed");
				log.info("TC_CreateNewCustomer_002 test failed");
				String screenshotPath = Reporting.captureScreenshot(driver, "TC_CreateNewCustomer_002");
	            test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
				
			}
						
			
	  }
	
}
