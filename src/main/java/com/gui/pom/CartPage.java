package com.gui.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author Kyrillos Nageh
 */
public class CartPage {
    /****************************************************************************
     *  >>	Variables
     *****************************************************************************/
    private static WebDriver driver;

    /****************************************************************************
     *  >>	Constructor
     *****************************************************************************/
    public CartPage (WebDriver  driver)
    {
        this.driver =driver;
    }

    /****************************************************************************
     *  >>	Locators
     *****************************************************************************/
    private static final By productTitle_Text =By.xpath("(//*[contains(@class,'a-truncate sc-grid-item-product-title a-size-base-plus')])");
    private static final By productPrice_Text =By.xpath("(//*[contains(@class,'sc-product-price')])");
    private static final By quantity_Text =By.id("sc-subtotal-label-activecart");
    private static final By Subtotal_Text =By.id("sc-subtotal-amount-activecart");

    /****************************************************************************
     *  >>	Keywords
     *****************************************************************************/

    @Step("Get Prduct Title")
    public String getPrductTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(d -> driver.findElement(productTitle_Text)
                        .isDisplayed());
        return driver.findElement(productTitle_Text).getText();
    }

    @Step("Get Product Price")
    public String getProductPrice() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(d -> driver.findElement(productPrice_Text)
                        .isDisplayed());
        return driver.findElement(productPrice_Text).getText();
    }

    @Step("Get Subtotal")
    public String getSubtotal() {   new WebDriverWait(driver, Duration.ofSeconds(30))
            .until(d -> driver.findElement(Subtotal_Text)
                    .isDisplayed());
        return driver.findElement(Subtotal_Text).getText();
    }

    @Step("Get Quantity")
    public String getQuantity() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(d -> driver.findElement(quantity_Text)
                        .isDisplayed());
        return driver.findElement(quantity_Text).getText();
    }
}
