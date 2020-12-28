package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='sign-in']")
	private WebElement registerLoginBtn;  
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login") 
	private WebElement loginBtn; 
	
	@FindBy(linkText="My Profile")
	private WebElement loggedinsuccesful;
	
	public void clickRigisterLoginBtn() { 
		//WebDriverWait ewait=new WebDriverWait(driver,100);
		//ewait.until(ExpectedConditions.elementToBeClickable(this.registerLoginBtn));
		this.registerLoginBtn.click();
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void printMessgae() {
		Assert.assertEquals(this.loggedinsuccesful.getText(), "My Profile");
		System.out.println("Succesfully looged in as a auser");
		
	}
	
}
