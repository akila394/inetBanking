package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.pageobjects.NewCustomerPage;
import com.inetbanking.utilities.Reporting;
import com.relevantcodes.extentreports.LogStatus;

public class TC_CreateNewCustomer_003 extends BaseClass {
	@Test
	public void resetNewCustomerDetailsTest() throws InterruptedException, IOException {

		test = report.startTest("verify reset of adding new customer to the system");
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
		ncp.setDOB("", "04", "1991");
		ncp.setAddress("4 Perkins avenue");
		ncp.setCity("San Diego");
		ncp.setState("California");
		ncp.setPIN(345677);
		ncp.setMobileNumber("0453456785");
		ncp.setEmail(generateRandomEmail(8));
		ncp.setPassword("1234abcd");

		String initialValue = ncp.getCustomerName();
		System.out.println("Value is : "+initialValue);
		ncp.clickResetbtn();
		String resetValue = ncp.getCustomerName();
		System.out.println("Value is :"+resetValue);
		Thread.sleep(5000);

		if (resetValue.isEmpty()) {
			Assert.assertTrue(true);
			test.log(LogStatus.PASS, "TC_CreateNewCustomer_003 test passed");
			log.info("TC_CreateNewCustomer_003 test passed");
		}

		else {
			test.log(LogStatus.FAIL, "TC_CreateNewCustomer_003 test failed");
			log.info("TC_CreateNewCustomer_003 test failed");
			String screenshotPath = Reporting.captureScreenshot(driver, "TC_CreateNewCustomer_003");
			test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenshotPath));
			Assert.assertTrue(false);
		}

	}
}
