package com.training.sanity.tests;

import java.io.IOException;
import org.testng.annotations.Test;

import com.training.pom.ChangePasswordPOM;
import com.training.pom.HyperLinkPOM;

public class TC005_PasswordChange  extends TC002_UserLoginLogout{
	private HyperLinkPOM hyperLinkPOM;
	private ChangePasswordPOM changePasswordPOM;
	

	@Test(priority=2)
	public void ChangePassword() throws IOException {
		hyperLinkPOM=new HyperLinkPOM(driver);
		changePasswordPOM = new ChangePasswordPOM(driver); 
		hyperLinkPOM.clickBookmark();     						 //click on Bookmark link
		hyperLinkPOM.clickMyProfile();     						//click on Myprofile link
		hyperLinkPOM.clickChangePassword();						//click on change password link
		changePasswordPOM.sendCurrentPassword("abcd1234");
		changePasswordPOM.sendNewPassword("abcd12345");
		changePasswordPOM.sendConfirmPassword("abcd12345");
		changePasswordPOM.clickSaveChanges();
		//screenshot
		screenShot.captureScreenShot("TC005");
		changePasswordPOM.printMessage();
	}


}
