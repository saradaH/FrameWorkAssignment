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

public class PantsCatalogue extends AbstractComp{
	

	WebDriver driver;


		public PantsCatalogue(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}


		
			
		
		@FindBy (xpath="//a[@id='ui-id-5']/span[2]")
		WebElement mensLink;
		@FindBy(linkText="Bottoms")
		WebElement bottomsLink;
		@FindBy(id="ui-id-23")
		WebElement pantsLink;
		@FindBy(xpath="(//select[@id='sorter']/option[3])[1]")
		WebElement priceSorter;
		@FindBy (css="a.action.sorter-action.sort-asc")
		 WebElement sorterAsc;
		@FindBy (css="li.item.product.product-item")
		 List<WebElement> pantList;
		@FindBy (id ="product-addtocart-button")
		 WebElement cartBtn;
		@FindBy (id ="option-label-size-143-item-177")
		 WebElement pantSize;
		@FindBy (id ="option-label-color-93-item-53")
		 WebElement pantClr;
		By mensLinkWt = By.xpath("//a[@id='ui-id-5']/span[2]");
		By bottomsWt = By.linkText("Bottoms");
		By pantsWt = By.id("ui-id-23)");
		By pantsItem = By.cssSelector(".product-item-link");
		By pantsListBy = By.cssSelector("li.item.product.product-item");
		By choPantBy = By.cssSelector(".product-item-link");
		By cartBtnBy  = By.id("product-addtocart-button");
		By addtnMsg   = By.xpath("//div/div/div[@data-ui-id='message-success']/div");
		By pantSizeBy = By.id("option-label-size-143-item-177");
		
			
		
		public void PantsListing() 
		{
			 
				Actions actions = new Actions(driver);
				waitForElementToAppear(mensLinkWt);
				actions.moveToElement(mensLink).perform();
				actions.moveToElement(bottomsLink).perform();
				//bottomsLink.click();
				//waitForElementToAppear(pantsWt);
				pantsLink.click();
				priceSorter.click();
				if (sorterAsc.getAttribute("title").equalsIgnoreCase("Set Ascending Direction")) 
				{
							sorterAsc.click();
				}
			 
		}


		
		public List<WebElement> getPantsList()
		{
			waitForElementToAppear(pantsListBy);
			return pantList;
		}
		 
		public WebElement getPantByName(String itemPants)
		{
			  WebElement itemNew = getPantsList().stream().filter(product -> 
			  product.findElement(choPantBy).getText().equals(itemPants)) .findFirst().orElse(null);
			  return itemNew;
		
		}
		public UpdateCart addPantstoCart(String itemPants )
		{	Actions action = new Actions(driver); 
			WebElement Item = getPantByName(itemPants);
			WebElement newProd = Item.findElement(choPantBy);
			action.moveToElement(newProd).perform();
			Item.findElement(choPantBy).click();
			waitForElementToAppear(pantSizeBy);
			pantSize.click();
			pantClr.click();
			waitForElementToAppear(cartBtnBy);
			cartBtn.click();
			waitForElementToAppear(addtnMsg);
			UpdateCart updateCart = new UpdateCart(driver);
			return updateCart;
		}
	
}
