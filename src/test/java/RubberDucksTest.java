import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RubberDucksTest extends BaseTest {
    int expectedQuantityDucks = 5;
    String expectedPriceByDate = "$18";
    String expectedPriceByName = "$20";

    @Test
    @Description("Тест проверяет, количество элементов на странице соответствует ожидаемому")
    public void quantityDucksTest() {
        logger.info("quantityDucksTest started");
        rubberDucksPage.clickRubberDucks();
        Assert.assertEquals(rubberDucksPage.getQuantityDucks(), expectedQuantityDucks,
                "Actual quantity ducks = " + rubberDucksPage.getQuantityDucks());
    }

    @Test
    @Description("Тест проверяет корректное поведение в случае нажатия кнопки сортировки по Дате")
    public void sortByDateTest() {
        logger.info("sortByDateTest started");
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.clickDate();
        Assert.assertEquals(rubberDucksPage.getPriceByDate(), expectedPriceByDate,
                "Actual first's duck price sorted by Date = " + rubberDucksPage.getPriceByDate());
    }

    @Test
    @Description("Тест проверяет корректное поведение в случае нажатия кнопки сортировки по Имени")
    public void sortByNameTest() {
        logger.info("sortByNameTest started");
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.clickName();
        Assert.assertEquals(rubberDucksPage.getPriceByName(), expectedPriceByName,
                "Actual first's duck price sorted by Name = " + rubberDucksPage.getPriceByName());
    }
}
