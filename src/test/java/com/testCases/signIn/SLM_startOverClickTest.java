package com.testCases.signIn;

import com.base.BaseClass;
import com.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeoutException;

public class SLM_startOverClickTest extends BaseClass
{
    LoginPage logPage;

    @BeforeMethod
    public void startOverBefore() throws TimeoutException {
        logPage = new LoginPage(driver);
        logPage.settxtDomain(domainname);
        logPage.continueClick();
    }
    @Test
    public void tc001_emailStartOverTest() throws TimeoutException
    {
        logPage.startoverClick();
        Assert.assertTrue(logPage.checkDomainField());
        System.out.println("Landed on Domain Page ");
    }
    @Test
    public void tc002_passwordStartOverTest() throws TimeoutException
    {
        logPage.settxtEmail(username1);
        logPage.continue2Click();
        logPage.startover2Click();
        Assert.assertTrue(logPage.checkDomainField());
        System.out.println("Landed on Domain Page ");
    }

}
