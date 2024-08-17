package com.gui.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author Kyrillos Nageh
 */
public class TodayDealsPage {
    /****************************************************************************
     *  >>	Variables
     *****************************************************************************/
    private static WebDriver driver;

    /****************************************************************************
     *  >>	Constructor
     *****************************************************************************/
    public TodayDealsPage (WebDriver  driver)
    {
        TodayDealsPage.driver =driver;
    }

    /****************************************************************************
     *  >>	Locators
     *****************************************************************************/
    private  static By selectCategory(Category category) {
        return By.xpath("(//*[contains(@data-csa-c-element-id,'filter-bubble-deals-collection-') and contains(text(),'"+ category.getCategryName() +"')])");    }

    private  static By selectProduct(int index) {

        return By.xpath("(//*[contains(@class,'a-section octopus-pc-asin-title')])["+ index +"]");
    }

    private  static By selectBrand() {
        return By.xpath("//*[@alt='Andora']");
    }

    /****************************************************************************
     *  >>	Keywords
     *****************************************************************************/
    @Step("click On Today's Deals")
    public TodayDealsPage clickOnCategry(Category category){

        driver.findElement(selectCategory(category))
                .click();

        return new TodayDealsPage(driver);
    }

    @Step("click On brand")
    public TodayDealsPage clickOnBrand(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(selectBrand())
                        .isDisplayed());
        driver.findElement(selectBrand())
                .click();

        return this;
    }

    @Step("click On produc")
    public ProductPage clickOnProduct(int productIndex){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(selectProduct(productIndex))
                                .isDisplayed());
        driver.findElement(selectProduct(productIndex))
                .click();

        return new ProductPage(driver);
    }

    public enum Category {
        COUPONS("Coupons"),
        FASHION("Fashion"),
        FLASH_DEALS("Flash deals"),
        ELECTRONICS("Electronics"),
        HOME_KITCHEN("Home & Kitchen"),
        BEAUTY("Beauty");

        private final String categryName;

        Category(String categryName) {
            this.categryName = categryName;
        }

        public String getCategryName() {
            return categryName;
        }
    }
}
