import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {


    public WebDriverWait wait;


    public LoginPage(WebDriver driver) {


        super(driver);
        wait = new WebDriverWait(driver, 30);
    }


    @FindBy(css = ".svg-inline--fa.fa-sign-in-alt.fa-w-16")
    public WebElement createAnAccount;


    public void clickCreateAnAccount() {
        createAnAccount.click();
    }

    @FindBy(id = "user-name")
    private WebElement userNameField;


    public void setUsernameField() {
        userNameField.sendKeys("user1");
    }


    @FindBy (id = "user-name")
    private WebElement userNameCorrect;
    public void setUserNameCorrect(){userNameField.sendKeys("dino");}


    @FindBy(id = "password")
    private WebElement passwordField;


    public void setPasswordField() {
        passwordField.sendKeys("user1password");
    }


    @FindBy (id = "password")
    private WebElement setPasswordCorrect;
    public void setPasswordCorrect(){setPasswordCorrect.sendKeys("choochoo");}


    @FindBy(className = "btn-primary")
    private WebElement loginButton;


    public void clickLogin() {
        loginButton.click();
    }


    @FindBy(css = ".error")
    private WebElement incorrectPassword;


    public WebElement getIncorrectPassword() {return incorrectPassword;
    }


    @FindBy(css =".btn-link")
    private WebElement logoutButton;


    public void clickLogoutButton(){logoutButton.click();}


    @FindBy(css =".btn-primary ")
    public WebElement submitButton;


    public void clickSubmitButton(){submitButton.click();}


    @FindBy(tagName = "h3")
    WebElement header3Text;


    @FindBy(tagName = "h1")
    WebElement headerText;


    @FindBy(css =".svg-inline--fa.fa-question.fa-w-12")
    private WebElement helpButton;

    public void clickHelpButton(){helpButton.click();
    }


    @FindBy(css =".close")
    private WebElement closeButton;
    public void clickCloseButton(){closeButton.click();}


    @FindBy(xpath = "(//span[.='Hello guest! '])")
    public WebElement helloGuest;

    @FindBy (id = "password")
    private WebElement setPasswordCorrectCaps;
    public void setPasswordCorrectCaps(){setPasswordCorrect.sendKeys("CHOOCHOO");}
    }





