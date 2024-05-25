import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage extends BasePage {

    public WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

//place for locators and methods
    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement addProductGraniteChipsToCartLink;

    public void clickAddProductGraniteChipsToCartLink() {
        addProductGraniteChipsToCartLink.click();
    }
    @FindBy(id="input-search")
    private WebElement searchBar;

    public void searchBar(){
    searchBar.sendKeys("chair");
    }

    @FindBy (css=".btn.btn-light.btn-sm")
    private WebElement searchButton;

    public void clickSearchButton(){
        searchButton.click();
    }

    @FindBy (linkText = "Awesome Metal Chair")
    private WebElement metalChair;

    public WebElement getMetalChair (){
        return metalChair;
    }
}
