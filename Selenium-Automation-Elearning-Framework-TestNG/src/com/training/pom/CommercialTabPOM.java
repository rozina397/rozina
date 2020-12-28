package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommercialTabPOM {
	
	private WebDriver driver;
	private Actions act;
	
	public CommercialTabPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Commercial')]")
	private WebElement commercialLink;
	
	@FindBy(id="keyword_search")
	private WebElement address;
	
	@FindBy(xpath="//button[@class='button fullwidth']")
	private WebElement searchButton;
	
	@FindBy(xpath="//h1[contains(text(),'Nothing Found')]")
	private WebElement message;
	
	@FindBy(xpath="//a[@class='button fullwidth margin-top-20']")
	private WebElement dropLine;
	
	@FindBy(name="name")
	private WebElement yourName;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="subject")
	private WebElement subject;
	
	@FindBy(xpath="//textarea[@placeholder='Message']")
	private WebElement messageText;
	
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement send;
	
	@FindBy(xpath="//form[@method='post']/child::p/following-sibling::div")
	private WebElement contactFormMessage;
	
	
	public void clickCommercialTab() {
		this.commercialLink.click();
	}
	
	public void eneterAddress(String address) {
		this.address.clear();
		this.address.sendKeys(address);
	}
	
	public void clcikSearchButton() throws InterruptedException {
		this.searchButton.click();
		System.out.println(this.message.getText());
	}
	
	public String searchResult() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return this.message.getText();
	}
	
	public void clickDropLine() {
		this.dropLine.click();
	}
	
	public void sendName(String yourName) {
		this.yourName.clear();
		this.yourName.sendKeys(yourName);
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendSubject(String subject) {
		this.subject.clear();
		this.subject.sendKeys(subject);
	}
	
	public void sendMessage(String messageText) {
		this.messageText.clear();
		this.messageText.sendKeys(messageText);
	}
	
	public void clickSend() throws InterruptedException {
		this.send.click();
		act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();     //to scroll down
		
	}
	
	public String message() {
		WebDriverWait ewait=new WebDriverWait(driver,50);
		ewait.until(ExpectedConditions.visibilityOf(this.contactFormMessage));  //explicit wait
		return this.contactFormMessage.getText();
	}
}
