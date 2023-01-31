package Assgmnt.FrmwrkMag.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import Assgmnt.FrmwrkMag.PgObj.login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public login launchApp;
	public WebDriver initializeDriver() throws IOException
	{
		//properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Assgmnt\\FrmwrkMag\\resources\\GlobalData.properties");
		 prop.load(fis);
		 String browserName = prop.getProperty("browser");
		 
		 if(browserName.equalsIgnoreCase("chrome"))
		 {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();

		 }
		 else if (browserName.equalsIgnoreCase("firefox"))
		 {
			 //Firefox
		 }
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			return driver;
	}
	@BeforeMethod
	public login launchApplication() throws IOException
	{	
		driver = initializeDriver();
		launchApp = new login(driver);
		launchApp.goTo();
		return launchApp;
	}
	
	public String getScreenShot(String testCaseName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//" + testCaseName + ".png"); 
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+ testCaseName+".png";
		
		
	}
	public void assertMessages(String dspText, String msg)
	{
		 SoftAssert sAss = new SoftAssert();
		 sAss.assertEquals(dspText,msg);
		 sAss.assertAll();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}

