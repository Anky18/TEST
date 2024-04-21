package com.testCases.signIn;

import com.pageObjects.LoginPage;
import com.pageObjects.LogoutPage;
import com.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

//import org.apache.log4j.Logger;

import org.testng.asserts.SoftAssert;

import com.base.BaseClass;

//import static com.base.BaseClass.driver;

public class SLM_dataDriven extends BaseClass {

    Object[][] data;
    LoginPage logPage = new LoginPage(driver);
    int sheetindex =logPage.sheetindex;



    @DataProvider(name="login-Data")
    public Object[][] loginDataprovider() throws IOException , FileNotFoundException
    {
        data= XLUtils.getExceldata(sheetindex);
        return data;
    }

    @Test( dataProvider = "login-Data")
    public void sincxLogin(String dName,String eMil,String pWord,String tType) throws TimeoutException {
        LoginPage logPage=new LoginPage(driver);

        if (Objects.equals(tType, "vdomain"))
        {
            logPage.settxtDomain(dName);
            logPage.continueClick();
            logger.info("valid domain");
            System.out.println("valid domain");
            SoftAssert softAssert=new SoftAssert();
            softAssert.assertTrue(logPage.validDomain());
            logPage.startoverClick();
            softAssert.assertAll();

        }
        else if (Objects.equals(tType, "indomain"))
        {
            logPage.settxtDomain(dName);
            logPage.continueClick();
            logger.info("invalid domain");
            System.out.println("invalid domain");
            SoftAssert softAssert=new SoftAssert();
            softAssert.assertTrue(logPage.invalidDomain());
          //  Assert.assertTrue(logPage.invalidDomain());
            softAssert.assertAll();
        }
        else if (Objects.equals(tType, "vemail"))
        {
            logPage.settxtDomain(dName);
            logPage.continueClick();
            logger.info("valid email");
            System.out.println("valid email");
            logPage.settxtEmail(eMil);
            logPage.continue2Click();
            SoftAssert softAssert=new SoftAssert();
            softAssert.assertTrue(logPage.validEmail());
            logPage.startover2Click();
            softAssert.assertAll();

        }
        else if (Objects.equals(tType, "inemail"))
        {
            logPage.settxtDomain(dName);
            logPage.continueClick();
            logger.info("invalid email");
            System.out.println("invalid email");
            logPage.settxtEmail(eMil);
            logPage.continue2Click();
            SoftAssert softAssert=new SoftAssert();
            softAssert.assertTrue(logPage.invalidEmail());
            logPage.startoverClick();
            softAssert.assertAll();

        }
        else if (Objects.equals(tType, "inpwd"))
        {
            logPage.settxtDomain(dName);
            logPage.continueClick();
            System.out.println("invalid password");
            logger.info("invalid password");
            logPage.settxtEmail(eMil);
            logPage.continue2Click();
            logPage.settxtPwd(pWord);
            logPage.lgnClick();
            SoftAssert softAssert=new SoftAssert();
            softAssert.assertTrue(logPage.inPassword());
            logPage.startover2Click();
            softAssert.assertAll();

        }
        else if (Objects.equals(tType, "allvalid"))
        {
            logPage.settxtDomain(dName);
            logPage.continueClick();
            logPage.settxtEmail(eMil);
            logPage.continue2Click();
            logPage.settxtPwd(pWord);
            logPage.lgnClick();
            logger.info("all valid ");
            System.out.println("All valid");

            //Assertion to verify that the user landed on  Dashboard page with valid login credentials


            SoftAssert softAssert=new SoftAssert();
            softAssert.assertTrue(logPage.checkLoginSuccessful());
            LogoutPage logoutPage=new LogoutPage(driver);
            logoutPage.profileClick();
            logoutPage.logoutClick();
            System.out.println("logged out");
            softAssert.assertAll();
        }


    }

}
