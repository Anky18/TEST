package com.pageObjects;


import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.base.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnerProfilePage extends BasePage {
    public WebDriverWait wait;

    public LearnerProfilePage(WebDriver driver) {
        super(driver);
        // ldriver = rdriver;
        // PageFactory.initElements(ldriver, this);
    }

    // capture profile tab
    @FindBy(xpath = "(//ul)/div[5]")
    public WebElement tabProfile;

    // capture heading of page
   // @FindBy(xpath = "//h1[contains(.,'Profile')]")
    @FindBy(css = "._k8siqs")

    public WebElement headerProfile;

    @FindBy (xpath="//p[.='Name']/following-sibling::p")
    public WebElement name;

    @FindBy (xpath="//p[.='Company']/following-sibling::div/p")
    public WebElement company;

    @FindBy (xpath="//p[.='Email']/following-sibling::p")
    public WebElement email;

    @FindBy (xpath="//p[.='Job title']/following-sibling::p")
    public WebElement job;

    //capture terms of use link
    @FindBy(xpath = "(//p[@class='_14517m5'])[1]")
    public WebElement linkTerms;

    //capture terms of use header
    @FindBy(xpath = "//h1[@class='_16pg94n']")
    public WebElement headerTerms;

    //capture privacy policy link
    @FindBy(xpath = "(//p[@class='_14517m5'])[2]")
    public WebElement linkPrivacy;

    //capture privacy policy header
    @FindBy(xpath = "//h1[@class='_16pg94n']")
    public WebElement headerPrivacy;

    //capture terms and cond. link
    @FindBy(xpath = "(//p[@class='_14517m5'])[3]")
    public WebElement linkTandC;

    //capture terms and cond. header
    @FindBy(xpath = "//h1[@class='_16pg94n']")
    public WebElement headerTandC;

    // capture Logout link
    @FindBy(xpath = "//p[text()='Logout']")
    public WebElement logout;

    @FindBy(xpath="//p[@for='domain']")
    public WebElement domain;

    // ==================Action methods===========================//

    //method to open profile tab
    public void openProfile()  {
        waitClickability(tabProfile);
        try{ tabProfile.click();
        }catch (StaleElementReferenceException e){
           tabProfile.click();}
        }

    // get header of  profile page
    public String  getHeader() {
        waitVisibility(headerProfile);
        try {
            headerProfile.getText();
        }catch (StaleElementReferenceException e){
            headerProfile.getText();}
        System.out.println("header of the page is  " + headerProfile.getText());
        return headerProfile.getText();}

    //get name of the learner
    public boolean getName() {
        waitVisibility(name);
        System.out.println("name of the learner is " + name.getText());
        return name.isDisplayed();}

    //get company name/country
    public boolean getCompany() {
        waitVisibility(company);
        System.out.println("name of the company/country is " + company.getText());
        return company.isDisplayed();}

    //get email id of the learner
    public boolean getEmail() {
        waitVisibility(email);
        System.out.println("email id  of the learner is " + email.getText());
        return email.isDisplayed();}

    //get job tile
    public boolean getJobTitle() {
        waitVisibility(job);
        System.out.println("job title of the learner is " + job.getText());
        return job.isDisplayed();}

    //get terms of use link
    public String  getLinkTerms()  {
        tabProfile.click();
        waitClickability(linkTerms);
        linkTerms.click();
        System.out.println("header of terms of use link is " + headerTerms.getText());
        return headerTerms.getText();}

    //get privacy policy link
    public String  getLinkPrivacy()  {
        tabProfile.click();
        waitClickability(linkPrivacy);
        linkPrivacy.click();
        System.out.println("header of privacy policy link is " + headerPrivacy.getText());
        return headerPrivacy.getText();}

    //get terms and cond. link
    public String  getLinkTandC()  {
        tabProfile.click();
        waitClickability(linkTandC);
        linkTandC.click();
        System.out.println("header of terms and cond. link is " + headerTandC.getText());
        return headerTandC.getText();}

    //logout link
    public String logoutLink() {
        tabProfile.click();
        waitClickability(logout);
        logout.click();
        System.out.println("Logout successful and landed on  page " + domain.getText());
        return domain.getText();}

    //==================================Wait Methods====================================//

    //wait for visibility of webelement
    public void waitVisibility(WebElement element) {
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOf(element));}
    //wait for webelement to be clickable
    public void waitClickability(WebElement webElement) {
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));}


}
