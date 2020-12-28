package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPOM {
	private WebDriver driver;
	public RegisterPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="Users")
	private WebElement users;
	
	@FindBy(linkText="Add New")
	private WebElement addNewUsers;
	
	@FindBy(id="user_login")
	private WebElement username;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="url")
	private WebElement website;
	
	@FindBy(xpath="//button[contains(text(),'Show password')]")
	private WebElement showPassword;
	
	@FindBy(id="pass1-text")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkbox;
	
	@FindBy(xpath="//select[@id='role']")
	private WebElement selectRole;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	@FindBy(xpath="//div[@id='message']/child::p")
	private WebElement message;
	
	@FindBy(linkText="All Users")
	private WebElement allUsers;
	
	@FindBy(id="user-search-input")
	private WebElement createdUser;
	
	@FindBy(id="search-submit")
	private WebElement searchSubmit;
	
	
	public void clickOnUsers() throws InterruptedException {
		this.users.click();
	}
	
	public void clickAddNewUsers() throws InterruptedException {
		this.addNewUsers.click();
	}
	
	public void sendUserName(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
		
	}
	
	public void sendFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		
	}
	
	public void sendLastNmae(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		
	}
	
	public void sendWebsite(String website) {
		this.website.clear();
		this.website.sendKeys(website);
	}
	
	public void clickShowPassword() throws InterruptedException {
		//Thread.sleep(3000);
		this.showPassword.click();
	}
	
	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void clickCheckBox() {
		if((this.checkbox).isDisplayed()) {
			this.checkbox.click();
		}
	}
	
	public void clickToselectRole() {
		Select role=new Select(this.selectRole);
		role.selectByVisibleText("Customer");
		//role.selectByValue("Customer");
		
	}
	
	public void clickSubmitBtn() {
		this.submit.click();
	}
	
	public boolean isCreated() {
		boolean created=false;
		try {
			if(this.message.getText().equalsIgnoreCase("New user created. Edit user"))
			{
			created=true;
			}
		}catch(NoSuchElementException e){
			created=false;
		}
		return created;
		
	}

	public void clickAllUsers() {
		this.users.click();
		this.allUsers.click();
	}
	
	public void searCreatedUser(String createdUser) {
		this.createdUser.clear();
		this.createdUser.sendKeys(createdUser);
	}
	
	public void clickSearchSubmit() {
		this.searchSubmit.click();
	}
	
	public boolean isViewAddedUser(String username) {
		boolean found = false;
			String before="//tbody[@id='the-list']/tr";
			String after="]/td[1]/strong[1]/a[1]"	;
			int count=driver.findElements(By.xpath(before)).size();
			try
			{
			for(int i=1;i<=count;i++) {
				String userName=driver.findElement(By.xpath(before+"["+i+after)).getText();
				if(userName.equals(username)) {
				    found=true;
				    break;
				}
			}
			}catch(NoSuchElementException e)
			{
				found=false;
			
				}
			return found;
		}
	
}
