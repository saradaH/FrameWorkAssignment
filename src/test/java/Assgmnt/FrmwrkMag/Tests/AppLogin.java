package Assgmnt.FrmwrkMag.Tests;

import org.testng.annotations.Test;

import Assgmnt.FrmwrkMag.TestComponents.BaseTest;

public class AppLogin extends BaseTest{
	@Test(description = "Successful Login")
	public void appLogin() throws InterruptedException {
		// TODO Auto-generated method stub
		
		

		 launchApp.loginApplication("dumtest@gmail.com" , "zaq12wsx@21");
		
	
		
		String welDispName = launchApp.succSignName();

		
  	    String logOutTxt = launchApp.logOut();
		
		assertMessages(logOutTxt, "You are signed out"); 
				
	}
	
	@Test (description = "UnSuccessful Login") 
	public void invalidLogin()
	{	
		 launchApp.loginApplication("dumtest@gmail.com" , "zaq34wsx@21");
		 String errormsg = launchApp.loginError();
		 String actErMsg = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
		 assertMessages(errormsg,actErMsg);
	}

}
