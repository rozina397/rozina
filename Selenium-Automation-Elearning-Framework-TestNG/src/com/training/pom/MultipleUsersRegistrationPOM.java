package com.training.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleUsersRegistrationPOM {
	private WebDriver driver;
	
	public MultipleUsersRegistrationPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(className="sign-in")
	private WebElement registerLoginBtn;
	
	@FindBy(linkText="Register")
	private WebElement registerlink;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='first-name']")
	private WebElement firstname;
	
	 @FindBy(xpath="//input[@id='last-name']")
	 private WebElement lastname;
	 
	 @FindBy(xpath="//input[@name='submit']")
	 private WebElement registerbtn;
	 
	 @FindBy(xpath="//ul[@class='tabs-nav']/preceding-sibling::div/child::p")
	 private WebElement message1;
	
	 @FindBy(xpath="//p[contains(text(),'An account exists with this email address.')]")
	 private WebElement message2;
	 
	public void clickRigisterLoginBtn() {    
		this.registerLoginBtn.click();
	}
	
	public void clickRegisterlink() {
		this.registerlink.click();
	}
	
	public void sendEmail(String mail) {
		this.email.sendKeys(mail);
	}
	
	public void sendFirstNmae(String firstname) {
		this.firstname.sendKeys(firstname);
	}
	
	public void sendLastNmae(String lastname) {
		this.lastname.sendKeys(lastname);
	}
	
	public void clcikRegisterBtn() {
		this.registerbtn.click();
		
	}
	
	public String getMessgae() {
		String msg;
		try {
			msg= this.message1.getText();
		}catch(NoSuchElementException e) {
			msg=this.message2.getText();
		}
		return msg;
	}
	
}
