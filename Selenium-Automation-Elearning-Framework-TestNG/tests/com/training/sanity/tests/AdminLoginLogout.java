package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.AddAndViewPropertyPOM;
import com.training.pom.AdminLogoutPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminLoginLogout {
	
	public WebDriver driver;
	public String baseUrl;
	public static Properties properties;
	public ScreenShot screenShot;
	public LoginPOM loginPOM;
	public AdminLogoutPOM adminLogoutPOM;
	public ExtentReports extent;
	public ExtentTest logger;
	
	@BeforeTest
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
		//create objects for POM files
		loginPOM = new LoginPOM(driver); 
		adminLogoutPOM=new AdminLogoutPOM(driver);
		// open the browser 
		driver.get(baseUrl);
		
		logger.log(LogStatus.INFO, "Launched the browser");
		extent.endTest(logger);
	}
   
	
	@Test(priority=1) 
	public void adminLogin() {
		//logger=extent.startTest("login admin");
		loginPOM.clickRigisterLoginBtn();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		logger.log(LogStatus.INFO, "Successfully logged in");
		extent.endTest(logger);
		
	}
	
	@Test(priority=4)               //log out from the application
	public void LogOut() {
		logger=extent.startTest("log out from the application");
		adminLogoutPOM.mouseHoverOnHowdyAdmin();
		adminLogoutPOM.clickLogOut();
		logger.log(LogStatus.INFO,"successfully logged out");
		extent.endTest(logger);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		extent.flush();
		extent.close();
	}
	
	
}
