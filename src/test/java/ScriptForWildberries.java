import config.TestProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScriptForWildberries {

    private String url = TestProperties.getValue("test.url");
    private WebDriver driver;

    @BeforeAll
    public void openChrome() {
        WebDriverManager.chromedriver().driverVersion("117.0.5938.92").setup();

        driver = new ChromeDriver();

        driver.get(url);
    }

    @AfterAll
    public void driverClose() {
        driver.quit();
    }

    @Test
    public void ScriptWb() {
        String idForSearch = "searchInput";
        WebElement input = StepsForTest.searchById(driver, idForSearch);

        String keys = "iphone";
        StepsForTest.sendKeys(input, keys);

        String xPath = "//*[@id=\"applySearchBtn\"]";
        WebElement buttonFoundByXpath = StepsForTest.searchByXPath(driver, xPath);

        StepsForTest.clickButton(buttonFoundByXpath);

        String className = "product-card";
        List<WebElement> listOfGoods = StepsForTest.searchListOfElementsByClassName(driver, className);
        WebElement elementFromList = listOfGoods.get(0);
        String titleExpected = elementFromList.getAttribute("title");

        StepsForTest.clickButton(elementFromList);

        String cssSelector = "button[data-link*='addToBasket']";
        WebElement buttonFoundBySelector = StepsForTest.searchListOfElementsByCssSelector(driver, cssSelector);

        StepsForTest.clickButton(buttonFoundBySelector);

        String linkText = "Перейти в корзину";
        WebElement buttonFoundByText = StepsForTest.searchListOfElementsByText(driver, linkText);

        StepsForTest.clickButton(buttonFoundByText);

        String className2 = "accordion__list";
        java.util.List<WebElement> basketItems = StepsForTest.searchListOfElementsByClassName(driver, className2);
        WebElement elementOfBasket = basketItems.get(0);
        String titleActual = elementOfBasket.getAttribute("title");

        Assertions.assertEquals(titleExpected, titleActual);
    }
}