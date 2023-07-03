package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class offerPage {
	public WebDriver driver;
	
	public offerPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	private By search=By.xpath("//input[@type='search']");
	private By productName=By.xpath("//td[1]");
	
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	public void getSearchText()
	{
		driver.findElement(search).getText();
	}
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
}
