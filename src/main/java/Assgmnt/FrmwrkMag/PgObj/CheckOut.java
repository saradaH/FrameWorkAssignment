package Assgmnt.FrmwrkMag.PgObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Assgmnt.FrmwrkMag.AbsComp.AbstractComp;

public class CheckOut extends AbstractComp {
	WebDriver driver;
	public CheckOut(WebDriver driver) {
			// TODO Auto-generated constructor stub

			super(driver);
			//initialization
			this.driver =driver;
			PageFactory.initElements(driver,this);
	
	}
	
	@FindBy(xpath="//div/button[@class='action action-show-popup']")
	WebElement newAddBtn;
	@FindBy(xpath="//input[@name='street[0]']")
	WebElement streetFld;
	@FindBy(xpath="//input[@name='city']")
	WebElement cityFld;
	@FindBy(xpath="//select[@name='region_id']")
	WebElement regionFld;
	@FindBy(xpath="//input[@name='postcode']")
	WebElement postCodeFld;
	@FindBy(xpath="//select[@name='country_id']")
	WebElement countryFld;
	@FindBy(xpath=("//input[@name='telephone']"))
	WebElement telephoneFld;
	@FindBy(xpath=("//input[@name='ko_unique_1']"))
	WebElement tableRate;	
	@FindBy(xpath="//button[@class='button action continue primary']/span")
	WebElement nextBtn;
	@FindBy(xpath="//div/button[@class='action primary checkout']")
	WebElement placeOrderBtn;
	@FindBy(xpath = "//div[@class='page-title-wrapper']/h1/span")
	WebElement conFrmMsg;
	@FindBy(xpath = "//tr/td/span[@data-th='Cart Subtotal']")
	WebElement finalCrtSubTot;
	By nextBtnWt = By.xpath("//button[@class='button action continue primary']/span");
	By newAddBtnWt = By.xpath("//div/button[@class='action action-show-popup']");
	By placeOrderBtnWt = By.xpath("//div/button[@class='action primary checkout']");
	By conFrmMsgWt= By.xpath("//div[@class='page-title-wrapper']/h1/span");
	By finalCrtValWt= By.xpath("//tr/td[@data-th='Order Total']/strong");
	
	public String processPayment(String street ,String city , String postCode ,String telephone) throws InterruptedException
	{
		Actions actions = new Actions(driver);	
		Thread.sleep(5000);
		waitForElementToAppear(nextBtnWt);
		if (!(newAddBtn.isDisplayed()))
		{
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='street[0]']"))));
			streetFld.sendKeys(street);
			cityFld.sendKeys(city);
		postCodeFld.sendKeys(postCode);
		WebElement staticDdCtry= countryFld;
		Select dropdownCtry= new Select(staticDdCtry);
		dropdownCtry.selectByIndex(1);
		WebElement staticDdState = regionFld;
		Select dropdownSt= new Select(staticDdState);
		dropdownSt.selectByIndex(1); 
		postCodeFld.sendKeys(postCode);
		telephoneFld.sendKeys(telephone);
	
		actions.moveToElement(tableRate).perform();
		tableRate.click();
	
		actions.moveToElement(nextBtn).perform();
		nextBtn.click();
		
		
	}
	//tableRate.click();
	waitForElementToAppear(nextBtnWt);
	nextBtn.click();
	
	waitForElementToAppear(finalCrtValWt);
	String finalSubTot= finalCrtSubTot.getText();
	waitForElementToAppear(placeOrderBtnWt);
	
	//actions.moveToElement(placeOrderBtn).perform();
	
	Thread.sleep(5000);
	placeOrderBtn.click();
	waitForElementToAppear(conFrmMsgWt);
	return finalSubTot;
	
	//String orNbr = driver.findElement(By.xpath("//div/p/a[@class='order-number']/strong")).getText();
	//System.out.println(orNbr);
		  
	
	}
}
