package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_03LoginDataDrivenTest extends BaseClass
{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void datadriven(String mal,String pword,String res)
	{
	logger.info("********TC_03 Starting");
	try
	{
HomePage hp=new HomePage(driver);
hp.clickaccount();
hp.hlogin();
logger.info("clicked on login");
LoginPage lp=new LoginPage(driver);
lp.mail(mal);
logger.info("entered mail");
lp.paswrd(pword);
logger.info("entered password");
lp.lg();
logger.info("clicked on after successful entry login");
//Thread.sleep(5000);
MyAccountPage map=new MyAccountPage(driver);
//boolean bn=map.acpage();
String txt=map.acpage();
logger.info("validating");
//Assert.assertEquals(bn,true);
if(res.equals("valid"))
{
	if(txt.equals("My Account"))
	{
		//hp.clickaccount();
		map.logout();
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
}
if(res.equals("invalid"))
{
	if(txt.equals("My Account"))
	{
		//hp.clickaccount();
		MyAccountPage mapp=new MyAccountPage(driver);
		
		mapp.logout();
		Assert.assertTrue(false);
	}
	else
	{
		Assert.assertTrue(true);
	}
}


	}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("completed successfully");
}
}
