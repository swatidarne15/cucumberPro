package stepDefinations;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefination {
	TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();

	}
	
@Then("verify user has ability to enter promo code and place the order")
public void verify_user_has_abillity_enter_promo()
{
	Assert.assertTrue(checkoutPage.VerifyPromoBtn());
Assert.assertTrue(checkoutPage.VerifyPlaceOrder());	

}

@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
public void user_proceeds_to_checkout(String name) throws InterruptedException
{
	checkoutPage.CheckoutItems();
	Thread.sleep(2000);
	//Assertion to extract name from screen and compare with name
}

}
