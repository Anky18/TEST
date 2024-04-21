package com.pageObjects;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchSortPage extends BasePage {

    public WebDriverWait wait;

    public SearchSortPage(WebDriver driver) {
        super(driver);
        // ldriver = rdriver;
        // PageFactory.initElements(ldriver, this);
    }


    // capture text box of Search option
    @FindBy(xpath = "//input[@placeholder='Search my courses']")
    public WebElement tBoxSearch;

    // capture title of the page
    @FindBy(xpath = "//h1[@class='_1fe5yjd']")
    public WebElement header;

    // capture result of search
    @FindBy(xpath = "//p[@class='_181rl92'] [contains(.,'Manual Testing - BusyQA')]")
    public WebElement searchResult;

    // capture invalid search message
    @FindBy(xpath = "//p[@class='_fal0ns'] [.='No items to show']")
    public WebElement searchMessage;

    // capture back button
    @FindBy(xpath = "//p[@class='_1tog7ov']")
    public WebElement backBtn;

    // capture title of dashboard
    @FindBy(css = "._k8siqs")
    public WebElement titleDashboard;

    // capture sort/filter image
    @FindBy(css = "img[alt='Filter image alt']")
    public WebElement filterSort;

    // capture title of sort/filter modal
    @FindBy(css = "._1pe9lxn")
    public WebElement modalHeader;

    // capture modal close button
    @FindBy(xpath = "//img[@alt='Dialog close alt']")
    public WebElement modalClose;

    // capture textbox of sort option
    @FindBy(xpath = "//input[@placeholder='Sort by']")
    public WebElement tBoxSort;

    // capture clear(x) button
    @FindBy(xpath = "//button[@title='Clear']")
    public WebElement clearBtn;

    // capture Reset button
    @FindBy(xpath = "//p[@class='_cbdrkue']")
    public WebElement resetBtn;

    // capture drop down button
    @FindBy(xpath = "//div[@class='MuiAutocomplete-endAdornment']/button[2]")
    public WebElement dropDwnArrow;

    //=================Action Methods====================//


    // check search functionality
    public boolean checkSearch()  {
            waitVisibility(tBoxSearch);
            tBoxSearch.sendKeys("manual testing");
            try {
                waitVisibility(searchResult);
                searchResult.getText();
            } catch (Exception e) {
                searchResult.getText();
            System.out.println("Result of search is " + searchResult.getText());}
            return searchResult.isDisplayed();}

    // check invalid search
        public String checkInvalidSearch() {
        driver.navigate().refresh();
        waitVisibility(tBoxSearch);
        tBoxSearch.sendKeys("cyber");
        waitVisibility(searchMessage);
        searchMessage.getText();
        System.out.println("Result of invalid search  is " + searchMessage.getText());
        return searchMessage.getText();
    }

    // check sort/filter option
    public String checkSortOption() {
        waitClickability(filterSort);
        filterSort.click();
        modalHeader.getText();
        System.out.println("title of the modal is " + modalHeader.getText());
        modalClose.click();
        System.out.println("on closing redirected to dashboard ");
        System.out.println("title of the dashboard page is " + titleDashboard.getText());
        return titleDashboard.getText();
    }

    // check reset sort option by clicking on clear(x) button
    public String checkClearSort() {
        waitClickability(filterSort);
        filterSort.click();
        tBoxSort.sendKeys("A-Z");
        clearBtn.click();
        System.out.println("clicked on the clear(x) button");
        System.out.println("reset to default: "+ tBoxSort.getAttribute("placeholder"));
        return tBoxSort.getAttribute("placeholder");
    }

    // check reset sort option by clicking on RESET button
    public String checkReset() throws InterruptedException {
        waitVisibility(tBoxSort);
        tBoxSort.sendKeys("A-Z");
        Thread.sleep(2000);
        dropDwnArrow.click();
        resetBtn.click();
        System.out.println("clicked on the RESET button");
        System.out.println("reset to default: "+ tBoxSort.getAttribute("placeholder"));
        modalClose.click();
        return tBoxSort.getAttribute("placeholder");
    }

    //==================================Wait Methods====================================//

    public void waitVisibility(WebElement element)
    {
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitClickability(WebElement webElement)
    {
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

}
