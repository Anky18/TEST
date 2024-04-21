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

public class SLM_documentTest extends BaseClass
{

    ResourcePage resourcePage;

    @BeforeClass
    public void documentBefore() throws TimeoutException {

        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);

        resourcePage = new ResourcePage(driver);
        resourcePage.resourceTabClick();
        resourcePage.resourceNameClick();
    }

    @Test
    public void tc001_verifyBookTitle() throws TimeoutException {

        Assert.assertTrue(resourcePage.checkBookTitle());
        System.out.println("Landed on Document/Book Page " + resourcePage.checkBookTitle());

    }
    @Test
    public void tc002_verifyDownloadButton() throws TimeoutException {

        Assert.assertTrue(resourcePage.checkDownloadButton());
        System.out.println("Download button displayed on Document/Book Page " + resourcePage.checkDownloadButton());

    }

    @Test
    public void tc003_verifyNextButton() throws TimeoutException {

        String before=resourcePage.pdfDocument.getAttribute("data-page-number");
        int before_click=Integer.parseInt(before);
        System.out.println("Page Number before clicking next button: "+before_click);
        resourcePage.nextClick();
        String after1=resourcePage.pdfDocument.getAttribute("data-page-number");
        int after_click=Integer.parseInt(after1);
        System.out.println("Page number after clicking next button: "+after_click);
        Assert.assertEquals(after_click,before_click+1);
        System.out.println("Moved to Next Page");
    }
    @Test
    public void tc004_verifyPreviousButton() throws TimeoutException {
        resourcePage.nextClick();
        String before=resourcePage.pdfDocument.getAttribute("data-page-number");
        int before_click=Integer.parseInt(before);
        System.out.println("Page Number before clicking previous button: "+before_click);
        resourcePage.previousClick();
        String after=resourcePage.pdfDocument.getAttribute("data-page-number");
        int after_click=Integer.parseInt(after);
        System.out.println("Page Number after clicking previous button: "+after_click);
        Assert.assertEquals(after_click,before_click-1);
        System.out.println("Moved to Previous Page");
    }
    @Test
    public void tc005_verifyDownloadButtonClick() throws TimeoutException, InterruptedException {
        resourcePage.downloadButtonClick();
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
    @Test
    public void tc006_verifyMaximizeButton() throws TimeoutException {
        resourcePage.maximizeClick();
        String expected="max-height: unset; min-height: unset;";
        String actual=resourcePage.frameSizeMax.getAttribute("style");
        Assert.assertEquals(actual,expected);
        System.out.println("Resource Frame  Maximized");
    }
    @Test
    public void tc007_verifyMinimizeButton() throws TimeoutException {
        resourcePage.minimizeClick();
        String expected="max-height: 650px; min-height: 650px;";
        String actual=resourcePage.frameSizeMin.getAttribute("style");
        Assert.assertEquals(actual,expected);
        System.out.println("Resource Frame  Minimized");
    }
    @Test
    public void tc008_verifyBackArrow() throws TimeoutException {
        // verify the functionality of back arrow
        resourcePage.backArrowClick();
        Assert.assertTrue(resourcePage.checkResourceTitle());
        System.out.println("Landed on Resource page :  "+resourcePage.checkResourceTitle());

    }





}
