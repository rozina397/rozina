package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.CommercialTabPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC0034_CommercialTab {
	
	public WebDriver driver;
	public String baseUrl;
	public static Properties properties;
	public ScreenShot screenShot;
	public CommercialTabPOM commercialTabPOM;	
	private ExtentReports extent;
    private ExtentTest logger;
	
	@BeforeClass
	public void setUpBeforeTest() throws IOException {
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/rozina.html",true);
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		logger=extent.startTest("launching the browser");
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		//create object
		commercialTabPOM=new CommercialTabPOM(driver);
		//open url
		driver.get(baseUrl);
		logger.log(LogStatus.INFO, "oppend: "+driver.getCurrentUrl());
		extent.endTest(logger);
	
	}
	
	
	@Test
	public void commercialTab() throws InterruptedException {
		logger=extent.startTest("To verify whether application allows to search details & fill enquiry details in Commercial tab");
		commercialTabPOM.clickCommercialTab();
		commercialTabPOM.eneterAddress("Nullam hendrerit apartment");
		commercialTabPOM.clcikSearchButton();
		logger.log(LogStatus.INFO,commercialTabPOM.searchResult()+" for search result");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,200)");
		commercialTabPOM.clickDropLine();
		logger.log(LogStatus.INFO, "filling the contact form");
		commercialTabPOM.sendName("rozina");
		commercialTabPOM.sendEmail("rozina@gmail.com");
		commercialTabPOM.sendSubject("apartment");
		commercialTabPOM.sendMessage("looking for apartment");
		commercialTabPOM.clickSend();
		logger.log(LogStatus.INFO, commercialTabPOM.message());
		extent.endTest(logger);
		//screenshot
		screenShot.captureScreenShot("TC0034");
		
	}

	@AfterClass
	public void closeBrowser() {
		logger=extent.startTest("closing the browser");
		driver.close();
		logger.log(LogStatus.INFO, "closed the browser");
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}
}
