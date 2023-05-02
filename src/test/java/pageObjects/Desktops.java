package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Desktops extends Basepage
{
	public Desktops(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Desktops']")
	WebElement des;
	@FindBy(xpath="//div[text()='Showing 1 to 10 of 12 (2 Pages)']")
	WebElement pg;
	@FindBy(xpath="//ul[@class='pagination']//li//*[text()='+p+']")
	WebElement nm;
	
	public String dtext()
	{
		String text=des.getText();
		return text;
	}
//	public int pages()
//	{
//		String np=pg.getText();
//		String value=np.substring(np.indexOf("(")+1,np.indexOf("Pages")-1);
//		int total_pages=Integer.parseInt(value);
//		return total_pages;
//		
//	}
	public WebElement pagexpath(int p)
	{
	WebElement path=driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()='"+p+"']"));
	return path;
		
	}
	
	
}
