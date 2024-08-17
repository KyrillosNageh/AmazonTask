package com.gui.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Kyrillos Nageh
 */
public class LoginPage {
    /****************************************************************************
     *  >>	Variables
     *****************************************************************************/
    private static WebDriver driver;

    /****************************************************************************
     *  >>	Constructor
     *****************************************************************************/
    public LoginPage (WebDriver  driver)
    {
        LoginPage.driver =driver;
    }

    /****************************************************************************
     *  >>	Locators
     *****************************************************************************/
    private static final By eamil_TextBox =By.name("email");
    private static final By continue_Btn =By.id("continue");

    /****************************************************************************
     *  >>	Keywords
     *****************************************************************************/
    @Step("Login With valid user")
    public LoginPage enterEmail(String email){

        driver.findElement(eamil_TextBox)
                .sendKeys(email);
        driver.findElement(continue_Btn).click();
        return this;
    }
}
