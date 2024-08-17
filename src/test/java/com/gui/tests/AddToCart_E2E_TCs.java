package com.gui.tests;

import com.dto.Product;
import com.gui.pom.CartPage;
import com.gui.pom.HomePage;
import com.gui.pom.ProductPage;
import com.gui.pom.TodayDealsPage;
import com.screenshot.AllureManager;
import com.screenshot.AllureTestListener;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNG;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

/**
 * @author Kyrillos Nageh
 */
@Feature("Tagaddod Task")
public class AddToCart_E2E_TCs {

    WebDriver driver ;
    SoftAssert softAssert = new SoftAssert();

    @Test(description = "Verify user can’t login with valid but not registered email")
    @Description("login with valid but not registered email")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add to cart E2E Tests")
    public void verifyAddToCart(){
       Product Product = new HomePage(driver).navigateToHome()
                .clickOnAllTap()
                .clickOnTodayDeals()
                .clickOnCategry(TodayDealsPage.Category.FLASH_DEALS)
                .clickOnBrand()
                .clickOnProduct(2)
                .enterQuantity(2)
                .getProductDetails();

        new ProductPage(driver).clickOnAddToCart()
                .clickOnCart();

        String actualProductTitle = new CartPage(driver).getPrductTitle();
        String actualProductPrice = new CartPage(driver).getProductPrice();
        String actualQuantity = new CartPage(driver).getQuantity();
        String actualSubtotal = new CartPage(driver).getSubtotal();

        softAssert.assertEquals(Product.getName(),actualProductTitle);
        softAssert.assertTrue(actualProductPrice.contains(String.valueOf(Product.getPrice())));
        softAssert.assertTrue(actualQuantity.contains("2"));
        softAssert.assertTrue(actualSubtotal.contains(String.valueOf(2 *Product.getPrice())));
        softAssert.assertAll();


    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        AllureManager.setDriver(driver);
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
