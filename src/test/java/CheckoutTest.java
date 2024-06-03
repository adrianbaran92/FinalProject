import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;


@Listeners(ExtentTestNGITestListener.class)

public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description="Select a product")
    public void checkoutTest() throws InterruptedException {
        Thread.sleep(5000);
        checkoutPage.clickAddProductGraniteChipsToCartLink();
        Thread.sleep(5000);

    }

    @Test(description = "Test the search function by searching how many products containes Chair")
    public void searchTest()  throws InterruptedException{
        checkoutPage.searchBar();
        checkoutPage.clickSearchButton();
        assertEquals("Awesome Metal Chair", checkoutPage.getMetalChair().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The test searches how many products are chair");
    }

    @Test(description = "Calculating the price when the quantity is changed ")
    public void quantityOfAProductTest() throws InterruptedException {
        checkoutPage.clickAwesomeGraniteChipsToCartLink();
        Thread.sleep(3000);
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        Thread.sleep(3000);
        checkoutPage.clickCartButton();
        Thread.sleep(3000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product after updating quantity to 2 is " + checkoutPage.ProductPrice());
        double expectedTotal = checkoutPage.ProductPrice() * 2;
        checkoutPage.clickQuantity();
        Thread.sleep(3000);
        assertEquals(checkoutPage.ProductPrice(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The prices is correct");
    }


    @Test(description = "Calculating the total price with taxes ")
    public void totalPriceWithTaxesTest() {
        checkoutPage.clickAwesomeGraniteChipsToCartLink();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The product price is : " + checkoutPage.ProductPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Tax price is " + checkoutPage.taxPrice());
        double expectedTotal = checkoutPage.ProductPrice() + checkoutPage.taxPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Total price will be " + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Total price is " +checkoutPage.totalPrice());


    }


    @Test(description = "Sorting products from Z-A")
    public void sortZa(){
        assertEquals("Sort name (A to Z)", checkoutPage.optionAZ.getText());
        checkoutPage.clickSortDropdown();
        checkoutPage.clickOptionZA();
        assertEquals("Sort name (Z to A)", checkoutPage.optionZA.getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Sortare: " + checkoutPage.optionZA.getText());
    }


    @Test(description = "Sort by price(Low To High)")
    public void sortLowToHigh(){
        assertEquals("Sort by name (A to Z)", checkoutPage.optionAZ.getText());
        checkoutPage.clickSortDropdown();
        checkoutPage.clickOptionLowToHigh();
        assertEquals("Sort by price (low to high)", checkoutPage.optionLowToHigh.getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Sortare: " + checkoutPage.optionLowToHigh.getText());


    }


    @Test(description = "Sort by price(High To Low)")
    public void sortHighToLow(){
        assertEquals("Sort by name (A to Z)", checkoutPage.optionAZ.getText());
        checkoutPage.clickSortDropdown();
        checkoutPage.clickOptionHighToLow();
        assertEquals("Sort by price (high to low)", checkoutPage.optionHighToLow.getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Sortare: " + checkoutPage.optionHighToLow.getText());


    }


    @Test (description = "Navigate to cart page")
    public void goToCart(){
        assertEquals("Products", checkoutPage.headerText.getText());
        checkoutPage.clickCartButton();
        assertEquals("Your cart", checkoutPage.headerText.getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Navigare de pe pagina Products pe "  + checkoutPage.headerText.getText());
    }


    @Test(description = "Add AwesomeGraniteChips to favorites")
    public void addItemToFavorites(){
        checkoutPage.clickAwesomeGraniteChipsToCartLink();
        checkoutPage.clickAddToFavoritesButton();
        checkoutPage.clickFavoritesButton();
        ExtentTest log = ExtentTestNGITestListener.getTest().log(Status.INFO, "Navigare de pe pagina Products pe  " + checkoutPage.headerText.getText());
    }


    @Test (description = "Reset the application state")
    public void resetAppButton() {
        checkoutPage.clickAwesomeGraniteChipsToCartLink();
        checkoutPage.clickAddToFavoritesButton();
        checkoutPage.clickFavoritesButton();
        checkoutPage.clickResetAppButton();
        ExtentTest log = ExtentTestNGITestListener.getTest().log(Status.INFO, "Navigare de pe pagina Products pe  " + checkoutPage.headerText.getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Resetarea aplicatiei");
    }


    @Test (description = "Add product to cart and complete user credentials without completing the firts name field")
    public void procedeeCheckoutWithoutFirstName() throws InterruptedException {
        checkoutPage.clickAwesomeGraniteChipsToCartLink();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        assertEquals("Your cart", checkoutPage.headerText.getText());
        checkoutPage.clickCheckoutButton();
        checkoutPage.setFirstNameCheckout();
        checkoutPage.setAddressCheckout();
        checkoutPage.clickCheckoutButton();
        assertEquals("Last Name is required", checkoutPage.getLastNameIsRequired().getText());
    }


    @Test (description = "Add product to cart and complete user credentials without completing the last name field")
    public void procedeeCheckoutWithoutLastName() throws InterruptedException {
        checkoutPage.clickAwesomeGraniteChipsToCartLink();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        assertEquals("Your cart", checkoutPage.headerText.getText());
        checkoutPage.clickCheckoutButton();
        checkoutPage.setLastNameCheckout();
        checkoutPage.setAddressCheckout();
        checkoutPage.clickCheckoutButton();
        assertEquals("First Name is required", checkoutPage.getLastNameIsRequired().getText());
    }
    @Test (description = "Add product to cart and complete user credentials without completing the address field")
    public void procedeeCheckoutWithoutAddress() throws InterruptedException {
        checkoutPage.clickAwesomeGraniteChipsToCartLink();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        assertEquals("Your cart", checkoutPage.headerText.getText());
        checkoutPage.clickCheckoutButton();
        checkoutPage.setLastNameCheckout();
        checkoutPage.setFirstNameCheckout();
        checkoutPage.clickCheckoutButton();
        assertEquals("Address is required", checkoutPage.getLastNameIsRequired().getText());
    }


    @Test(description = "Add product to cart and complete the order")
    public void completeTheOrder() {
        checkoutPage.clickAwesomeGraniteChipsToCartLink();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        assertEquals("Your cart", checkoutPage.headerText.getText());
        checkoutPage.clickCheckoutButton();
        checkoutPage.setLastNameCheckout();
        checkoutPage.setFirstNameCheckout();
        checkoutPage.setAddressCheckout();
        checkoutPage.clickCheckoutButton();
        assertEquals("Order summary", checkoutPage.headerText.getText());
        checkoutPage.clickCheckoutButton();
        assertEquals("Order complete", checkoutPage.headerText.getText());


    }
    @Test(description = "Return to home and continue shopping after an order completed.")
    public void continueShopping() {
        checkoutPage.clickAwesomeGraniteChipsToCartLink();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        assertEquals("Your cart", checkoutPage.headerText.getText());
        checkoutPage.clickCheckoutButton();
        checkoutPage.setLastNameCheckout();
        checkoutPage.setFirstNameCheckout();
        checkoutPage.setAddressCheckout();
        checkoutPage.clickCheckoutButton();
        assertEquals("Order summary", checkoutPage.headerText.getText());
        checkoutPage.clickCheckoutButton();
        assertEquals("Order complete", checkoutPage.headerText.getText());
        checkoutPage.clickCheckoutButton();
        assertEquals("Products", checkoutPage.headerText.getText());


    }


    @Test(description = "Delete a product from cart")
    public void trashButton(){
        checkoutPage.clickAwesomeGraniteChipsToCartLink();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Click to view the product Awesome Granite Chips");
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Click to add Awesome Granite Chips to cart");
        checkoutPage.clickCartButton();
        assertEquals("Your cart", checkoutPage.headerText.getText());
        checkoutPage.clicktrashButton();
        assertEquals("Your cart", checkoutPage.headerText.getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Awesome Granite Chips was detele from cart");


    }

}
