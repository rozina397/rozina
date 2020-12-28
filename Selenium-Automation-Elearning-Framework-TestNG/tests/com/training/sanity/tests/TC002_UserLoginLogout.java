package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HyperLinkPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC002_UserLoginLogout {
	
	public WebDriver driver;
	public String baseUrl;
	public LoginPOM loginPOM;
	private HyperLinkPOM hyperLinkPOM;
	public static Properties properties;
	public ScreenShot screenShot;
	
	

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		hyperLinkPOM=new HyperLinkPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();                                                   //close the browser
	}
	
	@Test(priority=1)
	public void Login() throws IOException {						//log in as a user
		loginPOM.clickRigisterLoginBtn();
		loginPOM.sendUserName("newuser");
		loginPOM.sendPassword("abcd1234");
		loginPOM.clickLoginBtn();
		//screenshot
		  screenShot.captureScreenShot("TC002");
	   //print message
		  loginPOM.printMessgae();	
	}
	
	@Test(priority=3)                         //log out from the application
	public void LogOut() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,200)"); 					//scroll down
		hyperLinkPOM.clickLogOut();
		
	}
}
