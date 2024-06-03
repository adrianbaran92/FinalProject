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

// de aici incep restul

    @FindBy(linkText = "Refined Frozen Mouse")
    private WebElement FrozenMouse;


    public WebElement getFrozenMouse() {
        return FrozenMouse;


    }


    @FindBy(linkText = "Practical Metal Mouse")
    private WebElement MetalMouse;


    public WebElement getMetalMouse() {
        return MetalMouse;
    }


    public void setSearchBar() {
        searchBar.sendKeys("mouse");
    }


    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchbutton;


    @FindBy(linkText = "Gorgeous Soft Pizza")
    private WebElement gorgeousSoftPizza;


    public void clickGorgeousSoftPizza() {
        gorgeousSoftPizza.click();
    }


    @FindBy(linkText = "Awesome Granite Chips")
    public WebElement AwesomeGraniteChipsToCartLink;


    public void clickAwesomeGraniteChipsToCartLink() {AwesomeGraniteChipsToCartLink.click();
    }
    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
    public WebElement addProductGraniteChipsToCartButton;


    public void clickAddProductGraniteChipsToCartButton() {
        addProductGraniteChipsToCartButton.click();
    }
    @FindBy(xpath = "(//td[@class='amount'])[1]")
    private WebElement amount;


    @FindBy(xpath = "(//td[@class='amount'])[2]")
    private WebElement taxAmount;


    @FindBy(xpath = "(//td[@class='amount'])[3]")
    private WebElement totalAmount;


    public double taxPrice() {
        String TaxValue = taxAmount.getText();
        String cleanTaxValue = TaxValue.replace("$", "");
        return Double.parseDouble(cleanTaxValue);
    }
    public double totalPrice (){
        String TotalValue = totalAmount.getText();
        String cleanTotalValue = TotalValue.replace("$", "");
        return Double.parseDouble(cleanTotalValue);
    }






    @FindBy (css = ".svg-inline--fa.fa-plus-circle.fa-w-16")
    private WebElement plusQuantity;


    public void clickQuantity(){
        plusQuantity.click();


    }
    public double ProductPrice(){
        String amountvalue = totalAmount.getText();
        String cleanamountvalue = amountvalue.replace("$", "");
        return Double.parseDouble(cleanamountvalue);




    }


    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
    private WebElement cartButton;


    public void clickCartButton() {
        cartButton.click();
    }


    @FindBy(css = ".sort-products-select")
    private WebElement sortDropdown;


    public void clickSortDropdown(){ sortDropdown.click(); }
    @FindBy (xpath = "(//option)[2]")
    public WebElement optionZA;


    @FindBy (xpath = "(//option)[1]")
    public WebElement optionAZ;


    public void clickOptionZA(){ optionZA.click(); }


    @FindBy (xpath = "(//option)[3]")
    public WebElement optionLowToHigh;


    public void clickOptionLowToHigh(){ optionLowToHigh.click(); }


    @FindBy (xpath = "(//option)[4]")
    public WebElement optionHighToLow;


    public void clickOptionHighToLow(){ optionHighToLow.click(); }


    @FindBy (tagName = "h1")
    public WebElement headerText;


    @FindBy (css = ".svg-inline--fa.fa-heart.fa-w-16.fa-3x")
    private WebElement addProductToFavoritesIcon;


    @FindBy (css = ".svg-inline--fa.fa-heart.fa-w-16")
    private WebElement favoritesButton;


    public void clickFavoritesButton(){ favoritesButton.click(); }
    public void clickAddToFavoritesButton(){ addProductToFavoritesIcon.click(); }




    @FindBy(css = ".btn.btn-link")
    private WebElement resetAppButton;


    public void clickResetAppButton(){ resetAppButton.click(); }


    @FindBy(css = ".btn-success")
    private WebElement checkoutButton;
    public void clickCheckoutButton(){ checkoutButton.click();}


    @FindBy(id = "first-name")
    private WebElement firstNameCheckout;


    public void setFirstNameCheckout(){firstNameCheckout.sendKeys("Andreea");}


    @FindBy(id = "last-name")
    private WebElement lastNameCheckout;


    public void setLastNameCheckout(){lastNameCheckout.sendKeys("Rarau");}


    @FindBy(id = "address")
    public WebElement addressCheckout;


    public void setAddressCheckout(){addressCheckout.sendKeys("Cluj Napoca");}




    @FindBy(css = ".error")
    private WebElement LastNameIsRequired;


    public WebElement getLastNameIsRequired(){return LastNameIsRequired;}


    @FindBy(css =".svg-inline--fa.fa-trash.fa-w-14 ")
    public WebElement trashButton;


    public void clicktrashButton() {trashButton.click();
    }

}
