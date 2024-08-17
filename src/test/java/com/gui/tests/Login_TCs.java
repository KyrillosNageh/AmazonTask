package com.gui.tests;

import com.gui.pom.HomePage;
import com.screenshot.AllureManager;
import com.screenshot.AllureTestListener;
import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.*;

import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

/**
 * @author Kyrillos Nageh
 */

@Feature("Tagaddod Task")
public class Login_TCs {
    protected WebDriver driver ;

    @Test(description = "Verify user can’t login with valid but not registered email")
    @Description("login with valid but not registered email")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Functionality")
    public void verifyLoginWithInvalidEmail()  {

        new HomePage(driver).navigateToHome()
                        .clickOnAccountsAndLists()
                                .enterEmail("kyrillos.nageh@test.co");

        //Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Looks like you're new to Amazon')]")).isDisplayed());
        Assert.fail("Intentional Failure to demonstrate screenshot capture");

    }
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        AllureManager.setDriver(driver);
    }

    @BeforeMethod
    public void beforeMethod()
    {

    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        if (driver != null) {
        driver.quit();
        }
    }

}
