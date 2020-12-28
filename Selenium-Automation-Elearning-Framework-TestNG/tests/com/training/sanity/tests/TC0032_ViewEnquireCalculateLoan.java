package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ViewEnquireCalculateLoanPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC0032_ViewEnquireCalculateLoan {
	
	public WebDriver driver;
	public String baseUrl;
	public static Properties properties;
	public ScreenShot screenShot;
	public ViewEnquireCalculateLoanPOM viewEnquireCalculateLoanPOM;
	private ExtentReports extent;
    private ExtentTest logger;
    
	
	@BeforeClass
	public void setUpBeforeTest() throws IOException {
		
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/rozina.html",true);
		extent.loadConfig(new File(System.getProperty("user-dir")+"\\extent-config.xml"));
		logger=extent.startTest("launching the browser");
		
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		//create object
		viewEnquireCalculateLoanPOM=new ViewEnquireCalculateLoanPOM(driver);
		//open url
		driver.get(baseUrl);
		logger.log(LogStatus.INFO, "launched the browser");
		extent.endTest(logger);
		
	}
	
	@Test(priority=1)
	public void mouseHoverOnNewLaunch() throws InterruptedException {
		logger = extent.startTest("To verify whether application allows customer to view, enquire & calculate loan on New launches");
		
		
		viewEnquireCalculateLoanPOM.mouseHoverNewLaunch();
		viewEnquireCalculateLoanPOM.clicknullamApartLink();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,300)");
		viewEnquireCalculateLoanPOM.clickNextImage();
		logger.log(LogStatus.INFO, "Clicked on next image and filling the form enquires");
		viewEnquireCalculateLoanPOM.sendName("rozina");
		viewEnquireCalculateLoanPOM.sendEmail("rozina@gmail.com");
		viewEnquireCalculateLoanPOM.sendSubject("Apartment");
		viewEnquireCalculateLoanPOM.sendMessage("looking for apartment");
		viewEnquireCalculateLoanPOM.clicksend();
		logger.log(LogStatus.INFO, "clicked on search");
		logger.log(LogStatus.INFO, "mortgage calculatior");
		viewEnquireCalculateLoanPOM.sendSalePrice("40000");
		viewEnquireCalculateLoanPOM.sendDownPayment("2000");
		viewEnquireCalculateLoanPOM.sendYear("2");
		viewEnquireCalculateLoanPOM.sendInterestRate("5");
		viewEnquireCalculateLoanPOM.clickCalculate();
		String msg=viewEnquireCalculateLoanPOM.successMessage();
		logger.log(LogStatus.INFO, msg);
		//scrennshot
		screenShot.captureScreenShot("TC0032b");
			
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.log(LogStatus.INFO, "closed the browser");
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}
	
}
