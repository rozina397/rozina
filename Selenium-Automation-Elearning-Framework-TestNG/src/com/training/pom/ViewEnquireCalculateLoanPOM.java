package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewEnquireCalculateLoanPOM {
	private WebDriver driver;
	public Actions act;
	
	
	
	public ViewEnquireCalculateLoanPOM(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@id='responsive']/li//child::a[contains(text(),'New Launch')]")
	private WebElement newLaunch;
	
	@FindBy(linkText="Nullam hendrerit Apartments")
	private WebElement nullamApart;
	
	@FindBy(xpath="//div[@class='col-md-12']//div//button[@aria-label='Next']")
	private WebElement nextImage;
	
	@FindBy(name="your-name")
	private WebElement name;
	
	@FindBy(name="your-email")
	private WebElement email;
	
	@FindBy(name="your-subject")
	private WebElement subject;
	
	@FindBy(name="your-message")
	private WebElement message;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement send;
	
	@FindBy(id="amount")
	private WebElement salePrice;
	
	@FindBy(id="downpayment")
	private WebElement downpayment;
	
	@FindBy(id="years")
	private WebElement loanTerm;
	
	@FindBy(id="interest")
	private WebElement interest;
	
	@FindBy(xpath="//button[contains(@class,'button calc-button')]")
	private WebElement calculate;
	
	@FindBy(xpath="//div[contains(@class,'notification success')]")
	private WebElement displayMessage;
	
	@FindBy(xpath="//strong[contains(@class,'calc-output')]")
	private WebElement monthlyPayment;
	
	
	public void mouseHoverNewLaunch() throws InterruptedException {
		act=new Actions(driver);
		act.moveToElement(this.newLaunch).build().perform();
	}

	public void clicknullamApartLink() {
		this.nullamApart.click();
	}
	
	public void clickNextImage(){
		act=new Actions(driver);
		act.moveToElement(this.nextImage).build().perform();
		this.nextImage.click();
	}
	
	public void sendName(String name) {
		this.name.sendKeys(name);
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendSubject(String subject) {
		this.subject.clear();
		this.subject.sendKeys(subject);
	}
	
	public void sendMessage(String message) {
		this.message.clear();
		this.message.sendKeys(message);
		
	}
	
	public void clicksend() {
		this.send.click();
	}
	
	public void sendSalePrice(String salePrice) {
		this.salePrice.clear();
		this.salePrice.sendKeys(salePrice);
	}
	
	public void sendDownPayment(String downPayment) {
		this.downpayment.clear();
		this.downpayment.sendKeys(downPayment);
	}

	public void sendYear(String loanTerm) {
		this.loanTerm.clear();
		this.loanTerm.sendKeys(loanTerm);
		
	}

	public void sendInterestRate(String interest) {
		this.interest.clear();
		this.interest.sendKeys(interest);
	
	}
	
	public void clickCalculate() {
		this.calculate.click();
		act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();    //scroll the page down
	}
	
	public String successMessage(){
		WebDriverWait ewait=new WebDriverWait(driver,100);
		ewait.until(ExpectedConditions.visibilityOf(this.monthlyPayment)); //explicit wait
		return this.displayMessage.getText();
	}
}
