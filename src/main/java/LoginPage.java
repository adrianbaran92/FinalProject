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

    //place for locators and methods
    @FindBy(css=".svg-inline--fa.fa-sign-in-alt.fa-w-16")
    WebElement createAnAccont;
    public void clickCreateAnAccount() {
        createAnAccont.click();}
    @FindBy(id = "user-name")
    private WebElement userNameField;

    public void setUsernameField() {
        userNameField.sendKeys("Bobita");}

    @FindBy (id = "password")
    private WebElement passwordField;

    public void setPasswordField(){
        passwordField.sendKeys("Parola");
    }

    @FindBy (className="btn-primary")
    private WebElement loginButton;
    public void clickLogin() {
        loginButton.click();
    }

    @FindBy (linkText = "Incorrect username or password!")
    private WebElement incorrectPassword;

    public WebElement getIncorrectPassword (){
        return incorrectPassword ;
    }
}
