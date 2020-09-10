package MyScenarios;

import com.itstep.aliexpress.Browser;
import com.itstep.aliexpress.ReflectionUtils;
import com.itstep.aliexpress.ScenarioContext;
import com.itstep.aliexpress.ScreenshotUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AbstractPage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static com.itstep.aliexpress.ScenarioDataKey.CURRENT_PAGE;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.openqa.selenium.Keys.ENTER;

public class My2Scenario {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Given("user navigates to  {string} page")
    public void userNavigatesToTheSite(String url) {
        Browser.getBrowser().navigate().to(url);
        logger.info("User navigates to {}", url);

    }

    @Then("user write in Search box {string} and press ENTER key")
    public void userTypesSomethingInSearch(String elementName) throws IllegalAccessException, InterruptedException {
        Thread.sleep(2000);
Browser.getBrowser().findElement(By.linkText("https://img.alicdn.com/tfs/TB1a.Oge_M11u4jSZPxXXahcXXa-48-48.png")).click();
        WebElement element = ReflectionUtils.getWebElement(elementName);
        element.sendKeys("Xiaomi redmi note 8 pro mobile");
        element.sendKeys(ENTER);
        ScreenshotUtils.takeScreenshot(elementName);
        logger.info("User is on the search result {} page", elementName);

    }

    @And("results were displayed")
    public void resultsWereDisplayed() {
        MatcherAssert.assertThat(Browser.getBrowser().getCurrentUrl(), containsString("SearchText=Xiaomi+redmi+note+8+pro"));
    }

    @Then("User clicks on first displayed {string}")
    public void firstItemIsClicked(String buttonName) throws IllegalAccessException, InterruptedException {
        Thread.sleep(3000);
        if (Browser.getBrowser().findElement(By.cssSelector("body > div.next-overlay-wrapper.opened > div.next-overlay-inner.next-dialog-container > div > a")).isDisplayed()) {
            Browser.getBrowser().findElement(By.cssSelector("body > div.next-overlay-wrapper.opened > div.next-overlay-inner.next-dialog-container > div > a")).click();
            WebElement button = ReflectionUtils.getWebElement(buttonName);
            ScreenshotUtils.takeScreenshotOfElement(buttonName, button);
            button.click();
            logger.info("User clicks on {} button", buttonName);
            Thread.sleep(2000);
            ArrayList<String> tabs = new ArrayList<>(Browser.getBrowser().getWindowHandles());
            Browser.getBrowser().switchTo().window(tabs.get(1));
        } else {
            WebElement button = ReflectionUtils.getWebElement(buttonName);
            ScreenshotUtils.takeScreenshotOfElement(buttonName, button);
            button.click();
            logger.info("User clicks on {} button", buttonName);
            Thread.sleep(2000);
            ArrayList<String> tabs = new ArrayList<>(Browser.getBrowser().getWindowHandles());
            Browser.getBrowser().switchTo().window(tabs.get(1));
        }
    }

    @And("user is redirected to new {string} page")
    public void userIsOnItemPage(String pageName1) throws InterruptedException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Thread.sleep(3000);
        if (Browser.getBrowser().findElement(By.cssSelector("body > div.next-overlay-wrapper.opened > div.next-overlay-inner.next-dialog-container > div > a")).isEnabled()) {
            Browser.getBrowser().findElement(By.cssSelector("body > div.next-overlay-wrapper.opened > div.next-overlay-inner.next-dialog-container > div > a")).click();
            AbstractPage itemPage = ReflectionUtils.getPageObject(pageName1);
            ScenarioContext.setContext(CURRENT_PAGE.name(), itemPage);
            MatcherAssert.assertThat(Browser.getBrowser().getCurrentUrl(), containsString(itemPage.getPageUrl()));
        } else {

            AbstractPage itemPage = ReflectionUtils.getPageObject(pageName1);
            ScenarioContext.setContext(CURRENT_PAGE.name(), itemPage);
            MatcherAssert.assertThat(Browser.getBrowser().getCurrentUrl(), containsString(itemPage.getPageUrl()));
        }
        ScreenshotUtils.takeScreenshot(pageName1);
        logger.info("User is on the {} page", pageName1);

    }

    @Then("user chose one {string} and {string} and press {string} button")
    public void userAddsToCartCertainItem(String type, String color, String addToCart) throws IllegalAccessException, InterruptedException {
        Thread.sleep(2000);

        //Browser.getBrowser().findElement(By.cssSelector("body > div.next-overlay-wrapper.opened > div.next-overlay-inner.next-dialog-container > div > a")).click();

        WebElement button = ReflectionUtils.getWebElement(type);
        button.click();
        logger.info("User clicked on {} button", type);

        WebElement button1 = ReflectionUtils.getWebElement(color);
        button1.click();
        logger.info("User clicked on {} button", color);

        WebElement button2 = ReflectionUtils.getWebElement(addToCart);
        button2.click();
        logger.info("User clicked on {} button", addToCart);
        ScreenshotUtils.takeScreenshotOfElement(addToCart, button2);
        Thread.sleep(3000);
    }

    @And("{string}  message is displayed")
    public void successMessage(String success) throws IllegalAccessException {
        WebElement element = ReflectionUtils.getWebElement(success);
        MatcherAssert.assertThat(element.isDisplayed(), is(true));
        ScreenshotUtils.takeScreenshotOfElement(success, element);
        logger.info("User is successfully registered {}", success);
    }

    @Then("user checks {string}")
    public void goToCart(String viewCart) throws IllegalAccessException {
        WebElement button = ReflectionUtils.getWebElement(viewCart);
        button.click();
        MatcherAssert.assertThat(Browser.getBrowser().getCurrentUrl(), containsString("https://shoppingcart.aliexpress.com/shopcart/"));
        logger.info("User is successfully registered {}", viewCart);
        ScreenshotUtils.takeScreenshot(viewCart);
    }

    @And("chosen Item is in the cart")
    public void goToCart() {
        MatcherAssert.assertThat(Browser.getBrowser().findElement(By.className("product-name-link")).getText().contains("Xiaomi Redmi"), is(true));
        logger.info("Item is added successfully in the cart");
    }
}

