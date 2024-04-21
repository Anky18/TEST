package com.pageObjects;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class LoginPage extends BasePage {
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public Actions action;


	// Constructor

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	public int sheetindex =0;

	// Capture domain field
	@FindBy(xpath = "//input[@id='domainName']")
	public WebElement domainName;

	// Capture continue button
	@FindBy(xpath = "//p[text()='Continue']")
	public WebElement continueButton;

	// Capture email field
	@FindBy(xpath = "//input[@id='userName']")
	public WebElement emailField;

	// Capture continue2 button
	@FindBy(xpath = "//p[text()='Continue']")
	public WebElement continueButton2;

	// Capture password field
	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	public WebElement passwordField;

	// Capture login button
	@FindBy(xpath = "//p[text()='Login']")
	public WebElement loginButton;

	// Capture Dashboard button
	@FindBy(xpath = "//p[text()='Dashboard']")
	public WebElement dashButton;

	// Capture Profile button
	@FindBy(xpath = "//p[text()='Profile']")
	public WebElement profileButton;



	// Capture logout button
	@FindBy(xpath = "//p[text()='Logout']")
	public WebElement logoutButton;

	// Capture error on domain page
	@FindBy(xpath = "//div[text()='This domain is not enabled']")
	public WebElement errorDomain;

	// Capture error on email page
	@FindBy(xpath = "//div[text()='Invalid email']")
	public WebElement errorEmail;

	// Capture startover on emailpage
	@FindBy(xpath = "//p[text()='Start over']")
	public WebElement startOver;

	// Capture error on password page
	@FindBy(xpath = "//div[text()='Your username or password is wrong. Try again.']")
	public WebElement errorPwd;

	// Capture startover on password page
	@FindBy(xpath = "//p[text()='Start over']")
	public WebElement startOver2;


	// ==================Action methods===========================//

	// Send text to the domain field
	public void settxtDomain(String domain) {

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(domainName));
		domainName.sendKeys(Keys.COMMAND + "a");
		domainName.sendKeys(Keys.DELETE);
		domainName.sendKeys(domain);
		System.out.println("Domain name entered");
	}
	// click continue button 1
	public void continueClick() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
		System.out.println("Domain page continue clicked ");
	}

	// Send text to the email field
	public void settxtEmail(String email) {

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emailField));
		emailField.clear();
		emailField.sendKeys(email);
		System.out.println("Email entered");
	}

	//click continue button2
	public void continue2Click() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(continueButton2));
		continueButton2.click();
		System.out.println("Email page continue clicked ");
	}

	// Send text to password field
		public void settxtPwd(String pword ) {

			// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(passwordField));
			passwordField.clear();
			passwordField.sendKeys(pword);
			System.out.println("Password entered");
		}

		// login button click
	public void lgnClick() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		System.out.println("Login button clicked ");
	}

	public void startoverClick() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(startOver));
		startOver.click();
		System.out.println("Email page StartOver clicked ");
	}

	public void startover2Click() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(startOver2));
		startOver2.click();
		System.out.println("Password page StartOver clicked ");
	}

	// click profile tab
	public void profileClick() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(profileButton));
		profileButton.click();
		System.out.println("Profile clicked ");
	}

	// click logout button
	public void logoutButtonClick() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
		logoutButton.click();
		System.out.println("Logout clicked ");
	}


/*-----------------------------     Validation methods   ------------------*/
	// To Check Successful Login with valid credentials by Using Visibility function.
	public boolean checkLoginSuccessful() throws TimeoutException
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(dashButton));
		return dashButton.isDisplayed();
	}
	public boolean validDomain() throws TimeoutException
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emailField));
		return emailField.isDisplayed();
	}

	public boolean invalidDomain() throws TimeoutException
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(errorDomain));
		return errorDomain.isDisplayed();
	}

	public boolean validEmail() throws TimeoutException
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		return passwordField.isDisplayed();
	}

	public boolean invalidEmail() throws TimeoutException
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(errorEmail));
		return errorEmail.isDisplayed();
	}

	public boolean inPassword() throws TimeoutException
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(errorPwd));
		return errorPwd.isDisplayed();
	}
	public boolean checkDomainField() throws TimeoutException
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(domainName));
		return domainName.isDisplayed();
	}
	public void sincxLogin(String dName,String eMail1,String passWord ) throws TimeoutException
	{
		settxtDomain(dName);
		continueClick();
		settxtEmail(eMail1);
		continue2Click();
		settxtPwd(passWord);
		lgnClick();
	}

	// Click on submit button
	/*public void clkbtnSubmit() throws TimeoutException {
		//wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.elementToBeClickable(loginsubmitbtn));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600);");
		wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.elementToBeClickable(loginsubmitbtn));
		driver.switchTo().activeElement();
		loginsubmitbtn.click();
	}*/


	}
