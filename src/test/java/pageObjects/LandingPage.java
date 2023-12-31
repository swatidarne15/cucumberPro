package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By search=By.xpath("//input[@type='search']");
	By topDeals=By.linkText("Top Deals");
	By productName=By.cssSelector("h4.product-name");
	By increment=By.cssSelector("a.increment");
	By addToCart=By.cssSelector(".product-action button");
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	public void getSearchText()
	{
		driver.findElement(search).getText();
	}
	public void incrementQuantity(int quantity)
	{
		int i=quantity;
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
	}
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	public void selectTopDealPage()
	{
		driver.findElement(topDeals).click();
	}
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
}
