package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{

	//Constructor
	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
		
	}

	//Locators Account registration page
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chckdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	
	//actions methods for Account Registration page
	
	public void setFisrtName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tele)
	{
		txtTelephone.sendKeys(tele);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfPassword(String confpwd)
	{
		txtConfPassword.sendKeys(confpwd);
	}
	
	public void setPrivacyPolicy()
	{
		chckdPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try {
		return (msgConfirmation.getText());
		}catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
}
//input[@id='input-firstname']