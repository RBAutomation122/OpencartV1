package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC003_LoginTest extends BaseClass 

{
	@Test(groups={"Sanity","Master"})
	
	public void verify_login() throws Exception
	{
		logger.info("User Login Started");
		
		try
		{
		//home page
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		Thread.sleep(1000);
		//login Page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		//lp.setEmail("test78788@yopmail.com");
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//my account page
		
		MyAccount macc = new MyAccount(driver);
		boolean targetPage =  macc.isMyAccountPageExists();
		Assert.assertTrue(targetPage);
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info("User Login Test Finished");
		
		
	}

}
