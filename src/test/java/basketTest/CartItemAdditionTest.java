package basketTest;

import config.ConfigSetup;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import steps.BaseSteps;

import java.util.concurrent.TimeUnit;

import static selectElements.SelectElements.getAttribute;
import static validator.ValidationOfElements.validateTitle;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CartItemAdditionTest extends BaseSteps implements ConfigSetup {

    @Test
    @DisplayName("Добавление товара в корзину")
    @Description("Поиск товара по наменованию и добавление его в корзину")
    public void ScriptWb() {
        String idForSearch = "searchInput";
        String keys = "iphone";
        sendKeysToInput(driver, idForSearch, keys);

        String xPath = "//*[@id=\"applySearchBtn\"]";
        clickElementByXPath(driver, xPath);

        String className = "product-card";
        int indexOfGoods = 0;
        String attribute = "title";
        WebElement elementFromListGoods = getElementFromListWithClassName(driver, className, indexOfGoods);
        String titleExpected = getAttribute(elementFromListGoods, attribute);

        elementFromListGoods.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String cssSelector = "button[data-link*='addToBasket']";
        clickElementByCssSelector(driver, cssSelector);

        String linkText = "Перейти в корзину";
        clickElementByText(driver, linkText);

        String className2 = "accordion__list";
        int indexOfElement = 0;
        WebElement elementFromBasket = getElementFromListWithClassName(driver, className2, indexOfElement);
        String titleActual = getAttribute(elementFromBasket, attribute);

        validateTitle(titleExpected, titleActual);
    }
}