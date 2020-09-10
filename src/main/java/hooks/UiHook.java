package hooks;

import com.itstep.aliexpress.Browser;
import com.itstep.aliexpress.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.itstep.aliexpress.ScreenshotUtils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class UiHook {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before
    public void createNewEmail() {
        String email = "DurneaMihail" + System.currentTimeMillis() + "@getnada.com";
        ScenarioContext.setContext("Email address", email);
    }

    @Before
    public void setupReport(Scenario scenario) {
        System.setProperty("cucumber.reporting.config.file", "src/test/resources/cucumber-reporting.properties");
        ScreenshotUtils.setScenario(scenario);
    }
    @Before
    public void setupWebDriver() {
        logger.debug("Chrome driver Set UP");
        WebDriver driver = Browser.getBrowser();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.info("Window is maximized");
    }

    @After(order = 100)
    public void onFail(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.takeScreenshot("onFail");
        }
    }

    @After(order = 1)
    public void tearDown() {
        Browser.quitDriver();
        ScenarioContext.clearContext();
    }

//    public ArrayList<String> getTabList(){
//        return new ArrayList<>(this.driver.getWindowHandles());
//    }
//
//     public void switchToLastTab(){
//        this.driver.switchTo().window(getLastTab());
//         Log.info("Driver switched to " + this.driver.getTitle()+ " tab");
//}
//
//public String getLastTab(){
//        return getTabList().get(getTabList().size()-1);

}
