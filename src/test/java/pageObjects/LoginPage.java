package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Basepage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='email']")
	WebElement em;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement ps;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement ln;
	
	public void mail(String ml)
	{
		em.sendKeys(ml);
	}
	
	public void paswrd(String pw)
	{
		ps.sendKeys(pw);
	}
	
	public void lg()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ln);
	}
}
