import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;


@Listeners(ExtentTestNGITestListener.class)


public class LoginTest extends Hooks {


    public LoginPage loginPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 30);
    }

    

    @Test(description = "Login test for invalid user")
    public void loginTest() throws InterruptedException {
        loginPage.clickCreateAnAccount();
        loginPage.setUsernameField();
        Thread.sleep(1000);
        loginPage.setPasswordField();
        Thread.sleep(1000);
        loginPage.clickLogin();
        Thread.sleep(3000);
        assertEquals("Incorrect username or password!", loginPage.getIncorrectPassword().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "This test checks that an invalid user cannot connect");
    }


    @Test (description = "Success Login")
    public void successLogin () throws InterruptedException {
        loginPage.clickCreateAnAccount();
        Thread.sleep(1000);
        loginPage.setUserNameCorrect();
        Thread.sleep(1000);
        loginPage.setPasswordCorrect();
        Thread.sleep(1000);
        loginPage.clickLogin();
    }


    @Test (description = "Click to logout button")
    public void logoutButton () {
        loginPage.clickCreateAnAccount();
        loginPage.setUserNameCorrect();
        loginPage.setPasswordCorrect();
        loginPage.clickLogin();
        loginPage.clickLogoutButton();
        assertEquals("Hello guest!", loginPage.helloGuest.getText());
    }


    @Test(description = "Access the user credentials from Help Button")
    public void accessUserCredentials() throws InterruptedException {
        assertEquals("Products",loginPage.headerText.getText());
        loginPage.clickHelpButton();
        assertEquals("Valid usernames", loginPage.header3Text.getText());
        loginPage.clickCloseButton();
        Thread.sleep(3000);
        assertEquals("Products",loginPage.headerText.getText());
    }


}

