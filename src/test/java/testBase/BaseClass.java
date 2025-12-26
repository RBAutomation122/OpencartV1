package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //LogManager class package 
import org.apache.logging.log4j.Logger;  //Logger Class package
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties p; //Properties file related JAVA class - predefined

	// Action Methods of Test Case
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException 
	{
		//Loading config.properties file and for that below piece of code need to add
		// JAVA predefined class add it and properties file location need to pass.
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
				
		
		
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver();break;
		case "edge" : driver = new EdgeDriver();break;
		case "firefox" : driver = new FirefoxDriver();break;
		default : System.out.println("Invalid Browser name..."); return;
		
		}
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); // manage the cookies
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Wait method

		driver.get(p.getProperty("appURL"));
		//("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();

	}

	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit(); // close the browser
	}

	// Methods for random data generation

	public String randomString() {
		// generate string type data
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {
		// generate string type data
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String randomAlphaNumeric() {
		// generate string type data
		String generatedAlphaNumber = RandomStringUtils.randomAlphanumeric(6);
		return generatedAlphaNumber;
	}

}
