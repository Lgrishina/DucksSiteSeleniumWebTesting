import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import pageObjects.RubberDucksPage;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected String baseURL = "https://litecart.stqa.ru/en/";
    protected WebDriver webDriver;
    protected LoginPage loginPage;
    protected RubberDucksPage rubberDucksPage;
    Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeClass
    public void beforeClass() {
        logger.info("Before test started");
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
        WebDriverRunner.setWebDriver(webDriver);
        loginPage = new LoginPage(webDriver);
        rubberDucksPage = new RubberDucksPage(webDriver);
        logger.info("Before test ended");
    }

    @BeforeMethod
    public void beforeMethod() {
        logger.info("beforeMethod deleting cookies");
        webDriver.manage().deleteAllCookies();
        logger.info("Opening " + baseURL);
        open(baseURL);
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        logger.info("Tests ended");
        webDriver.quit();
    }
}
