package com.itstep.aliexpress;

import com.sun.org.apache.xpath.internal.operations.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    private static WebDriver driver;

    private Browser() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/JetBrains/chromedriver.exe");
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
//    @Override
//
//    public ArrayList<String> getTabList(){
//        return new ArrayList<>(this.driver.getWindowHandles());
//    }
//     public void switchToLastTab(){
//        this.driver.switchTo().window(getLastTab());
//         Log.info("Driver switched to " + this.driver.getTitle()+ " tab");
//}
//public String getLastTab(){
//        return getTabList().get(getTabList().size()-1);
//
//}

}
