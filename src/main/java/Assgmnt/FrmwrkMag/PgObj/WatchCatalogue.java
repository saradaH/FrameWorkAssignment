package Assgmnt.FrmwrkMag.PgObj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Assgmnt.FrmwrkMag.AbsComp.AbstractComp;

public class WatchCatalogue extends AbstractComp{
	WebDriver driver;
	public WatchCatalogue(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy (xpath="//a[@id='ui-id-6']")
	WebElement gearLink;
	@FindBy(linkText="Watches")
	WebElement watches;
	@FindBy(xpath="//div[normalize-space()='Price']")
	WebElement price;
	@FindBy(css="a[href='https://magento.softwaretestingboard.com/gear/watches.html?price=40-50']")
	WebElement lowPrice;
	@FindBy (xpath="//div[normalize-space()='Material']")
	 WebElement Material;
	@FindBy (xpath="((//div[@aria-hidden = 'false'])[2]/ol/li/a)[3]")
	 WebElement rubberMtl;
	@FindBy (css="li.item.product.product-item")
	 List<WebElement> watchList;
	@FindBy (id ="product-addtocart-button")
	 WebElement cartBtn;
	By gearLinkWt = By.xpath("//a[@id='ui-id-6']");
	By watchesWt = By.linkText("Watches");
	By priceWt = By.xpath("//div[normalize-space()='Price']");
	By MaterialWt = By.xpath("//div[normalize-space()='Material']");
	By rubberMtlWt = By.xpath("((//div[@aria-hidden = 'false'])[2]/ol/li/a)[3]");
	By watchItem = By.cssSelector(".product-item-link");
	By watchListBy = By.cssSelector("li.item.product.product-item");
	By choWatchBy = By.cssSelector(".product-item-link");
	By cartBtnBy  = By.id("product-addtocart-button");
	By addtnMsg   = By.xpath("//div/div/div[@data-ui-id='message-success']/div");
	By lowPriceWt = By.cssSelector("a[href='https://magento.softwaretestingboard.com/gear/watches.html?price=40-50']");
	
	public void WatchListing() 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToAppear(gearLinkWt );
		gearLink.click(); 
		waitForElementToAppear(watchesWt);
		watches.click(); 
		 js.executeScript("window.scrollBy(0,1700)");
		 waitForElementToAppear(priceWt);
		 price.click();
		 waitForElementToAppear(lowPriceWt);
		 lowPrice.click();
		 waitForElementToAppear(MaterialWt);
		 Material.click();
		 waitForElementToAppear(rubberMtlWt);
		 rubberMtl.click(); 
	
	}


	
	public List<WebElement> getWatchesList()
	{
		waitForElementToAppear(watchListBy);
		return watchList;
	}
	 
	public WebElement getWatchByName(String itemWatch)
	{
		  WebElement itemNew = getWatchesList().stream().filter(product -> 
		  product.findElement(choWatchBy).getText().equals(itemWatch)) .findFirst().orElse(null);
		  return itemNew;
	
	}
	public PantsCatalogue addWatchtoCart(String itemWatch )
	{	 Actions action = new Actions(driver); 
		WebElement Item = getWatchByName(itemWatch);
		 WebElement newProd = Item.findElement(choWatchBy);
		 action.moveToElement(newProd).perform();
		Item.findElement(choWatchBy).click();
		waitForElementToAppear(cartBtnBy);
		cartBtn.click();
		waitForElementToAppear(addtnMsg);
		 driver.close(); 
		 driver.switchTo().window(AbstractComp.pid); 
		 driver.navigate().back();
		 driver.navigate().refresh();
		PantsCatalogue pantsCatalogue = new PantsCatalogue(driver);
		return pantsCatalogue;
	}
}
