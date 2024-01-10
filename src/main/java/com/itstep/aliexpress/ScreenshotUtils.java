package com.itstep.aliexpress;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import io.cucumber.java.Scenario;

    public class ScreenshotUtils {

        private static Scenario scenario;

        public static void setScenario(Scenario scenario) {
            ScreenshotUtils.scenario = scenario;
        }

        public static void takeScreenshot(String name) {
            byte[] image = ((TakesScreenshot) Browser.getBrowser()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", name);
        }

        public static void takeScreenshotOfElement(String name, WebElement element) {
            executeJS("arguments[0].style.border='5px solid red'", element);
            takeScreenshot(name);
            executeJS("arguments[0].removeAttribute('style','')", element);
        }

        private static void executeJS(String script, WebElement element) {
            ((JavascriptExecutor) Browser.getBrowser()).executeScript(script, element);
        }

    }