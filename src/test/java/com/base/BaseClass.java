package com.base;

import com.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class BaseClass 
{
	static ReadConfig readconfig = new ReadConfig(); // Creating object
	// Integrating data from ReadConfig
	public static String baseURL = readconfig.getApplicationURL();
	public String username1 = readconfig.getUsername1();
	public String password = readconfig.getPassword();
	public String browser = readconfig.getbrowser();
	public String domainname= readconfig.getdomainname();
	public ChromeOptions handlingSSL = new ChromeOptions();
	public static WebDriver driver;
	public static Logger logger;
	public static String screenshotPath;
	public static String screenshotName;
	
	@BeforeClass
	public void setup() throws Exception {
		if(browser.equalsIgnoreCase("chrome")) {
			 //Create instance of ChromeOptions Class
			
			//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
			handlingSSL.setAcceptInsecureCerts(true);
			//handlingSSL.addArguments("--headless");
			//Creating instance of Chrome driver by passing reference of ChromeOptions object
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver");
			driver = new ChromeDriver(handlingSSL);
		// Initialization // Logger initiated within the setup method
		logger=Logger.getLogger("Freshii");// Project Name
		PropertyConfigurator.configure("log4j.properties"); // Added Logger
		logger.setLevel(Level.DEBUG); // to get the debug log
		logger.debug("Debug logging has started ");
		
		
		}
		driver.get(baseURL);
       driver.manage().window().maximize();	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public static String randomestring() 
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(5); // generate random char string with the specified values passed 
		return (generatedString1);										 
	}

	public static String randomeNum() 
	{
		String generatedString2 = RandomStringUtils.randomNumeric(4);// generate random digits with the specified values passed
		return (generatedString2);
	}
	
	public static String randomemail() 
	{
		String generatedString5 = RandomStringUtils.randomAlphanumeric(5); // generate random char/numeric string with the specified values passed 
		String userEmail = generatedString5 + "@gmail.com";
		return (userEmail);										 
	}

	
}