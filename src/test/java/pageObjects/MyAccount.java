package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage
{

	public MyAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators 
	@FindBy(xpath="//h2[normalize-space()=\"My Account\"]")
	WebElement msgHeading;
	
	//Action Methods
	public boolean isMyAccountPageExists()   // Verifying displaying or not and returning a boolean result
	{
		try
		{
		return (msgHeading.isDisplayed());
		}
		catch (Exception e)
		{
			return false;
		}
	}
	

}
