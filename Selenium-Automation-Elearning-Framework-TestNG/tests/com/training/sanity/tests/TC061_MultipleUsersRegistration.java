package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.MultipleUsersRegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC061_MultipleUsersRegistration {
	private WebDriver driver;
	private String baseUrl;
	public static Properties properties;
	private ScreenShot screenShot;
	private ExtentReports extent;
	private ExtentTest logger;
/*	private File file;
	private FileInputStream fs;
	private XSSFWorkbook wb;
	private XSSFSheet sheet;*/
	private MultipleUsersRegistrationPOM multipleUsersRegistrationPOM;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/rozina.html",true);
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
        logger=extent.startTest("launching the browser");
        
       // file=new File("C:\\Users\\RozinaKhatun\\Downloads\\RealEstate TestCases1.xlsx");
        //fs=new FileInputStream(file);
        //wb=new XSSFWorkbook(fs);
        //sheet=wb.getSheet("Test Data");
        
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		//create objects for POM files
		multipleUsersRegistrationPOM=new MultipleUsersRegistrationPOM(driver);
		// open the browser 
		driver.get(baseUrl);
		
		logger.log(LogStatus.INFO, "Launched the browser");
		extent.endTest(logger);
	}
   
	@Test(dataProvider="excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void Register(String email,String firstname,String lastname) {
		logger=extent.startTest("To verify whether application allows multiple users to get registered upon entering valid credentials");
		multipleUsersRegistrationPOM.clickRigisterLoginBtn();
		multipleUsersRegistrationPOM.clickRegisterlink();
		int k=1;
		for(int i=2;i<5;i++)
		{
			logger.log(LogStatus.INFO, "logging with the "+k+" data");
			//System.out.println("Testing with "+k+"data");
			//for(int j=1;j<4;j++)
			//{
			//logger.log(LogStatus.INFO, "taking the data from the sheet");
			//taking the values from the sheet
			
			 //email=sheet.getRow(i).getCell(1).getStringCellValue();
			 //firstname=sheet.getRow(i).getCell(2).getStringCellValue();
			 //lastname=sheet.getRow(i).getCell(3).getStringCellValue();
			 
			 logger.log(LogStatus.INFO,"email: "+email+" ,firstname: "+firstname+" ,lastname: "+lastname);
			 
			 //assigning the value into the element
			 multipleUsersRegistrationPOM.sendEmail(email);
			 multipleUsersRegistrationPOM.sendFirstNmae(firstname);
			 multipleUsersRegistrationPOM.sendLastNmae(lastname);
			 //multipleUsersRegistrationPOM.
			//}
			 multipleUsersRegistrationPOM.clcikRegisterBtn();
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("window.scrollTo(0,-150)");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
				String message=multipleUsersRegistrationPOM.getMessgae();
				
				//SCREENSHOT
				screenShot.captureScreenShot("login with"+k+"data");
				k++;
				if(message.contains("successfully registered")) {
					multipleUsersRegistrationPOM.clickRegisterlink();
					logger.log(LogStatus.PASS, message);
				}
				else {
					logger.log(LogStatus.INFO, message);
				}
		}
		extent.endTest(logger);
		
	}
	@AfterClass
	public void teardown() {
		logger=extent.startTest("closing the bowser");
		driver.quit();
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}
}
