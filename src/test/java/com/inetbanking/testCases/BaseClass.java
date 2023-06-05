package com.inetbanking.testCases;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;
import com.inetbanking.utilities.Reporting;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger log;
	ExtentReports report;
	ExtentTest test;


	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		
		String className = this.getClass().getSimpleName();
		log = LogManager.getLogger(className);
		report = Reporting.getInstance();
		

		if (br.equals("chrome")) {
			log.info("Loading Chrome browser");
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			
		} 
		else if (br.equals("firefox")) {
			log.info("Loading Firefox browser");
			//System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
			
		} 
		else if (br.equals("edge")) {
			log.info("Loading Edge browser");
			//System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
			
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		report.endTest(test);
        report.flush();
	}
	
	public String generateRandomEmail(int length)
	  {
		  String generatedString = RandomStringUtils.randomAlphanumeric(length);
		  String email = generatedString + "@gamil.com";
		  return email;
	  }
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
		
	}

}
