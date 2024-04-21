package com.testCases.signIn;

import com.base.BaseClass;
import com.pageObjects.EmailPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeoutException;

public class SLM_EmailFooterLinks extends BaseClass {
    static final String EMAIL = "Email";
    static final String TERMS_OF_USE_HEADER = "Terms of use";
    static final String PRIVACY_POLICY_HEADER = "Privacy policy";
    static final String TERMS_AND_CONDITIONS_HEADER = "Terms & Conditions";

    EmailPage ePage;

    @BeforeClass
    public void beforeSorting() throws TimeoutException {
        //enter domain name
        // initializing driver
        // creating object of Email page as "ePage"

        ePage = new EmailPage(driver);
        ePage.setDomainText(domainname);
        ePage.continueClick();
    }

    @Test
    public void tc001_verifyLandedOnEmailPage() throws TimeoutException {
        //Verify the page landed on email page after continue click
        // By using  "Assert Equals "
        Assert.assertEquals(ePage.getEmailLabelName(), EMAIL);
    }

    @Test
    public void tc002_verifyTermsOfUse() throws TimeoutException {

        // to get all foooter links
        //  creating 3 diffrent variables
        //calling their method using ePage obj.

        String termsOfUseLink = ePage.getTermsOfUseLink();
        String termsOfUseHeader = verifyFooterLinks(termsOfUseLink);
        Assert.assertEquals(termsOfUseHeader, TERMS_OF_USE_HEADER);
    }

    @Test
    public void tc003_verifyPrivacyPolicy() throws TimeoutException {
        String privacyPolicyLink = ePage.getPrivacyPolicyLink();
        String privacyPolicyHeader = verifyFooterLinks(privacyPolicyLink);
        Assert.assertEquals(privacyPolicyHeader, PRIVACY_POLICY_HEADER);
    }

    @Test
    public void tc004_verifyTermsAndConditions() throws TimeoutException {
        String termsAndConditionsLink = ePage.getTermsAndConditionsLink();
        String termsAndConditionsHeader = verifyFooterLinks(termsAndConditionsLink);
        Assert.assertEquals(termsAndConditionsHeader, TERMS_AND_CONDITIONS_HEADER);
    }


    // Method used to open the footer link from a New Tab and Verify the link is working
    // Method Name : verifyFooterLinks
    // Return type String as "window handler is used"
    // new Variable  - "parentWindow"
    private String verifyFooterLinks(String footerLink)
    {
        String parentWindow = driver.getWindowHandle();
        System.out.println("The Parent Window ID is:" +parentWindow);
        System.out.println("Before switching, the parent window URL is:" + driver.getCurrentUrl());

        //Open footer link in new tab
        //
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", footerLink);

        // to get "Handles" of all windows & to return set of Handles


        Set<String> allWindows = driver.getWindowHandles();
        System.out.println("Total number of windows are: " + allWindows.size());

        //Switch to child window
        // using For loop
        // using Equal Ignore page.- to compare 2 Stringd and (U/L)cases

        for (String window: allWindows)
        {
            if(!parentWindow.equalsIgnoreCase(window))
                driver.switchTo().window(window);

        }

        EmailPage emailPage = new EmailPage(driver);
        String headerName = emailPage.getLinkPageHeaderName();

        System.out.println("The footer link page header text is: " + headerName);
        driver.close();
        System.out.println("The child window closed");

        //switch back to main/parent window

        driver.switchTo().window(parentWindow);
        String parentURL = driver.getCurrentUrl();
        System.out.println("After switching, the parent window URL is :" +parentURL);

        return headerName;
    }
}
