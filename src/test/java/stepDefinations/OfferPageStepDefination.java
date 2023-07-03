package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import pageObjects.offerPage;
import utils.TestContextSetup;

public class OfferPageStepDefination {

	public String offerProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	//Single responsibilty Principle
	//loosly coupled
	//factory design
	public OfferPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@Then("^user searched for (.+) shortname in offers page to check if product exist$")
	public void user_searched_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) {
	
		switchToOfferPage();
		offerPage offersPage=testContextSetup.pageObjectManager.getOfferPage();
		offersPage.searchItem(shortName);
	//	testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	offerProductName=offersPage.getProductName();
	System.out.println(	offerProductName);
	System.out.println("at then");

	}
	public void switchToOfferPage()
	{
		//if switched to offer page->skip below part
		//if(testContextSetup.driver.getCurrentUrl().equalIgnoreCase
		//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		//pageObjectManager=new PageObjectManager(testContextSetup.driver);
		LandingPage landingpage=testContextSetup.pageObjectManager.getLandingPage();
		//LandingPage landingpage=new LandingPage(testContextSetup.driver);
		landingpage.selectTopDealPage();
		testContextSetup.genericUtils.SwitchWindowToChild();
	}
	@And("validate product name in offers page matches with Landing Page")
	public void validate_product_name()
	{
		Assert.assertEquals(testContextSetup.productName, offerProductName);
		System.out.println("at and");

	}

}
