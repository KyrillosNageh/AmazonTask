package com.gui.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author Kyrillos Nageh
 */
public class HomePage {
    /****************************************************************************
     *  >>	Variables
     *****************************************************************************/
    private static WebDriver driver;
    private static final String home_Url = "https://www.amazon.eg/-/en/";

    /****************************************************************************
     *  >>	Constructor
     *****************************************************************************/
    public HomePage (WebDriver  driver)
    {
        HomePage.driver =driver;
    }

    /****************************************************************************
     *  >>	Locators
     *****************************************************************************/
    private static final By Account_Lists_Btn = By.xpath("(//*[text()='Account & Lists'])");
    private static final By all_Tap = By.xpath("(//*[text()='All' and @class='hm-icon-label'])");
    private static final By todayDeals_Btn = By.xpath("//div[@id='hmenu-content']//a[contains(text(), 'Today')]");

    /****************************************************************************
     *  >>	Keywords
     *****************************************************************************/
    @Step("navigate To Home Page")
    public HomePage navigateToHome(){
        driver.manage().window().maximize();
        driver.navigate().to(home_Url);
        return this;
    }

    @Step("click On Accounts And Lists")
    public LoginPage clickOnAccountsAndLists(){

        driver.findElement(Account_Lists_Btn)
                .click();
        return new LoginPage(driver);
    }

    @Step("click On All Tap")
    public HomePage clickOnAllTap(){

        driver.findElement(all_Tap)
                .click();
        return this;
    }

    @Step("click On TodayDeals")
    public TodayDealsPage clickOnTodayDeals(){
        new WebDriverWait(driver, Duration.ofSeconds(45))
                .until(d -> driver.findElement(todayDeals_Btn)
                        .isDisplayed());
        driver.findElement(todayDeals_Btn)
                .click();

        return new TodayDealsPage(driver);
    }

}
