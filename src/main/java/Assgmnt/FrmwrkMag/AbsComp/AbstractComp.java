package Assgmnt.FrmwrkMag.AbsComp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
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
	By wNew = By.id("ui-id-3");
	@FindBy(id="ui-id-3")
	WebElement whatsNewLnk;
	/*By wNew = By.xpath("//li[@class ='level0 nav-1 category-item first active level-top ui-menu-item']/a");
	@FindBy(xpath="//li[@class ='level0 nav-1 category-item first active level-top ui-menu-item']/a")
	WebElement whatsNewLnk;*/
	
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
	
	public void goToWatches() throws IOException
	{		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Assgmnt\\FrmwrkMag\\resources\\GlobalData.properties");
	 	prop.load(fis);
	 	String wtchLnk = prop.getProperty("watchlink");
	 	driver.switchTo().newWindow(WindowType.TAB); Set<String> windows =
		 driver.getWindowHandles();
		 Iterator<String> it = (Iterator)windows.iterator();
		 pid = it.next(); 
		 String chld1 = it.next();
		 driver.switchTo().window(chld1);
		 driver.get(wtchLnk);
		
	}
	public void goToWhtsNew() throws InterruptedException
	{
	
		waitForElementToAppear(wNew);
		whatsNewLnk.click();
	}

}
