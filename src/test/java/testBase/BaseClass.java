package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class BaseClass 
{
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
@BeforeClass(groups= {"sanity","regression","master"})
@Parameters({"browser"})
public void setup(String br)
{
	rb=ResourceBundle.getBundle("config");
	logger=LogManager.getLogger(this.getClass());
	if(br.equals("chrome"))
	{
	driver=new ChromeDriver();
	}
	else if(br.equals("edge"))
	{
		driver=new EdgeDriver();
	}
	else
	{
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().deleteAllCookies();
	driver.get(rb.getString("appURL"));
}
@AfterClass(groups= {"sanity","regression","master"})
public void teardown()
{
	driver.quit();
}
public String randomstring()
{
	String nm=RandomStringUtils.randomAlphabetic(3);
	return nm;
}

public String randomnum()
{
	String nn=RandomStringUtils.randomNumeric(3);
	return nn;
}

public String randomstrinum()
{
	String ns=RandomStringUtils.randomAlphabetic(3);
	String ns1=RandomStringUtils.randomNumeric(2);
	return (ns+ns1);
}

public String captureScreen(String tname) 
{
	String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot takesScreenshot=(TakesScreenshot ) driver;
	File source=takesScreenshot .getScreenshotAs(OutputType.FILE);
	String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
	try
	{
		FileUtils.copyFile(source, new File(destination));
	}
	catch(Exception e)
	{
		e.getMessage();
	}
	return destination;
}


}
