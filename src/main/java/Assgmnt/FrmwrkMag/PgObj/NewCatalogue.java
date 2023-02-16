package Assgmnt.FrmwrkMag.PgObj;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Assgmnt.FrmwrkMag.AbsComp.AbstractComp;
public class NewCatalogue extends AbstractComp {
	WebDriver driver;
	
	public NewCatalogue(WebDriver driver)
	{
		
		//initialization
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	

	//PageFactory
	@FindBy(xpath="//a[@id='ui-id-3']//span[1]")
	WebElement whatsNewLnk;
	
	@FindBy(xpath="//div[@class='product-item-info']")
	 List<WebElement> newItems;
	@FindBy (xpath="(//div[@class='swatch-option text'])[3]")
	WebElement sizeNew;
	@FindBy (xpath="(//div[@class='swatch-option color'])[2]")
	WebElement colNew;
	@FindBy (css=".action.tocart.primary")
	WebElement cartBtn;
	By newItemsBy = By.xpath("//div[@class='product-item-info']");
	By choItem  = By.cssSelector(".product-item-link");
	By addtnMsg   = By.xpath("//div/div/div[@data-ui-id='message-success']/div");
	By itemLink = By.cssSelector("a.product-item-link");
	By addToCart = By.cssSelector(".action.tocart.primary");
	By colItemNew = By.xpath("(//div[@class='swatch-option color'])[2]");
	By sizeItemNew = By.xpath("(//div[@class='swatch-option text'])[3]");
	public List<WebElement> getProductList()
	{
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,1700)"); 
		waitForElementToAppear(newItemsBy);
		return newItems;
	}
	 
	public WebElement getNewItemByName(String itemWhtsNew)
	{
		  WebElement itemNew = getProductList().stream().filter(product -> 
		  product.findElement(choItem).getText().equals(itemWhtsNew)) .findFirst().orElse(null);
		  return itemNew;
	
	}
	public WatchCatalogue addNewItemtoCart(String itemWhtsNew )
	{	 Actions action = new Actions(driver); 
		WebElement Item = getNewItemByName(itemWhtsNew);
		 WebElement newProd = Item.findElement(itemLink);
		 action.moveToElement(newProd).perform();
		Item.findElement(addToCart).click();
		waitForElementToAppear(sizeItemNew);
		sizeNew.click();
		colNew.click();
		cartBtn.click();
		waitForElementToAppear(addtnMsg);
		WatchCatalogue watchCatalogue = new WatchCatalogue(driver);
		return watchCatalogue;
		
	}
}
