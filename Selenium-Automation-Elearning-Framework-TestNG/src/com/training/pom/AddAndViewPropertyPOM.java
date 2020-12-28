package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddAndViewPropertyPOM {
	
	private WebDriver driver;
	private Actions act;
	
	public AddAndViewPropertyPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement properties;
	
	//add property
	@FindBy(linkText="Add New")
	private WebElement addNew;
	
	@FindBy(xpath="//input[@id='title']")
	private WebElement enterTitle;
	
	@FindBy(id="content")
	private WebElement textBox;
	
	@FindBy(id="_price")
	private WebElement price;
	
	@FindBy(id="_price_per")
	private WebElement pricePerSq;
	
	@FindBy(xpath="//*[contains(text(),'Main Details')]")
	private WebElement mainDetails;
	
	@FindBy(name="_status")
	private WebElement status;
	
	@FindBy(name="_location")
	private WebElement location;
	
	@FindBy(name="_possession")
	private WebElement possession;
	
	@FindBy(xpath="//*[contains(text(),'Location')]")
	private WebElement locationTab;
	
	@FindBy(name="_friendly_address")
	private WebElement address;
	
	@FindBy(id="_address")
	private WebElement mapAddress;
	
	@FindBy(id="_geolocation_lat")
	private WebElement latitude;
	
	@FindBy(id="_geolocation_long")
	private WebElement longitude;
	
	@FindBy(linkText="Details")
	private WebElement detailsTab;
	
	@FindBy(id="_storage_room")
	private WebElement storageRoom;
	
	@FindBy(xpath="//label[contains(text(),' Central Bangalore')]/child::input")
	private WebElement centralBangalore;
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publish;
	
	//view property
	@FindBy(linkText="All Properties")
	private WebElement allProperties;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement search;
	
	
	public void clcikProperties() {
		//act=new Actions(driver);
		//act.moveToElement(this.properties).build().perform();
		this.properties.click();
	}
	
	//add new property
	public void clikAddNewLink() {
		this.addNew.click();
	}
	
	public String getAddNewLink() {
		return this.addNew.getText();
	}
	
	public void sendTitle(String enterTitle) {
		this.enterTitle.sendKeys(enterTitle);
	}
	
	public void writeIntoTextbox(String textBox) {
		this.textBox.sendKeys(textBox);
	}
	
	public void sendPrice(String price) {
		this.price.sendKeys(price);
	}
	
	public void sendPricePerSq(String pricePerSq) {
		this.pricePerSq.sendKeys(pricePerSq);
	}
	
	public void clickMainDetails() {
		this.mainDetails.click();
	}
	
	public void sendStatus(String status) {
		this.status.sendKeys(status);
	}
	
	public void sendLocation(String location) {
		this.location.sendKeys(location);
	}
	
	public void sendPossession(String possession) {
		this.possession.sendKeys(possession);
	}
	
	public void clickLocationTab() {
		this.locationTab.click();
	}

	public void sendAddress(String address) {
		this.address.sendKeys(address);
	}
	
	public void sendMapAddress(String mapAddress) {
		this.mapAddress.sendKeys(mapAddress);
	}
	
	public void sendLatitude(String latitude) {
		this.latitude.sendKeys(latitude);
	}
	
	public void sengLongitude(String longitude) {
		this.longitude.sendKeys(longitude);
	}
	
	public void clickDetailsTab() {
		this.detailsTab.click();
	}
	
	public void sendStorageRoom(String storageRoom) {
		this.storageRoom.sendKeys(storageRoom);
	}
	
	
	//select Central Bangalore checkBox  inside KeywordTgs
	public void selectRegion() throws InterruptedException {
		Thread.sleep(3000);
		this.centralBangalore.click();
	}
	
	public void clickPublish() {
		
			this.publish.click();
	}
	
	//view properties
	public void clickAllPropertiesLink() {
			this.allProperties.click();
			
	}
	
	public String getAllpropertiesLink() {
		
		return this.allProperties.getText();

	}
	
	public void searchProperty(String propertryTitle) {
		this.search.sendKeys(propertryTitle);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  //implicit wait
		act=new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();                        //keyboard action:enter
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	
	public boolean isViewAddedProperty(String propertyTitle) {      
		boolean found = false;
		String before="//tbody[@id='the-list']/tr";
		String after="]/td[1]/strong[1]/a[1]"	;
		int count=driver.findElements(By.xpath(before)).size();
		for(int i=1;i<=count;i++) {
			
			try {
			String title=driver.findElement(By.xpath(before+"["+i+after)).getText();
			
			if(title.equals(propertyTitle)) 
			{
			    return true;
			   
				}
			
			}catch(NoSuchElementException e)
			{
				found=false;
			
				}
		}
		return found;
			
	}
		
		
}
