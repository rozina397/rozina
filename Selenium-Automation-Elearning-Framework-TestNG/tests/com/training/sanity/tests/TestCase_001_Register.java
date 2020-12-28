package com.training.sanity.tests;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.training.pom.RegisterPOM;

public class TestCase_001_Register extends AdminLoginLogout{
	

	public RegisterPOM registerPOM;
	
	

	
	@Test(priority=2)                                           //create a new user
	public void registerNewUser() throws InterruptedException, IOException {
		logger=extent.startTest("adding the new user");
		registerPOM=new RegisterPOM(driver);
		registerPOM.clickOnUsers();
		registerPOM.clickAddNewUsers();
		registerPOM.sendUserName("newuser");
		registerPOM.sendEmail("newuser@gmail.com");
		registerPOM.sendFirstName("newuser");
		registerPOM.sendLastNmae("newuser");
		registerPOM.sendWebsite("www.google.com");
		registerPOM.clickShowPassword();
		registerPOM.sendPassword("abcd1234");
		registerPOM.clickCheckBox();  
		JavascriptExecutor js=(JavascriptExecutor)driver;                   
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");		//scroll down
		registerPOM.clickToselectRole();
		registerPOM.clickSubmitBtn();
		registerPOM.isCreated();
		if(registerPOM.isCreated())
		{
			logger.log(LogStatus.PASS, "new user created");
		}
		else {
			logger.log(LogStatus.FAIL, "unable to create new user");
		}
		screenShot.captureScreenShot("TC001");
		extent.endTest(logger);
	}
	
}
