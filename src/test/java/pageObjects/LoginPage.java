package pageObjects;
import com.codeborne.selenide.Condition;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private static final By EMAIL = By.xpath("//input[@name='email']");
    private static final By PASSWORD = By.xpath("//input[@name='password']");
    private static final By LOGIN = By.xpath("//button[@name='login']");
    private static By errorMessage = By.xpath("//div[@class='notice errors']");
    private static By successMessage = By.xpath("//div[@class='notice success']");


    static String  correctEmail = "liud.gre@gmail.com";
    static String incorrectEmail = "xwq2@de.com";
    static String correctPassword = "12345678";
    static String incorrectPassword = "123";
    static Logger logger = Logger.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillIncorrectLoginAndSend() {
        logger.info((Object) "start filling with " + incorrectEmail);
        $(EMAIL).shouldBe(Condition.exist).sendKeys(incorrectEmail);
        logger.info((Object)"start filling with " + incorrectPassword);
        $(PASSWORD).shouldBe(Condition.exist).sendKeys(incorrectPassword);
        logger.info("start clicking button " + LOGIN);
        $(LOGIN).shouldBe(Condition.exist).click();
        logger.info("method 'fillIncorrectLoginAndSend' ended");
    }

    public void fillCorrectLoginAndSend() {
        logger.info("start filling " + correctEmail);
        $(EMAIL).shouldBe(Condition.exist).sendKeys(correctEmail);
        logger.info("start filling " + correctPassword);
        $(PASSWORD).shouldBe(Condition.exist).sendKeys(correctPassword);
        logger.info("start clicking button " + LOGIN);
        $(LOGIN).shouldBe(Condition.exist).click();
        logger.info("method 'fillCorrectLoginAndSend' ended");
    }

    public String getErrorMessage() {
        logger.info("start getting error message: " + $(errorMessage).shouldBe(Condition.visible).getText());
        return $(errorMessage).shouldBe(Condition.visible).getText();
    }

    public String getSuccessMessage() {
        logger.info("start getting success message: " + $(successMessage).shouldBe(Condition.visible).getText());
        return $(successMessage).shouldBe(Condition.visible).getText();
    }
}
