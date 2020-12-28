package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HyperLinkPOM {
private WebDriver driver;
	
	public HyperLinkPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="Bookmarked Listings")
	private WebElement bookmark;
	
	@FindBy(linkText="My Profile")
	private WebElement myprofile;
	
	@FindBy(linkText="Change Password")
	private WebElement changePassword;
	
	@FindBy(linkText="Log Out")
	private WebElement Logout;
	
	
	public void clickBookmark() {
		try {
		System.out.println("clicked on: "+this.bookmark.getText());
		this.bookmark.click();
		}catch(Exception e) {
			System.out.println("Unable to click on Bookmark link");
		}
	}
	public void clickMyProfile() {
		try {
		System.out.println("clicked on: "+this.myprofile.getText());
		this.myprofile.click();
		}catch(Exception e) {
			System.out.println("Unable to click on My profile link");
		}
	}
	
	public void clickChangePassword() {
		try {
			System.out.println("clicked on: "+this.changePassword.getText());
			this.changePassword.click();
		}catch(Exception e) {
			System.out.println("Unable to click on change password link");
		}
	}
	
	public void clickLogOut() {
		try {
			System.out.println("clicked on: "+this.Logout.getText());
			this.Logout.click();
		}catch(Exception e) {
			System.out.println("Unable to click on log out");
		}
	}

}
