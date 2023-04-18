package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Basepage
{
public HomePage(WebDriver driver)
{
	super(driver);
}

@FindBy(xpath="//a//span[text()='My Account']")
WebElement acc;

@FindBy(xpath="//a[text()='Register']")
WebElement reg;

@FindBy(xpath="//li//a[text()='Login']")
WebElement lg;

public void clickaccount()
{
	acc.click();
}
public void clickregister()
{
	reg.click();
}
public void hlogin()
{
	lg.click();
}
}
