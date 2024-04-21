package com.testCases.signIn;

import com.base.BaseClass;
import com.pageObjects.DomainHomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SLM_DomainFooterLinks extends BaseClass {
    DomainHomePage domainPage;
    @BeforeClass

    public void domainFooterLinks() throws InterruptedException {
        // Page object instance

        domainPage = new DomainHomePage(driver);

    }
    @Test
    public void tc001_CheckDomainHeader(){

        //verifying the domain text after landing on the homepage
        String verifyDomain = domainPage.verifyDomainName();
        Assert.assertEquals(verifyDomain,"Domain");
    }
    // Methods to verify-click on the links, get header texts, get current urls, navigate back to home page
    @Test
    public void tc002_VerifyTermsOfUse(){

        domainPage.newTabTermsUse();
        String parentURL = driver.getCurrentUrl();
        Assert.assertEquals(parentURL,"https://d37woh9mydma00.cloudfront.net/login");
    }
    @Test
    public void tc003_VerifyPrivacyPolicy(){

        domainPage.newTabPrivacyPolicy();
        String parentURL = driver.getCurrentUrl();
        Assert.assertEquals(parentURL,"https://d37woh9mydma00.cloudfront.net/login");
    }
    @Test
    public void tc004_VerifyTermsAndConditions(){

        domainPage.newTabTermsAndConditions();
        String parentURL = driver.getCurrentUrl();
        Assert.assertEquals(parentURL,"https://d37woh9mydma00.cloudfront.net/login");
    }

}
