package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoverPasswordPOM {
	
private WebDriver driver;
	
	public RecoverPasswordPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(className="sign-in")
	private WebElement registerLoginBtn;  
	
	@FindBy(xpath="//a[contains(text(),' Lost Your Password?')]")
	private WebElement lostPassword;
	
	@FindBy(name="user_login")
	private WebElement email;
	
	@FindBy(className="lostpassword-button")
	private WebElement resetPassword;
	
	@FindBy(xpath="//article[@id='post-124']")
	private WebElement errorMessage;
	
	public void clickRigisterLoginBtn() {    
		this.registerLoginBtn.click();
	}
	
	public void clickLostPasswordLink() {
		this.lostPassword.click();
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void clickResetPasswordBtn() {
		this.resetPassword.click();
		
	}

	public void printErrorMessage() {
		System.out.println(this.errorMessage.getText());
	}
}
