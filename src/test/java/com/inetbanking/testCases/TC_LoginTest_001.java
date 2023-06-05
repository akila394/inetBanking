package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.utilities.Reporting;
import com.relevantcodes.extentreports.LogStatus;

public class TC_LoginTest_001 extends BaseClass{
	
	ITestResult testresult;
	
	@Test
	public void logintest() throws InterruptedException, IOException  {
		
		test = report.startTest("verify Login test");
		log.info("Navigated to login page");
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver, test);
		
		
		log.info("Entered user name");
		lp.setUserName(username);
		
		log.info("Entered password");
		lp.setPassword(password);
		
		log.info("Clicked on login button");
		lp.clickLoginButton();
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			log.info("TC_LoginTest_001 passed");
			test.log(LogStatus.INFO, "TC_LoginTest_001 is passed");
		}
		else {
			log.info("TC_LoginTest_001 failed");
			test.log(LogStatus.INFO, "TC_LoginTest_001 is failed");
			String screenshotPath = Reporting.captureScreenshot(driver, "TC_LoginTest_001");
            test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenshotPath));
			Assert.assertTrue(false);
				
		}
		
	}

}
