import io.qameta.allure.Description;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    String expectedSuccessMessage = "You are now logged in as Liudmila Grishina.";
    String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";
    Logger logger = Logger.getLogger(LoginTest.class);

    @Test
    @Description("Тест проверяет корректное поведение в случае попытки логина с несуществующими данными")
    public void TestIncorrectLogin() {
        logger.info("TestIncorrectLogin started");
        loginPage.fillIncorrectLoginAndSend();
        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage,
                "Actual error message is " + "'" + loginPage.getErrorMessage() + "'");
    }

    @Test
    @Description("Тест проверяет корректное поведение в случае логина с существующими данными")
    public void TestCorrectLogin() {
        logger.info("TestCorrectLogin started");
        loginPage.fillCorrectLoginAndSend();
        Assert.assertEquals(loginPage.getSuccessMessage(), expectedSuccessMessage,
                "Actual success message is " + "'" + loginPage.getSuccessMessage() + "'");
    }
}
