package com.pageObjects;

import com.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeoutException;

public class EmailPasswordPage extends BasePage
{
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;
    //default Constructor

    public EmailPasswordPage(WebDriver driver)
    {
        super(driver);
    }

     //xpath of domain
    @FindBy(xpath = "//input[@id='domainName']")
    public WebElement domainInput;

    //Xpath for Domain page continue button
    @FindBy(xpath = "//p[text()='Continue']")
    public WebElement domainContinueButton;

    //After Click on ContinueButton.
    //Xpath for Domain page continue button
    @FindBy(xpath = "//input[@id='userName']")
    public WebElement email;

    //Xpath for Domain page continue button
    @FindBy(xpath = "//p[text()='Continue']")
    public WebElement emailContinueButton;

    // locator for email header after landing on the email page
    @FindBy(xpath = "//p[@for='password']")
    public WebElement passwordName;

    // Footer link - Terms of Use locator
    @FindBy(xpath="//a[@href='/terms-of-use']")
    public WebElement termsOfUse;

    // Footer link - Privacy Policy
    @FindBy(xpath = "//a[@href='/privacy-policy']")
    public WebElement privacyPolicy;

    // Footer link - Terms and conditions
    @FindBy(xpath = "//a[@href='/terms-and-conditions']")
    public WebElement termsAndConditions;

    // get the header after clicking any footer link - Generic
    @FindBy(xpath = "//h1")
    public WebElement header;


    public void setDomainText(String domain) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(domainInput));
        domainInput.sendKeys(domain);
    }

    //Click on continue button from domain page
    //method name - "ContinueClick"
    //return type - "Void"
    public void domainContinueClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(domainContinueButton));
        System.out.println("Making  a Click on Continue button from domain page");
        domainContinueButton.click();
    }

    //Fill email field
    public void setEmailText(String emailText) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(email));
        System.out.println("Email text entered");
        email.sendKeys(emailText);
    }

    //Click on continue button from email page to go to (email&password) page
    //method name - "ContinueClick"
    //return type - "Void"
    public void emailContinueClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(emailContinueButton));
        System.out.println("Making  a Click on Continue button from email page");
        emailContinueButton.click();
    }

    // Method to verify the "Password label" text after landing on the (email&password) page
    // Method name - "getPasswordLabelName" - > (GUI element - "Lable")
    // Return Type - "String"
    // Printing - The password label text
    public String getPasswordLabelName(){
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(passwordName));
        String passwordLabelName = passwordName.getText();
        System.out.println("The text inside Password label : " + passwordLabelName);
        return passwordLabelName;
    }

    // Method -get- Name - TermsOfUseLink
    // Return type - String
    // Creating String variable as "termsOfUseHref"
    // href - is an atrribute of that particular link
    // Method to get terms Of Use Href
    public String getTermsOfUseLink(){
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(termsOfUse));
        String termsOfUseHref = termsOfUse.getAttribute("href");
        System.out.println(" Displaying Terms Of Use Href link as : " + termsOfUseHref);
        return termsOfUseHref;
    }
    // Method -get- Name - PrivacyPolicyLink
    // Return type - String
    // Creating String variable as "privacyPolicyHref"
    // href - is an atrribute of that PrivacyPolicyLink link

    // Method to get terms Of Use Href
    public String getPrivacyPolicyLink(){
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(privacyPolicy));
        String privacyPolicyHref = privacyPolicy.getAttribute("href");
        System.out.println("Displaying Privacy and Policy link as : " + privacyPolicyHref);
        return privacyPolicyHref;
    }


    // Method -get- Name - TermsAndConditionsLink
    // Return type - String
    // Creating String variable as "TermsAndConditionsHref"
    // href - is an atrribute of that "TermsAndConditions" link

    // Method to get terms and Conditions Href
    public String getTermsAndConditionsLink(){
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(termsAndConditions));
        String termsAndConditionsHref = termsAndConditions.getAttribute("href");
        System.out.println(" Displaying Terms and Conditions link as : " + termsAndConditionsHref);
        return termsAndConditionsHref;
    }

    // Method to verify the link page header text after landing on the footer link page
    //Method -get- Name - LinkPageHeaderName
    // Return type - String
    // Creating String variable as "headerLabelName"
    // headerLabelName - is an text of that "headerLabelName" link
    public String getLinkPageHeaderName(){
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(header));
        String headerLabelName = header.getText();
        System.out.println(" Displaying the  Header name of the Link-: " + headerLabelName);
        return headerLabelName;
    }



}
