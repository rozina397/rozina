package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ChangePasswordPOM {
	
private WebDriver driver; 
	
	public ChangePasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(name="current_pass")
	private WebElement currentPassword;
	
	@FindBy(xpath="//input[@name='pass1']")
	private WebElement newPassword;
	
	@FindBy(xpath="//input[@name='pass2']")
	private WebElement confirmPassword;
	
	@FindBy(id="wp-submit")
	private WebElement saveChanges;
	
	@FindBy(xpath="//p[contains(text(),'Your password has been updated.')]")
	private WebElement message;
	
	public void sendCurrentPassword(String currentPassword) {
		this.currentPassword.clear();
		this.currentPassword.sendKeys(currentPassword);
	}

	public void sendNewPassword(String newPassword) {
		this.newPassword.clear();
		this.newPassword.sendKeys(newPassword);
	}
	
	public void sendConfirmPassword(String confirmPassword) {
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassword);
	}
	
	public void clickSaveChanges() {
		this.saveChanges.click();
		
	}
	
	public void printMessage() {
		Assert.assertEquals(this.message.getText(), "Your password has been updated.");
		System.out.println(this.message.getText());
		
	}
}
