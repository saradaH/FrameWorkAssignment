package Assgmnt.FrmwrkMag.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Assgmnt.FrmwrkMag.PgObj.NewAccount;
import Assgmnt.FrmwrkMag.TestComponents.BaseTest;

public class CreateAcc extends BaseTest {
	
	@Test(description = "New Account Creation")
	public void createAccount() throws IOException
	{
		// TODO Auto-generated method stub
		
		//launchApplication();

	
		NewAccount newAcc = new NewAccount(driver);
		newAcc.registerAccount("sdsqqq", "ppp", "zzzz@gmail.com", "nji90okm)");
		String accCreated = newAcc.creationConfirm();
		String dispAccCreatn = "Thank you for registering with Fake Online Clothing Store.";
		assertMessages(accCreated,dispAccCreatn);

	}
	@Test(description="Account Creation Failure")
	public void invalidAccData()
	{	NewAccount newAcc = new NewAccount(driver);
		newAcc.registerAccount("jppp", "jqqq", "ppp.qqq@gmail.com", "nji90okm)");
		String msgLgnFail = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
		String loginFailure = newAcc.duplicateAccount();
		assertMessages(loginFailure,msgLgnFail);
		
	}
}
