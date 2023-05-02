package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import stepDefinitions.WebDriverWait;

public class Pagination_page extends Basepage
{

	public Pagination_page(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement nm;
	@FindBy(xpath="//input[@name='password']")
	WebElement ps;
	@FindBy(xpath="//button[@type='submit']")
	WebElement lg;
	@FindBy(xpath="//h1[text()='Dashboard']")
	WebElement ds;
	@FindBy(xpath="//div//ul[@id='menu']//li[@id='menu-customer']")
	WebElement cs;
	@FindBy(xpath="//ul[@id='collapse-5']//li//a[text()='Customers']")
	WebElement cus;
	@FindBy(xpath="//h1[text()='Customers']")
	WebElement cust;
	@FindBy(xpath="//div[text()='Showing 1 to 10 of 12333 (1234 Pages)']")
	WebElement co;
	@FindBy(xpath="//ul[@class='pagination']//li['+s+']")
	WebElement pgs;
	@FindBy(xpath="//button[@class='btn-close']")
	WebElement al;
	
	public void name(String uname)
	{
		nm.sendKeys(uname);
	}
	public void pword(String word)
	{
		ps.sendKeys(word);
	}
	public void login()
	{
		lg.click();
	}
	public String dashb()
	{
		al.click();
	String txt=	ds.getText();
	return txt;
	}
	public void custo()
	{
		cs.click();
	}
	public void costom()
	{
		cus.click();
	}
	public String customd()
	{
		String ctxt=cust.getText();
		return ctxt;
	}
	public int npages()
	{
		String np=co.getText();
		String value=np.substring(np.indexOf("(")+1,np.indexOf("Pages")-1);
		int total_pages=Integer.parseInt(value);
		return total_pages;
	}
	public void pagi()
	/*{
		WebElement xpath=driver.findElement(By.xpath("//ul[@class='pagination']//li//*[normalize-space()='"+s+"']"));
		return xpath;
		// //ul[@class='pagination']//li//*[text()="2"]
		// //ul[@class='pagination']//li["+s+"]
	}*/
	{
		//WebElement xpath=driver.findElement(By.xpath("//ul[@class='pagination']//li//*[normalize-space()="+s+"]"));
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    for(int i=2;i<20;i++)
	    {
	    	WebElement xpath=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='pagination']//li['"+i+"']")));
	    	//Actions as=new Actions(driver);
			// as.moveToElement(xpath).click().build().perform();
	    	xpath.click();
	    }
	}
	
}

