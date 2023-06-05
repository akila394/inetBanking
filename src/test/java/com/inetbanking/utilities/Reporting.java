package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting {
	WebDriver driver;
	ExtentTest test;
	private static ExtentReports extent;

	public static ExtentReports getInstance(){
		 if (extent == null) {
	            String timestamp = new SimpleDateFormat("yyyyMMdd").format(new Date());
	            String reportPath = "C:\\Users\\akila\\OneDrive\\Desktop\\TesingPortfolio\\UdemySeleniumJava\\inetBankingV1\\Reports\\report_" + timestamp + ".html";
	            extent = new ExtentReports(reportPath, false);
	            extent.addSystemInfo("Selenium Version", "2.52").addSystemInfo("Platform", "Windows");
	        }
		return extent;
	}

//	public void attachScreenshotIn_FailedTests(ITestResult testresult) throws InterruptedException, IOException{
//		Thread.sleep(3000);
//		if (testresult.getStatus() == ITestResult.FAILURE) {
//			String currentdir = System.getProperty("user.dir");
//			String filename = "screenshot_" + getRandomString() + ".png";
//			String filepath = currentdir + "/screenshots/" + filename;
//			
//			// Create the screenshots directory if it doesn't exist
//	        File screenshotsDir = new File(currentdir + "/screenshots");
//	        screenshotsDir.mkdirs();
//
//			File sourcefile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(sourcefile, new File(filepath));
//			
//			test.log(LogStatus.FAIL, "Test Failed");
//	        test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(filepath));
//			}
//			
//		}
	
	//Capture a screen shot and return the path for the screen shot
	 public static String captureScreenshot(WebDriver driver, String screenshotName) throws IOException {

		 
		 	File sourcefile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        String currentdir = System.getProperty("user.dir");
	        String timestamp = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
	        String filename = screenshotName +"_" + timestamp + ".png";
	        String filepath = currentdir + "/screenshots/" + filename;
	        File finalDestination = new File(filepath);

	        
	        FileUtils.copyFile(sourcefile, finalDestination);

	        return filepath;
	    }
	
	

//	private String getRandomString() {
//
//		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//		StringBuilder sb = new StringBuilder(10);
//		for (int i = 0; i < 10; i++) {
//			int index = (int) (Math.random() * characters.length());
//			sb.append(characters.charAt(index));
//		}
//		return sb.toString();
//	}

}
