package com.screenshot;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Kyrillos Nageh
 */

public class AllureTestListener implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        captureScreenshot(result);
    }

    @Attachment(value = "Screenshot on failure or skip", type = "image/png")
    private byte[] captureScreenshot(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = null;

        try {
            // Use reflection to access the 'driver' field
            Field field = testClass.getClass().getDeclaredField("driver");
            field.setAccessible(true);
            driver = (WebDriver) field.get(testClass);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            System.err.println("Failed to get WebDriver instance from test class.");
            return null;
        }

        if (driver != null) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Path destination = Paths.get(System.getProperty("user.dir"), "screenshots", result.getName() + ".png");

                // Ensure the directory exists
                if (!Files.exists(destination.getParent())) {
                    Files.createDirectories(destination.getParent());
                }

                Files.copy(screenshot.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

                // Return the screenshot file as a byte array to attach to the Allure report
                return Files.readAllBytes(screenshot.toPath());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void onStart(ITestContext context) {
        // Add initialization code here if necessary
    }

    @Override
    public void onFinish(ITestContext context) {
        // Add cleanup code here if necessary
    }
}
