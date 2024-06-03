import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
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


    @Test(description = "Check users credentials from Help Button")
    public void accessUserCredentials() throws InterruptedException {
        assertEquals("Products",loginPage.headerText.getText());
        loginPage.clickHelpButton();
        Thread.sleep(4000);
        assertEquals("Valid usernames", loginPage.header3Text.getText());
        loginPage.clickCloseButton();
        Thread.sleep(4000);
        assertEquals("Products",loginPage.headerText.getText());
    }
    @Test (description = "Login with correct user and UPPERCASE LETTERS FOR CORRECT PASSWORD")
    public void successLoginCapsLetters () throws InterruptedException {
        loginPage.clickCreateAnAccount();
        Thread.sleep(1000);
        loginPage.setUserNameCorrect();
        loginPage.setPasswordCorrectCaps();
        loginPage.clickLogin();
        assertEquals("Hello guest!", loginPage.helloGuest.getText());

    }
}

