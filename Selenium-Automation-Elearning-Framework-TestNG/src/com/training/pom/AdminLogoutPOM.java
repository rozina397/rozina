package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLogoutPOM {
	
	private WebDriver driver;
	public AdminLogoutPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'Howdy')]")
	private WebElement HowdyAdmin;
	
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	private WebElement logout;
	
	public void mouseHoverOnHowdyAdmin() {
		Actions act=new Actions(driver);
		act.moveToElement(HowdyAdmin).build().perform();
	}
	
	public void clickLogOut() {
		this.logout.click();
	}

}
