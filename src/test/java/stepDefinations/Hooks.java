package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup testContextSetup;
	public Hooks(TestContextSetup testContexSetup)
	{
		
		this.testContextSetup= testContexSetup;
	}
	@After
	public void AfterScenario() throws IOException
	{
		System.out.println(testContextSetup);
		//System.out.println(testContextSetup.testBase.WebDriverManager());
		
		testContextSetup.testBase.WebDriverManager().quit();	}

@AfterStep
public void AddScreenshot(Scenario scenario) throws IOException
{
	WebDriver driver=testContextSetup.testBase.WebDriverManager();
	if(scenario.isFailed())
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	byte[] fileContent=FileUtils.readFileToByteArray(source);
		scenario.attach(fileContent,"image/png","image");
	}
	
}
}
