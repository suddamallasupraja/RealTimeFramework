package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends Basepage
{
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
   }
	@FindBy(xpath="//h2[1]")
WebElement ap;
	@FindBy(xpath="//li//a[text()='Logout']")
	WebElement lo;
	public String acpage()
	{
		String bp=ap.getText();
		try 
		{
			return(bp);
		}
		catch(Exception e)
		{
			return("Didn't find any text ");
		}
		
	}
	public void logout()
	{
		lo.click();
	}
}
