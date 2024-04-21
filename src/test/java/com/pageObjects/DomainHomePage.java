package com.pageObjects;

import com.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Set;

public class DomainHomePage extends BasePage {


    public WebDriverWait wait;

    public DomainHomePage (WebDriver driver)
    {

        super(driver);
    }

    // locator for domain text after landing on the homepage
    @FindBy(xpath = "//p[@class='_1dicgei']")
    public WebElement domainName;

    // Footer link - Terms of Use locator
     @FindBy(xpath="//a[@href='/terms-of-use']")
     public WebElement termsOfUse;

    // get the header after clicking the terms of use link
    @FindBy(xpath = "//h1[@class='_16pg94n']")
    public WebElement headerTermsOfUse;

    // Footer link - Privacy Policy
    @FindBy(xpath = "//a[@href='/privacy-policy']")
    public WebElement privacyPolicy;

    // get the header after clicking the Privacy Policy link
    @FindBy(xpath = "//h1[@class='_16pg94n']")
    public WebElement headerPrivacyPolicy;

    // Footer link - Terms and conditions
    @FindBy(xpath = "//a[@href='/terms-and-conditions']")
    public WebElement termsAndConditions;

    // get the header after clicking the Terms and conditions link
    @FindBy(xpath = "//h1[@class='_16pg94n']")
    public WebElement headerTermsConditions;


    // Method to verify the domain text after landing on the homepage
    public String verifyDomainName(){
        String checkDomainName = domainName.getText();
        System.out.println(checkDomainName);
        return checkDomainName;
    }

    //Method to click on the 3 footer links
    public void clickFooterLinks(WebElement footerLinks){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(footerLinks));
        footerLinks.click();
    }

    //Method to get text after clicking the footer links
    public String getHeaderText(WebElement headerText){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(headerText));
        return headerText.getText();
    }

    // Methods to verify-click on the footer links and open in a child window, get header text, get current url, navigate back to home page

    public void openTabFooterLinks(WebElement footerLinks,WebElement headerText){

        String parentWindow = driver.getWindowHandle();
        System.out.println("The Session ID for Parent Window is:" +parentWindow);
        System.out.println("Before switching, the parent window URL is:" +driver.getCurrentUrl());


        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0].href,'_blank');", footerLinks);

        Set<String> allWindows = driver.getWindowHandles();
        System.out.println(allWindows);

        //Switching to child window by comparing the Session IDS/handles using enhanced FOR loop

        for (String window: allWindows) {

            if(!parentWindow.equalsIgnoreCase(window))

                driver.switchTo().window(window);
        }

        System.out.println("The header of the child window page is :" +getHeaderText(headerText));
        System.out.println("The child window URL is: " +driver.getCurrentUrl());
        driver.close();

        driver.switchTo().window(parentWindow);
        String parentURL = driver.getCurrentUrl();
        System.out.println("After switching, the parent window URL is :" +parentURL);

    }

    public void newTabTermsUse() {
        // parent window(login page) and child window (terms of use page)
        System.out.println(" ********************* OPEN IN A NEW TAB - TERMS OF USE *********************");

        openTabFooterLinks(termsOfUse,headerTermsOfUse);

    }

    public void newTabPrivacyPolicy(){
        System.out.println(" ********************* OPEN IN A NEW TAB - PRIVACY POLICY *********************");

        openTabFooterLinks(privacyPolicy,headerPrivacyPolicy);

    }

    public void newTabTermsAndConditions() {
        System.out.println(" ********************* OPEN IN A NEW TAB - TERMS AND CONDITIONS *********************");

        openTabFooterLinks(termsAndConditions,headerTermsConditions);
    }
}
