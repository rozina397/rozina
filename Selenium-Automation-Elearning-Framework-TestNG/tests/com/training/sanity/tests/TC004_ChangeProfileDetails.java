package com.training.sanity.tests;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.training.pom.ChangeProfileDetailsPOM;
import com.training.pom.HyperLinkPOM;

public class TC004_ChangeProfileDetails extends TC002_UserLoginLogout{
	
	private ChangeProfileDetailsPOM changeProfileDetailsPOM;
	private HyperLinkPOM hyperLinkPOM;



	@Test(priority=2)
	public void changeProfileDetails() throws InterruptedException {
		hyperLinkPOM=new HyperLinkPOM(driver);
		changeProfileDetailsPOM=new ChangeProfileDetailsPOM(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");                    //scroll the page down
		hyperLinkPOM.clickBookmark(); 									//click on Bookmark link
		hyperLinkPOM.clickMyProfile();                                 //click on MyProfile link
		js.executeScript("window.scrollBy(0,300)");                    //scroll down
		changeProfileDetailsPOM.sendAgentTitle("xyz");
		changeProfileDetailsPOM.sendPhoneNo("1234567890");
		changeProfileDetailsPOM.clickSaveChanges();
		//screenshot
			screenShot.captureScreenShot("TC004");
	}
	

	
}
