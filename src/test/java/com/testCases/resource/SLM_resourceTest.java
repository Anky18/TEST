package com.testCases.resource;

import com.base.BaseClass;
import com.pageObjects.LoginPage;
import com.pageObjects.ResourcePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.concurrent.TimeoutException;

public class SLM_resourceTest extends BaseClass
{

    ResourcePage resourcePage;

    @BeforeClass
    public void resourceBefore() throws TimeoutException {

        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);

        resourcePage = new ResourcePage(driver);
        resourcePage.courseNameClick();     // course on dash board clicked
        resourcePage.rTabClick();          // Resource tab inside course page clicked
        resourcePage.favoriteIconSetup();  // clicked on the favorite icon inside course page.

        resourcePage.resourceTabClick();
    }
    @Test
    public void tc001_verifyResourcePageTitle() throws TimeoutException {

        Assert.assertTrue(resourcePage.checkResourceTitle());
        System.out.println("Landed on resource Page " + resourcePage.checkResourceTitle());

    }
    @Test
    public void tc002_verifyResourceList() throws TimeoutException {

        resourcePage.checkResourceNameList();
    }

    @Test
    public void tc003_verifyPrintIcon() throws TimeoutException
    {
        resourcePage.printIconClick();
        Assert.assertTrue(resourcePage.checkListTitle());

    }
    @Test
    public void tc004_verifyValidSearch() throws TimeoutException
    {
        resourcePage.checkResourceNameList();
        int noOfResourcesBefore=resourcePage.resourceName.size();
        System.out.println("Number of resources displayed before entering valid input: "+noOfResourcesBefore );
        resourcePage.setTxtSearch("First Time Manager Toolkit");
        String expected="First Time Manager Toolkit";
        String actual=resourcePage.resourceName.get(0).getText();
        int noOfResourcesAfter=resourcePage.resourceName.size();
        System.out.println("Number of resources displayed after entering valid input: "+noOfResourcesAfter );
        Assert.assertEquals(actual,expected);
        resourcePage.checkResourceNameList();
    }

    @Test
    public void tc005_verifyInvalidSearch() throws TimeoutException
    {
        resourcePage.checkResourceNameList();
        int noOfResourcesBefore=resourcePage.resourceName.size();
        System.out.println("Number of resources displayed before entering valid input: "+noOfResourcesBefore );
        resourcePage.setTxtSearch("Abc");
        int noOfResourcesAfter=resourcePage.resourceName.size();
        System.out.println("Number of resources displayed after entering valid input: "+noOfResourcesAfter );
        Assert.assertEquals(noOfResourcesAfter,0);
        resourcePage.checkResourceNameList();
    }


    @Test
    public void tc006_verifyHeartIconClick() throws TimeoutException{

        int beforeClick= resourcePage.resourceName.size();
        resourcePage.heartIconClick();
        resourcePage.checkResourceNameList();
        int afterClick= resourcePage.resourceName.size();
        Assert.assertEquals(afterClick,beforeClick-1);
        System.out.println("After click: "+afterClick+"  before click: "+beforeClick);
        resourcePage.checkResourceNameList();

    }
   @Test
    public void tc007_verifyDownloadIconClick() throws TimeoutException, InterruptedException {
       resourcePage.downloadIconClick();
       Thread.sleep(3000);

       //    verify file downloaded
       File filelocation = new File("/Users/ankitabharadhwaj/Downloads");
       File[] totalFiles = filelocation.listFiles();
       String expected = "1695741035531_";
       for (File file : totalFiles) {

           if (file.getName().contains(expected)) {
               System.out.println("file downloaded: " + file.getName());
               Assert.assertTrue(true);
               String fileName = file.getName();
               file.delete();
               System.out.println("file deleted:  " + fileName);
               break;
           }
       }

   }

}
