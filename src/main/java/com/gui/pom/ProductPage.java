package com.gui.pom;

import com.dto.Product;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

/**
 * @author Kyrillos Nageh
 */
public class ProductPage {
    /****************************************************************************
     *  >>	Variables
     *****************************************************************************/
    private static WebDriver driver;

    /****************************************************************************
     *  >>	Constructor
     *****************************************************************************/
    public ProductPage (WebDriver  driver)
    {
        ProductPage.driver =driver;
    }

    /****************************************************************************
     *  >>	Locators
     *****************************************************************************/
    private static final By avialbaleQuantity_Text = By.id("quantity");
    private static final By addToCart_Btn = By.id("add-to-cart-button");
    private static final By cart_Btn = By.id("nav-cart-count-container");
    private static final By productTitle_Text = By.id("productTitle");
    private static final By productPrice_Text = By.xpath("(//*[@class='a-price-whole'])[1]");
    private  static By setroductQuantity(int qty) {
        return By.xpath(("(//*[@id='quantity_"+ qty +"'])"));
    }

    /****************************************************************************
     *  >>	Keywords
     *****************************************************************************/
    @Step("enter Quantity")
    public ProductPage enterQuantity(int quantity) {

            new WebDriverWait(driver, Duration.ofSeconds(45))
                    .until(d -> driver.findElement(avialbaleQuantity_Text)
                            .isDisplayed());
            WebElement element = driver.findElement(avialbaleQuantity_Text);
        Select dropdown = new Select(element);
        dropdown.selectByValue(String.valueOf(quantity));
        new WebDriverWait(driver, Duration.ofSeconds(45))
                .until(d -> driver.findElement(setroductQuantity(quantity))
                        .isDisplayed());
        driver.findElement(setroductQuantity(quantity-1))
                .click();

        return this;
    }
    @Step("Add product to cart")
    public ProductPage clickOnAddToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(45))
                .until(d -> driver.findElement(addToCart_Btn)
                        .isDisplayed());
        driver.findElement(addToCart_Btn).click();
        return this;
    }
    @Step("Navigate to cart page")
    public CartPage clickOnCart() {
        driver.findElement(cart_Btn).click();

        return new CartPage(driver);
    }

    @Step("Get product details")
    public Product getProductDetails() {
        Product product = new Product();
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(d -> driver.findElement(productTitle_Text)
                        .isDisplayed());
        product.setName(driver.findElement(productTitle_Text).getText());
        product.setPrice( Double.parseDouble(
                driver.findElement(productPrice_Text).getText()));
        return product;
    }

    private String getAvialbaleQuantity() {
        return driver.findElement(avialbaleQuantity_Text).getSize().toString();
    }
}
