package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RecoverPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC003_RecoverPassword {
	
	private WebDriver driver;
	private String baseUrl;
	private RecoverPasswordPOM recoverPasswordPOM;
	private static Properties properties;
	private ScreenShot screenshot;
	
	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		recoverPasswordPOM = new RecoverPasswordPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenshot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();                     //close the browser              
	}
	
	@Test
	public void forgotPassword() throws IOException{
		//Thread.sleep(30000);
		recoverPasswordPOM.clickRigisterLoginBtn();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,350)");                //scroll down
		recoverPasswordPOM.clickLostPasswordLink();
		recoverPasswordPOM.sendEmail("rozina@gmail.com");
		recoverPasswordPOM.clickResetPasswordBtn();
		//screenshot
		screenshot.captureScreenShot("TC003");
		recoverPasswordPOM.printErrorMessage();                    
	}

}
