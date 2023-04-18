package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_01AccountRegistration extends BaseClass
{
@Test(groups= {"sanity"})
public void register()
{
	logger.info("***  Starting TC_O1ARTest ****");
	try
	{
	HomePage hm=new HomePage(driver);
	hm.clickaccount();
	logger.info("clicked on my account link");
	hm.clickregister();
	logger.info("clicked on register");
	RegistrationPage rp=new RegistrationPage(driver);
	logger.info("Providing customer data");
	rp.fname("iubjjkb");
	rp.lname("cdfrsgf");
	rp.mil(randomstring()+"@gmail.com");
	rp.pas("cycycyc");
	rp.ag();
    rp.cont();
    logger.info("validating expecting message");
	Assert.assertEquals(rp.succ(),"Your Account Has Been Created!");
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("***   Finished ACTest  ****");
	
}
}
