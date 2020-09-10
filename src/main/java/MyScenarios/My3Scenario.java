package MyScenarios;

import com.itstep.aliexpress.Browser;
import com.itstep.aliexpress.ReflectionUtils;
import com.itstep.aliexpress.ScreenshotUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.is;

public class My3Scenario {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Given("user navigates to {string}   page")
    public void userNavigatesToTheSite(String url) throws IllegalAccessException, InterruptedException {
        Browser.getBrowser().navigate().to(url);
        logger.info("User navigates to {}", url);
        Thread.sleep(3000);

    }

    @And("{string}   button is displayed")
    public void buttonIsDisplayed(String signIn) throws IllegalAccessException {
        WebElement element = ReflectionUtils.getWebElement(signIn);
        ScreenshotUtils.takeScreenshotOfElement(signIn, element);
        MatcherAssert.assertThat(element.isDisplayed(), is(true));
        logger.info("Button  {} is displayed", signIn);
    }

    @When("user clicks on   {string} button")
    public void SignInButtonIsClicked(String signIn) throws IllegalAccessException {
        WebElement button = ReflectionUtils.getWebElement(signIn);
        ScreenshotUtils.takeScreenshotOfElement(signIn, button);
        button.click();
        logger.info("User clicks to {} button", signIn);
    }

    @Then("{string}  form is displayed")
    public void SignInFOrmIsDisplayed(String form) throws IllegalAccessException, InterruptedException {
        Thread.sleep(2000);
        WebElement element = ReflectionUtils.getWebElement(form);
        ScreenshotUtils.takeScreenshotOfElement(form, element);
        MatcherAssert.assertThat(element.isDisplayed(), is(true));
        logger.info("  Sign In form {} is displayed", form);
    }

    @And("user fills the existing {string} and {string} fields")
    public void userTypesExistingCredentials(String elementName, String elementName1) throws IllegalAccessException, InterruptedException {
        Thread.sleep(5000);
        Browser.getBrowser().switchTo().frame("alibaba-login-box");
        WebElement element = ReflectionUtils.getWebElement(elementName);
        element.sendKeys("mihai52191821@gmail.com");

        WebElement element1 = ReflectionUtils.getWebElement(elementName1);
        element1.sendKeys("Zula521");
    }

    @And("user click on {string}   button")
    public void firstItemIsClicked(String sub) throws IllegalAccessException, InterruptedException {
        WebElement button = ReflectionUtils.getWebElement(sub);
        ScreenshotUtils.takeScreenshotOfElement(sub, button);
        button.click();
        logger.info("User clicks on {} button", sub);
        Thread.sleep(2000);
    }

    @Then("Mihai user is logged in message is displayed")
    public void successfullyLogin() {
        Browser.getBrowser().switchTo().defaultContent();
        MatcherAssert.assertThat(Browser.getBrowser().findElement(By.xpath("//span[contains(text(),'Hi, Mihai')]")).getText().contains("Hi, Mihai"), is(true));
        logger.info("User is logged in successfully!");
        ScreenshotUtils.takeScreenshot("Mihai loged in");
    }
}