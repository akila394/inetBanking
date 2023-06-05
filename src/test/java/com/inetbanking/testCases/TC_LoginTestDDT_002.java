package com.inetbanking.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.utilities.ExcelReader;
import com.inetbanking.utilities.Reporting;
import com.relevantcodes.extentreports.LogStatus;

public class TC_LoginTestDDT_002 extends BaseClass {
	ITestResult testresult;

	@Test(dataProvider = "getData")
	public void logintest(String username, String password, String expectedresult) throws InterruptedException, IOException {
		
		test = report.startTest("verify data driven testing Login test");
		log.info("Navigated to login page");
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver, test);

		log.info("Entered user name");
		lp.setUserName(username);

		log.info("Entered password");
		lp.setPassword(password);

		log.info("Clicked on login button");
		lp.clickLoginButton();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()== true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			log.warn("Login failed");
			log.info("*********************************");
			test.log(LogStatus.FAIL, "TC_LoginTestDDT_002 Login test failed");
			String screenshotPath = Reporting.captureScreenshot(driver, "TC_LoginTestDDT_002");
            test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenshotPath));
			Assert.assertTrue(false);
			
		}
		
		else {
			//lp.clickLogoutButton();
			log.info("Loggin passed");
			log.info("*********************************");
			test.log(LogStatus.PASS, "TC_LoginTestDDT_002 Login test passed");
			Assert.assertTrue(true);
			
	}

//		if (expectedresult.equalsIgnoreCase("Invalid")) {
//			try {
//				String screenshotPath = Reporting.captureScreenshot(driver, "TC_LoginTestDDT_002");
//	            test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenshotPath));
//
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//				Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//				System.out.println("Alert text: " + alert.getText());
//				alert.dismiss();
//				System.out.println("Login Failed");
//				test.log(LogStatus.INFO, "TC_LoginTestDDT_002 is failed");
//			} catch (TimeoutException e) {
//				String screenshotPath = Reporting.captureScreenshot(driver, "TC_LoginTestDDT_002");
//	            test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenshotPath));
//
//			}
//		}
//		if (expectedresult.equalsIgnoreCase("Valid")) {
//			System.out.println("Login Successful");
//			test.log(LogStatus.INFO, "TC_LoginTestDDT_002 is passed");
//		}

	}
	
	
	
	@DataProvider(name = "getData")
	public Object[][] getDataForLogin() throws IOException {
		String filepath = System.getProperty("user.dir") + "/TestData/" + "TestData.xlsx";
		ExcelReader reader = new ExcelReader();
		String[][] data = reader.readExcel(filepath, "Login data");
		return data;
	}

}
