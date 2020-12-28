package com.training.sanity.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.training.pom.AddAndViewPropertyPOM;

public class TC0031_AddProperty_Medium extends AdminLoginLogout{
	private AddAndViewPropertyPOM addAndViewPropertyPOM;
	

	@Test(priority=2)
	public void addProperty() throws InterruptedException{
		String propertyTitle="new launch1";
		logger=extent.startTest("Adding new property");
		
		addAndViewPropertyPOM=new AddAndViewPropertyPOM(driver);
		addAndViewPropertyPOM.clcikProperties();
		addAndViewPropertyPOM.clikAddNewLink();
		String addNewLink=addAndViewPropertyPOM.getAddNewLink();
		logger.log(LogStatus.INFO,"clicked on "+addNewLink);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		addAndViewPropertyPOM.sendTitle(propertyTitle);
		addAndViewPropertyPOM.writeIntoTextbox("new launch1");
		addAndViewPropertyPOM.sendPrice("50000.00");
		addAndViewPropertyPOM.sendPricePerSq("200.00");
		
		addAndViewPropertyPOM.clickMainDetails();
		addAndViewPropertyPOM.sendStatus("New");
		addAndViewPropertyPOM.sendLocation("Electronic city");
		addAndViewPropertyPOM.sendPossession("immediate");
		
		addAndViewPropertyPOM.clickLocationTab();
		addAndViewPropertyPOM.sendAddress("yeshwanthapur");
		addAndViewPropertyPOM.sendMapAddress("yeshwanthapur");
		addAndViewPropertyPOM.sendLatitude("120");
		addAndViewPropertyPOM.sengLongitude("56");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		addAndViewPropertyPOM.clickDetailsTab();
		addAndViewPropertyPOM.sendStorageRoom("2");
		js.executeScript("window.scrollTo(0,200)");                //scroll up
	    addAndViewPropertyPOM.selectRegion();                       //select Central Bangalore checkBox  inside KeywordTgs
		addAndViewPropertyPOM.clickPublish();
		addAndViewPropertyPOM.clickAllPropertiesLink();
		String allPropertiesLink=addAndViewPropertyPOM.getAllpropertiesLink();
		logger.log(LogStatus.INFO, "clicked on "+allPropertiesLink);
		addAndViewPropertyPOM.searchProperty(propertyTitle);
		//screenshot
		screenShot.captureScreenShot("TC0031");
		extent.endTest(logger);
	
		
	}

}
