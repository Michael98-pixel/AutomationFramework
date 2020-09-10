package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage{

    @FindBy(xpath = "//div[@class='product-info']//div[2]//ul[1]//li[1]//div[1]")
    private WebElement type;

    @FindBy(xpath = "//div[@class='product-info']//li[2]//div[1]//img[1]")
    private WebElement color;

    @FindBy(xpath = "//button[@class='next-btn next-large next-btn-primary addcart']")
    private WebElement addToCart;

    @FindBy(xpath = "//div[@class='addcart-result-inner']")
    private WebElement success;

    @FindBy(xpath = "//button[@class='next-btn next-small next-btn-primary view-shopcart']")
    private WebElement cart;

    @FindBy(css = "body > div.next-overlay-wrapper.opened > div.next-overlay-inner.next-dialog-container > div > a")
    private WebElement popUp;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {

        return "https://www.aliexpress.com/item/";
    }

}

