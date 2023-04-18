package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends Basepage
{
public RegistrationPage(WebDriver driver)
{
	super(driver);
}
@FindBy(name="firstname")
WebElement name;
@FindBy(name="lastname")
WebElement name1;
@FindBy(name="email")
WebElement mail;
@FindBy(name="password")
WebElement pass;
@FindBy(xpath="//input[@name='agree']")
WebElement box;
@FindBy(xpath="//button[text()='Continue']")
WebElement con;
@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
WebElement cretd;

public void fname(String fn)
{
	name.sendKeys(fn);
}
public void lname(String ln)
{
	name1.sendKeys(ln);
}
public void mil(String eml)
{
	mail.sendKeys(eml);
}
public void pas(String pw)
{
	pass.sendKeys(pw);
}
public void ag()
{
	//box.click();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",box );
}
public void cont()
{
	//con.click();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",con );
}
public String succ()
{ 
	try
{
	String cre=cretd.getText();
	return cre;
}
catch(Exception pblm)
{
	return ("unable to fetch text");
}
}
}
