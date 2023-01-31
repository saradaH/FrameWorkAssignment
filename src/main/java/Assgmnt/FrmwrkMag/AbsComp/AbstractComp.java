package Assgmnt.FrmwrkMag.AbsComp;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AbstractComp {
	
	WebDriver driver;
	public static String pid;
	public static SoftAssert sAss;
	
	public AbstractComp(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}
	By wNew = By.xpath("//a[@id='ui-id-3']/span[1]");
	@FindBy(xpath="//a[@id='ui-id-3']/span[1]")
	WebElement whatsNewLnk;
	
	
	public void waitForElementToAppear(By findBy)
	{
	
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement ele)
	{
	
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void goToWatches()
	{
		 driver.switchTo().newWindow(WindowType.TAB); Set<String> windows =
		 driver.getWindowHandles();
		 Iterator<String> it = (Iterator)windows.iterator();
		 pid = it.next(); 
		 String chld1 = it.next();
		 driver.switchTo().window(chld1);
		 driver.get("https://magento.softwaretestingboard.com/gear.html");
		
	}
	public void goToWhtsNew()
	{
		waitForElementToAppear(wNew);
		whatsNewLnk.click();
	}

}
