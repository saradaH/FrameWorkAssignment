package Assgmnt.FrmwrkMag.PgObj;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Assgmnt.FrmwrkMag.AbsComp.AbstractComp;
public class login extends AbstractComp {
	WebDriver driver;
	
	public login(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(id="email")
	WebElement usrEmail;
	@FindBy(id="pass")
	WebElement pwd;
	@FindBy(xpath="//button[@class='action login primary'] ")
	WebElement lgnBtn;
	@FindBy(linkText="Sign In")
	WebElement signInLnk;
	@FindBy(xpath="//div/h1[@class='page-title']/span")
	WebElement myAcc;
	@FindBy(xpath="//header/div[1]/div[1]/ul[1]/li[1]/span[1]")
	WebElement welMsg;
	@FindBy(xpath="//div[@class='box-content']/p")
	WebElement fullName;
	
	@FindBy(xpath="//header/div[1]/div[1]/ul[1]/li[2]/span[1]/button[1]")
	WebElement welcmToggle;
	@FindBy(linkText="Sign Out")
	WebElement signOut;
	@FindBy(css ="span[data-ui-id='page-title-wrapper']")
	WebElement lgOutMsg;
	@FindBy(xpath="//div/div[@data-ui-id='message-error']/div")
	WebElement errMsgReg;
	
	
	
	public void loginApplication(String email,String password)
	{
	signInLnk.click();
	usrEmail.sendKeys(email);
	pwd.sendKeys(password);
	lgnBtn.click();

	}
	public String loginError()
	{
		return errMsgReg.getText();
	}
	
	public String verifylogin()
	{
		waitForWebElementToAppear(myAcc);
		waitForWebElementToAppear(fullName);
		System.out.println(fullName.getText());
		return fullName.getText();
	}
	public void goTo()
	{
		driver.get("https://magento.softwaretestingboard.com");
	}
	public String succSignName() throws InterruptedException
	{
		Thread.sleep(2000);
		String dispName = welMsg.getText();
		System.out.println(dispName);
		String[] dispNameArray =dispName.split(",");
		System.out.println(dispNameArray.length);
		dispName= dispNameArray[1];
		dispName = (dispName.substring(0, dispName.length()-1));
		dispName= dispName.trim();
		System.out.println(dispName);
		return dispName;
	}

	public String logOut()
	{
		welcmToggle.click();
		waitForWebElementToAppear(signOut);
		signOut.click();
		waitForWebElementToAppear(lgOutMsg);
		String logOutTxt =lgOutMsg.getText();
		return logOutTxt;
		
	}
}
