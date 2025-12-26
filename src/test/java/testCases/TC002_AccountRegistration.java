package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC002_AccountRegistration extends BaseClass
{

	
	@Test(groups={"Regression","Master"})
	public void verify_Account_Registration() throws Exception
	{
		
		
		logger.info("***Starting TC002_AccountRegistration Execution***** ");
		
		try {
		//Calling home page from page Objects package
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		logger.info("**Clicked On MyAccount Link*** ");
		hp.clickRegister();
		logger.info("**Clicked On Register Link*** ");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("**Providing customer registeration Details*** ");
		regpage.setFisrtName(randomString().toUpperCase()); //toUpperCase method is for make string value in Uppercase
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomAlphaNumeric()+"@yopmail.com");
		regpage.setTelephone(randomNumber());
		
		String Password = randomAlphaNumeric();
		regpage.setPassword(Password);
		Thread.sleep(1000);
		regpage.setConfPassword(Password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		Thread.sleep(2000);
		
		logger.info("**Validating success message***");
		String conmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(conmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs"); // To log debug logs if test failed...
			Assert.fail();
		}
		logger.info("** Finished Test Case **"); 
		
		
	}
	
	//Methods for random data generation
	/*
	public String randomString()
	{
		//generate string type data
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	
	public String randomNumber()
	{
		//generate string type data
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomAlphaNumeric()
	{
		//generate string type data
		String generatedAlphaNumber = RandomStringUtils.randomAlphanumeric(6);
		return generatedAlphaNumber;
	}
	*/
	
}
