import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class LoginTest extends Hooks {

    public LoginPage loginPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 10);
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
    }


}
