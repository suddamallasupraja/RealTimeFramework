package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Amazonpage extends Basepage
{
	public Amazonpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement en;
	@FindBy(xpath="//span//input[@id='nav-search-submit-button']")
	WebElement se;
	@FindBy(xpath="//span[@class='s-pagination-strip']//*[text()='+i+']")
	WebElement pe;
	
	
	public void key()
	{
		en.sendKeys("tees for women");
	}
	public void search()
	{
		se.click();
	}
	

	
	public void pagination() throws InterruptedException
	{
		for(int i=1;i<=7;i++)
		{
			WebElement path=driver.findElement(By.xpath("//span[@class='s-pagination-strip']//*[text()="+i+"]"));
			path.click();
		/*	Thread.sleep(4000);
			if(path.getText().equals(i))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}*/
		}
	}
}
