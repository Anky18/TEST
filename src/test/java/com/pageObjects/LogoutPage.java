package com.pageObjects;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class LogoutPage extends BasePage {
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public Actions action;
//	public WebDriver ldriver;

	// Constructor

	public LogoutPage(WebDriver driver) {
		super(driver);
		// ldriver = rdriver;
		// PageFactory.initElements(ldriver, this);
	}

	// Capture profile menu button
	@FindBy(xpath = "//p[text()='Profile']")
	public WebElement profileButton;

	// Capture logout button
	@FindBy(xpath = "//p[text()='Logout']")
	public WebElement logoutButton;

	// Capture domain field
	@FindBy(xpath = "//input[@id='domainName']")
	public WebElement domainName;

	// Capture profile menu button
	@FindBy(xpath = "//p[@for='domain']")
	public WebElement domainLabel;


	// ==================Action methods===========================//


	// click profile  button
	public void profileClick() throws TimeoutException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(profileButton));
		System.out.println("Profile button clicked");
		profileButton.click();
	}

	//click Logout button in Profile Page.
	public void logoutClick() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(logoutButton));
		System.out.println("Logout button clicked");
		logoutButton.click();
	}

	// To Check Successful Logout by Using Visibility function.
	public boolean checkLogoutSuccessful() throws TimeoutException
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(domainName));
		System.out.println("Logged-out successfully");
		String domainPageName = domainLabel.getText();
		System.out.println("After logout, landed on page: " + domainPageName);
		return domainName.isDisplayed();
	}


	public void logout() throws TimeoutException {
		profileClick();
		logoutClick();
		checkLogoutSuccessful();
	}

}
