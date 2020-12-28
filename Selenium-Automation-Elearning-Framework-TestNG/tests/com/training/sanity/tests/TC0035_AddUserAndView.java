package com.training.sanity.tests;

import java.io.IOException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.training.pom.RegisterPOM;

public class TC0035_AddUserAndView extends TestCase_001_Register{


	
	@Test(priority=3)                                           
	public void viewAddedNewUser() throws InterruptedException, IOException {
		logger=extent.startTest("TO verify whether application allows admin to view added user in all Users module");
		registerPOM=new RegisterPOM(driver);
		registerPOM.clickAllUsers();
		registerPOM.searCreatedUser("newuser");
		registerPOM.clickSearchSubmit();
		if(registerPOM.isViewAddedUser("newuser")) {
			logger.log(LogStatus.PASS, "found added user");
		}
		else {
			logger.log(LogStatus.FAIL, "not found added user");
		}
		
		//screenshot
		screenShot.captureScreenShot("TC0035");
		extent.endTest(logger);

	
	}

}
