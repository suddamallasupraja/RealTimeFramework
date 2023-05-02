package pageObjects;

//import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.Select;

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

@FindBy(xpath="//a[text()='Phones & PDAs']")
WebElement pp;

@FindBy(xpath="//a[normalize-space()='Desktops']")
WebElement de;

@FindBy(xpath="//a[normalize-space()='Show All Desktops']")
WebElement sad;

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
public void clk()
{
	pp.click();
}
public void demenu()
{
	de.click();
}
public void sadmenu()
{
	sad.click();
}

}
