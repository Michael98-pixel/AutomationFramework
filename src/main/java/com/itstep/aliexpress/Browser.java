package com.itstep.aliexpress;

import com.sun.org.apache.xpath.internal.operations.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    private static WebDriver driver;

    private Browser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static WebDriver getBrowser() {
        if (driver == null) {
            new Browser();
        }
        return driver;
    }
    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}