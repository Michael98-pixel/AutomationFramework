package MyScenarios;

import com.itstep.aliexpress.Browser;
import com.itstep.aliexpress.ScenarioContext;
import com.itstep.aliexpress.ScreenshotUtils;
import com.itstep.aliexpress.ReflectionUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.sql.Driver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import static com.itstep.aliexpress.ScenarioDataKey.CURRENT_PAGE;

public class MyScenarios {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Given("user navigates to {string} page")
    public void userNavigatesTo(String url) {
        Browser.getBrowser().navigate().to(url);
        logger.info("User navigates to {}", url);
    }


        @Then("user is on the {string} page")
        public void userIsOnTheHomePage(String pageName)
            throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException,
                InterruptedException {
            Thread.sleep(3000);

            AbstractPage page = ReflectionUtils.getPageObject(pageName);
            MatcherAssert.assertThat(Browser.getBrowser().getCurrentUrl(), containsString(page.getPageUrl()));
            ScenarioContext.setContext(CURRENT_PAGE.name(), page);
            ScreenshotUtils.takeScreenshot(pageName);
            logger.info("User is on the {} page", pageName);
        }


    @Then("{string} button is displayed")
    public void JoinButtonIsDisplayed(String button) {

    }

    @When("user clicks on {string} button")
    @When("user click on {string} button")
    public void JoinButtonIsClicked(String buttonName) throws IllegalAccessException {
        WebElement button = ReflectionUtils.getWebElement(buttonName);
        ScreenshotUtils.takeScreenshotOfElement(buttonName, button);
        button.click();
        logger.info("User clicks to {} button", buttonName);
        }
        @And("{string} is displayed")
        public void RegistrationFormIsDisplayed(String registration) throws InterruptedException, IllegalAccessException {
          Thread.sleep(2000);
            WebElement element = ReflectionUtils.getWebElement(registration);
            MatcherAssert.assertThat(element.isDisplayed(), is(true));
            logger.info("Registration form is open {}", registration);
        }

    @And("user fills the {string} and {string} fields")
    public void userTypesNewEmailIntoField(String elementName, String elementName1) throws IllegalAccessException, InterruptedException {
       Thread.sleep(5000);
        WebElement element = ReflectionUtils.getWebElement(elementName);
        element.sendKeys((String) ScenarioContext.getContext("Email address"));

        WebElement element1 = ReflectionUtils.getWebElement(elementName1);
        element1.sendKeys("GoodPass123");
        ScreenshotUtils.takeScreenshot(elementName1);
    }

    @Then("{string} message is displayed")
    public void successRegistration(String welcomeMessage) throws InterruptedException, IllegalAccessException {
        Thread.sleep(3000);
        WebElement element = ReflectionUtils.getWebElement(welcomeMessage);
        MatcherAssert.assertThat(element.isDisplayed(), is(true));
        ScreenshotUtils.takeScreenshotOfElement(welcomeMessage, element);
        logger.info("User is successfully registered {}", welcomeMessage);
    }
}
