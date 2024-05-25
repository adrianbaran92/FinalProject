import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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

    @Test(description="Test the search")
    public void checkoutTest() throws InterruptedException {
        checkoutPage.clickAddProductGraniteChipsToCartLink();


    }

    @Test(description = "Test the search function by searching how many products containes Chair")
    public void searchTest()  throws InterruptedException{
        checkoutPage.searchBar();
        checkoutPage.clickSearchButton();
        assertEquals("Awesome Metal Chair", checkoutPage.getMetalChair().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The test searches how many products are chair");
    }



}
