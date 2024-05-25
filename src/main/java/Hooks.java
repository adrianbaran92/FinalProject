import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Hooks {

    public WebDriver driver;

    private ExtentSparkReporter extentSparkReporter;

    public ExtentReports extentReports;

    public static ExtentTest extentTest;

    @BeforeClass
    public void setUp() {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Baran Adrian\\Desktop\\Final Project _Adrian\\Final_Project_Adrian\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://fasttrackit-test.netlify.app/#/");

    }
    

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}
