package Assgmnt.FrmwrkMag.PgObj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Assgmnt.FrmwrkMag.AbsComp.AbstractComp;

public class UpdateCart extends AbstractComp 
{
		WebDriver driver;
		
		public UpdateCart(WebDriver driver)
		{
			super(driver);
			//initialization
			this.driver =driver;
			PageFactory.initElements(driver,this);
		}
		
		@FindBy (css = "span.counter-number")
		WebElement cartCounter;
		@FindBy (css="a.action.showcart")
		WebElement showCart;
		@FindBy (css = "a.action.viewcart")
		WebElement viewCart;
		@FindBy (css = "tbody.cart.item")
		List<WebElement>  cartItemsList;
		@FindBy (xpath = "//tr/td/strong/span")
		WebElement totValue;
		@FindBy (xpath = "//ul/li/button/span")
		WebElement chkOutBtn;
		@FindBy (css="button.action.update")
		WebElement updateBtn;
		By cartCounterWt = By.cssSelector("span.counter-number");
		By totValWt = By.xpath("//tr/td/strong/span");
		By chkOutBtnWt = By.xpath("//ul/li/button/span");
		By cartItemWt = By.cssSelector("strong.product-item-name");
		By cartItemQty = By.cssSelector("input[data-role='cart-item-qty']");
		By upDateCartWt = By.cssSelector("button.action.update");
		By viewCartWt = By.cssSelector("a.action.viewcart");
		By cartItemListWt = By.cssSelector("tbody.cart.item");
		By QtyChosenWt = By.cssSelector("input[data-role='cart-item-qty']");
		
		public String updateCartQty(String pantItemName)
		{
			Actions actions = new Actions(driver);
			waitForElementToAppear(cartCounterWt);
			showCart.click();
			waitForElementToAppear(viewCartWt);
			viewCart.click();
			driver.navigate().refresh();
			
			
			WebElement ItemUpd = getItemByName(pantItemName);
			ItemUpd.findElement(QtyChosenWt).clear();
			ItemUpd.findElement(QtyChosenWt).sendKeys("4");
			updateBtn.click();
			driver.navigate().refresh();
			waitForElementToAppear(totValWt);
			String cartVal = totValue.getText();
			
			waitForElementToAppear(chkOutBtnWt);
			actions.moveToElement(chkOutBtn).perform();
			chkOutBtn.click();
			return cartVal;
	
		}

		
		public List<WebElement> getItemList()
		{
			waitForElementToAppear(cartItemListWt);
			return cartItemsList;
		}
		
		public WebElement getItemByName(String pantItemName)
		{
			  WebElement itemPantQty = getItemList().stream().filter(product -> 
			  product.findElement(cartItemWt).getText().equals(pantItemName)) .findFirst().orElse(null);
			  return itemPantQty;
		
		}
		
		
	
}
