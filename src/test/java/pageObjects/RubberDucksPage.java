package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RubberDucksPage extends BasePage {

    private static By buttonRubberDucks = By.xpath("//a[text()='Rubber Ducks']");
    private static By buttonDate = By.xpath("//a[text()='Date']");
    private static By buttonName = By.xpath("//a[text()='Name']");
    private static By ducks = By.xpath("//li[@class='product column shadow hover-light']");
    private static By priceFirstDuckByDate = By.xpath("//a[@title='Yellow Duck']/div//strong");
    private static By priceFirstDuckByName = By.xpath("//a[@title='Blue Duck']/div/span");

    public RubberDucksPage(WebDriver driver) {
        super(driver);
    }

    public void verifyLoadDuck(){
        $(ducks).shouldBe(Condition.visible);
    }
    public void clickRubberDucks() {
        $(buttonRubberDucks).shouldBe(Condition.exist).click();
        verifyLoadDuck();
    }

    public void clickDate() {
        $(buttonDate).shouldBe(Condition.exist).click();
        verifyLoadDuck();
    }

    public void clickName() {
        $(buttonName).shouldBe(Condition.exist).click();
        verifyLoadDuck();
    }

    public int getQuantityDucks() {
        ElementsCollection listElements = $$(ducks);
        return listElements.size();
    }

    public String getPriceByName() {
        return $(priceFirstDuckByName).shouldBe(Condition.exist).getText();
    }

    public String getPriceByDate() {
        return $(priceFirstDuckByDate).shouldBe(Condition.exist).getText();
    }
}
