package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.training.pom.RegisterPOM;

public class TC062_DisplayRegistrationDatabase  extends AdminLoginLogout{
	private RegisterPOM registerPOM;
	private File file;
	private FileInputStream fs;
	private XSSFWorkbook wb;
	private XSSFSheet sheet;
	
	@Test(priority=2)
	public void seeDatabase() throws IOException, InterruptedException {
		registerPOM=new RegisterPOM(driver);
		file=new File("C:\\Users\\RozinaKhatun\\Downloads\\RealEstate TestCases1.xlsx");
		fs=new FileInputStream(file);
		wb=new XSSFWorkbook(fs);
		sheet=wb.getSheet("Test Data");
		
		logger=extent.startTest("To verify whether details entered by user during registration get displayed in database");
		registerPOM.clickOnUsers();
		registerPOM.clickAllUsers();
		int k=1;
		for(int i=2;i<5;i++)
		{
		String email=sheet.getRow(i).getCell(1).getStringCellValue();
		registerPOM.searCreatedUser(email);
		registerPOM.clickSearchSubmit();
		if(registerPOM.isViewAddedUser(email)) {
			logger.log(LogStatus.PASS, "found added user");
		}
		else {
			logger.log(LogStatus.FAIL, "not found added user");
		}
		
		//screenshot
		screenShot.captureScreenShot(k+":TC0062");
		k++;
		}
		extent.endTest(logger);
		
	

	}

}
