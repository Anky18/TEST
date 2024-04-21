package com.pageObjects;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class EmailPage extends BasePage
{
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;
    //default Constructor

    public EmailPage(WebDriver driver)
    {
        super(driver);
    }

     //xpath of domain
    @FindBy(xpath = "//input[@id='domainName']")
    public WebElement domainInput;

    //Xpath for Domain page continue button
    @FindBy(xpath = "//p[text()='Continue']")
    public WebElement continueButton;

    // locator for email header after landing on the email page
    @FindBy(xpath = "//p[@for='email']")
    public WebElement emailName;

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

    public void continueClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        System.out.println("Making  a Click on Continue button ");
        continueButton.click();
    }

    // Method to verify the "Email Header" text after landing on the email page
    // Method name - "getEmailLabelName" - > (GUI element - "Lable")
    // Return Type - "String"
    // Printing - The email name  by Concatination
    public String getEmailLabelName(){
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(emailName));
        String emailLabelName = emailName.getText();
        System.out.println("The email page label name: " + emailLabelName);
        return emailLabelName;
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
        System.out.println("The Terms Of Use Href is: " + termsOfUseHref);
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
        System.out.println("The Privacy Policy Href is: " + privacyPolicyHref);
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
        System.out.println("The Terms and Conditions Href is: " + termsAndConditionsHref);
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
