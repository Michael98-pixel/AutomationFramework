package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {


    @FindBy(css = "#search-key")
    private WebElement search;

    @FindBy(css = "span.join-btn")
    private WebElement join;

    @FindBy(xpath = "//div[@class='batman batman-dialog']")
    private WebElement form;

    @FindBy (xpath = "//span[@class='register-btn']")
    private  WebElement signIn;

    @FindBy( className="next-dialog-body")
    private WebElement registrationForm;

    @FindBy(xpath = "//input[@placeholder='Email address']")
    public WebElement email;

    @FindBy(xpath= "//input[@placeholder='Password']")
    private WebElement password;


    @FindBy(css= "#fm-login-id")
    private WebElement login;

    @FindBy(css= "#fm-login-password")
    private WebElement pass;

    @FindBy(className = "submit")
    private WebElement submit;

    @FindBy(css = "#login-form > div.fm-btn > button")
    private WebElement sub;


    @FindBy(xpath = "//div[@class='success-mark']")
private  WebElement welcome;

    @FindBy(xpath = "//div[@class='next-dialog-body']")
    private  WebElement registration;

    @FindBy (xpath = "//input[@id='search-key']")
private  WebElement xiaomi;

    @FindBy(xpath = "//div[@class='product-container']//div[1]//li[1]//div[1]//div[1]//div[1]//a[1]//img[1]")
    private WebElement item;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return "https://www.aliexpress.com/";
    }

}


