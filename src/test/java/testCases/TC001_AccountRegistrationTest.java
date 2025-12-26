package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest 
{
	public WebDriver driver;
	
	//Action Methods of Test Case
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); // manage the cookies
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Wait method
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit(); // close the browser
	}
	
	@Test
	public void verify_Account_Registration() throws Exception
	{
		//Calling home page from page Objects package
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		hp.clickRegister();
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFisrtName("John");
		regpage.setLastName("David");
		regpage.setEmail("Test57878@yopmail.com");
		regpage.setTelephone("5656565656");
		
		regpage.setPassword("xyz12356");
		Thread.sleep(1000);
		regpage.setConfPassword("xyz12356");
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		Thread.sleep(2000);
		String conmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(conmsg, "Your Account Has Been Created!");
	}
	
	
	
	
	
	

}
