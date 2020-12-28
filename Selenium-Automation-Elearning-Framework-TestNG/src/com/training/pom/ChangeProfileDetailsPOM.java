package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ChangeProfileDetailsPOM {
	
	private WebDriver driver;
	
	public ChangeProfileDetailsPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="agent_title")
	private WebElement agentTitle;
	
	@FindBy(name="phone")
	private WebElement phoneNo;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveChanges;
	
	@FindBy(xpath="//p[contains(text(),'Your profile has been updated.')]")
	private WebElement message;
	
	
	
	public void sendAgentTitle(String agentTitle) throws InterruptedException {
		Thread.sleep(3000);
		this.agentTitle.clear();
		this.agentTitle.sendKeys(agentTitle);	
	}
	
	public void sendPhoneNo(String phoneNo) {
		this.phoneNo.clear();
		this.phoneNo.sendKeys(phoneNo);
	}
	
	public void clickSaveChanges() {
		this.saveChanges.click();
		System.out.println(this.message.getText());
		Assert.assertEquals(this.message.getText(), "Your profile has been updated.");
		
	}
	
	

}
