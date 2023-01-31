package Assgmnt.FrmwrkMag.PgObj;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Assgmnt.FrmwrkMag.AbsComp.AbstractComp;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewAccount extends AbstractComp {
	WebDriver driver;
	public static String firstName;
	public static String lastName;
	public static String usId;
	public static String pCode;
	public NewAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="(//ul/li[3]/a)[1]")
	WebElement creAccount;
	@FindBy(id="firstname")
	WebElement fstName;
	@FindBy(id="lastname")
	WebElement LstName;
	@FindBy(id="email_address")
	WebElement emailadd;
	@FindBy(id="password")
	WebElement paswd;
	@FindBy(id="password-confirmation")
	WebElement cfmpaswd;
	@FindBy(xpath="//button[@class='action submit primary']")
	WebElement cAccBtn;
	@FindBy(xpath="//div[@data-ui-id = 'message-success']")
	WebElement accSuccess;
	@FindBy(xpath="//div/h1[@class='page-title']/span")
	WebElement myAcc;      
	@FindBy(xpath="//div/div[@data-ui-id='message-error']/div")
	WebElement errMsgReg;

	public void registerAccount(String fName,String lName,String emailId,String password)
	{
		waitForWebElementToAppear(creAccount);
	//	driver.findElement(By.xpath("(//ul/li[3]/a)[1]")).click();
		creAccount.click();
		firstName = fName;
		fstName.sendKeys(fName);
		lastName = lName;
		LstName.sendKeys(lName);
		usId = emailId;
		emailadd.sendKeys(emailId);
		pCode = password;
		paswd.sendKeys(password);
		cfmpaswd.sendKeys(password);
		cAccBtn.click();
			
	}

	

	public String duplicateAccount() {
		
		return errMsgReg.getText();	
	}
	
	public String creationConfirm()
	{
		return accSuccess.getText();
	}
}
