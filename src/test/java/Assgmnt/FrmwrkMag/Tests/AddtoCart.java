package Assgmnt.FrmwrkMag.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Assgmnt.FrmwrkMag.PgObj.CheckOut;
import Assgmnt.FrmwrkMag.PgObj.NewCatalogue;
import Assgmnt.FrmwrkMag.PgObj.PantsCatalogue;
import Assgmnt.FrmwrkMag.PgObj.UpdateCart;
import Assgmnt.FrmwrkMag.PgObj.WatchCatalogue;
import Assgmnt.FrmwrkMag.TestComponents.BaseTest;

public class AddtoCart extends BaseTest {

	@Test(description = "Addition of specific items to cart")
	public void addToCart() throws IOException, InterruptedException
	{
		String uId= "dumtest@gmail.com" ;
		String pwd = "zaq12wsx@21";
		
		String newItem = "Phoebe Zipper Sweatshirt";
		String watchItemName = "Endurance Watch";
		String pantsItemName = "Mithra Warmup Pant";
		String streetVal = "121,Near Phoenix Mall";
		String cityVal = "Pune";
		String postCode = "123456-6789";
		String telephone = "1234567899";
		//loginapp.loginApplication(uId, pwd);
	
		launchApp.loginApplication("dumtest@gmail.com" , "zaq12wsx@21");
		launchApp.goToWhtsNew();

		NewCatalogue newCatalogue = new NewCatalogue(driver);
		//List<WebElement>newItems = newCatalogue.getProductList();
		WatchCatalogue  watchCatalogue = (WatchCatalogue) newCatalogue.addNewItemtoCart(newItem); 
		watchCatalogue.goToWatches();
		watchCatalogue.WatchListing();
		PantsCatalogue pantsCatalogue = (PantsCatalogue)watchCatalogue.addWatchtoCart(watchItemName);
		pantsCatalogue.PantsListing();
		UpdateCart updateCatalogue = (UpdateCart)pantsCatalogue.addPantstoCart(pantsItemName);
		String totCartVal = updateCatalogue.updateCartQty(pantsItemName);
		System.out.println(totCartVal);
		CheckOut chkout = new CheckOut(driver);
		String finalCrtVal = chkout.processPayment(streetVal, cityVal, postCode, telephone);
		assertMessages(totCartVal,finalCrtVal);  
		  

	} 

}


