package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select; 

public class BlazedemoPage extends Basepage
{
public	BlazedemoPage(WebDriver driver)
{
	super(driver);
}
@FindBy(xpath="//h1[text()='Welcome to the Simple Travel Agency!']")
WebElement txt;

@FindBy(xpath="//a[text()='destination of the week! The Beach!']")
WebElement link;

//https://blazedemo.com/vacation.html

@FindBy(xpath="//select[@name='fromPort']")
WebElement slct;

@FindBy(xpath="//select[@name='toPort']")
WebElement sl;

@FindBy(xpath="//input[@type='submit']")
WebElement submt;
////th[text()='Price']

@FindBy(xpath="//table//tr")
WebElement siz;

@FindBy(xpath="//table//th")
WebElement si;

@FindBy(xpath="//div[@class='container']//table[@class='table']//tr['+i+']//td[6]")
WebElement sub;

@FindBy(xpath="//h2[text()='Your flight from TLV to SFO has been reserved.']")
WebElement ff;

@FindBy(xpath="//p[text()='Total Cost: ']")
WebElement check;

@FindBy(xpath="//p//em[text()='914.76 ']")
WebElement chec;

@FindBy(xpath="//input[@type='submit']")
WebElement che;

@FindBy(xpath="//h1[text()='Thank you for your purchase today!']")
WebElement checking;

@FindBy(xpath="//tbody//tr[1]//td[1]")
WebElement checked;

public String display()
{
	String value=txt.getText();
	return value;
}

public void clk()
{
	link.click();
}

public List<WebElement> dep()
{
	Select sc=new Select(slct);
List<WebElement> op=sc.getOptions();
return op;
}

public List<WebElement> des()
{
	Select sc=new Select(sl);
	List<WebElement> ops=sc.getOptions();
	return ops;
}

public void sub()
{
	submt.click();
}

public int row()
{
	List<WebElement> row=driver.findElements(By.xpath("//table//tr"));
    int rows=row.size();
    return rows;
}

public int col()
{
	List<WebElement> col=driver.findElements(By.xpath("//table//th"));
    int cols=col.size();
    return cols;
}

public WebElement choose(int i)
{
    WebElement path=driver.findElement(By.xpath("//div[@class='container']//table[@class='table']//tr["+i+"]//td[6]"));
    return path;
}

public String vvv()
{
	String val=ff.getText();
	return val;
}

public String cost()
{
	String sc=check.getText();
	return sc;
}

 public String value()
 {
	 String val=chec.getText();
	 return val;
 }
 
 public void subbm()
 {
	 che.click();
 }
 
 public String check()
 {
	String tt= checking.getText();
	return tt;
 }
 
 public WebElement fina(int i)
 {
	 WebElement we=driver.findElement(By.xpath("//tbody//tr[1]//td["+i+"]"));
	 return we;
 }
}

