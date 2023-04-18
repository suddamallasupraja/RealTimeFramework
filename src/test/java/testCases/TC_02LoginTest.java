package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_02LoginTest extends BaseClass
{
	@Test(groups= {"sanity","regression"})
	public void login()
	{
		logger.info("TC_02 Starting");
		try
		{
HomePage hp=new HomePage(driver);
hp.clickaccount();
hp.hlogin();
logger.info("clicked on login");
LoginPage lp=new LoginPage(driver);
lp.mail(rb.getString("email"));
logger.info("entered mail");
lp.paswrd(rb.getString("password"));
logger.info("entered password");
lp.lg();
logger.info("clicked on login");
Thread.sleep(5000);
MyAccountPage map=new MyAccountPage(driver);
String bn=map.acpage();
Assert.assertEquals(bn, "My Account");

		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("completed successfully");
	}
	
}
