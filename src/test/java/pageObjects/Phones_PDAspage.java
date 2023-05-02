package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Phones_PDAspage extends Basepage
{
	public Phones_PDAspage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//select[@id='input-sort']")
	WebElement st;
	@FindBy(xpath="//img[@title='Palm Treo Pro']")
	WebElement prs;
	
	
	@SuppressWarnings("unused")
	public void selct(String exp_txt) throws InterruptedException
	{
		st.click();
		 Select op=new Select(st);
		List<WebElement> ops= op.getOptions();
		String txt = "";
		for(int i=0;i<ops.size();i++)
		{
			WebElement we=ops.get(i);
			txt=we.getText();
			if(txt.equals(exp_txt))
			{
				ops.get(i).click();
				Thread.sleep(4000);
				break;
			}
			//txt=ops.get(i).getText();
			
			 
		}
		
		
	}
	public void na()
	{
		prs.click();
	}
	

}
