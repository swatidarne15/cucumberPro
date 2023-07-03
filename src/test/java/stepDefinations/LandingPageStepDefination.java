package stepDefinations;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.ExcelDataprovider;
import utils.TestContextSetup;

public class LandingPageStepDefination {
	TestContextSetup testContextSetup;
	LandingPage landingpage;
	ExcelDataprovider dp= new ExcelDataprovider();
	public LandingPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.landingpage=testContextSetup.pageObjectManager.getLandingPage();
		
	}
	
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() throws IOException, EncryptedDocumentException, InvalidFormatException {
Assert.assertTrue(landingpage.getTitleLandingPage().contains("GreenKart"));


    //  System.out.println(dp.getData("Sheet1",1, 3));
	}
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		//LandingPage landingpage=new LandingPage(testContextSetup.driver);
		landingpage.searchItem(shortName);
	   Thread.sleep(2000);
	   testContextSetup.productName = landingpage.getProductName().split("-")[0].trim();
	System.out.println(testContextSetup.productName);
	System.out.println("at when");
	}
	
	

//	@When("user searched with Shortname and extracted actual name of product")
//	public void user_searched_with_shortname_and_extracted_actual_name_of_product() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
//		//LandingPage landingpage=new LandingPage(testContextSetup.driver);
//		landingpage.searchItem(ExcelDataprovider.getData("Sheet1", 2, 2));
//	   Thread.sleep(2000);
//	   testContextSetup.productName = landingpage.getProductName().split("-")[0].trim();
//	System.out.println(testContextSetup.productName);
//	System.out.println("at when");
//}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quqntity)
	{
		landingpage.incrementQuantity(Integer.parseInt(quqntity));
	landingpage.addToCart();
	}
	

}
