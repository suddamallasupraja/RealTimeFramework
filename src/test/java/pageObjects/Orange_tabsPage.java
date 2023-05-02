package pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Orange_tabsPage extends Basepage
{
 public  Orange_tabsPage(WebDriver driver)
	{
		super(driver);
	}

@FindBy(xpath="//p//a")
WebElement ck;
@FindBy(xpath="//input[@name='action_request']")
WebElement ng;

////a[text()='OrangeHRM, Inc']
public void orngehrm() throws InterruptedException
{
	Thread.sleep(3000);
	ck.click();
	
}

/*@SuppressWarnings("unlikely-arg-type")
public void tab()
{
	Set<String> wh=driver.getWindowHandles();
	for(String windowid:wh)
	{
		String id=driver.switchTo().window(windowid).getTitle();
		if(id.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM"))
		{
			ng.click();
		}
	}
	driver.close();
	
	
} */
public void chk()
{
	ng.click();
}


	
}


