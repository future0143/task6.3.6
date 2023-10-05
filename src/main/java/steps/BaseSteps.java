package steps;

import config.ConfigSetup;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ElementsOfPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseSteps extends ElementsOfPage implements ConfigSetup {

    public static void waitTime(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Step(value = "Найти поле поиска на странице и ввести в него название товара")
    public static void enterProductNameToSearchLine(String text) {
        waitTime(3000);
        WebElement searchLine = driver.findElement(By.id(searchLineSelector));
        searchLine.sendKeys(text);
        waitTime(3000);
        WebElement searchButton = driver.findElement(By.xpath(searchButtonSelector));
        searchButton.click();
        waitTime(11000);
    }

    @Step(value = "Выбрать первый товар из списка и кликнуть по нему, чтобы перейти на страницу товара")
    public static String goToFirstProductPage(int indexOfProduct) {
        List<WebElement> listOfGoodsInProductCard = driver.findElements(By.className(listOfGoodsInProductCardSelector));
        WebElement productFromList = listOfGoodsInProductCard.get(indexOfProduct);
        productFromList.click();
        waitTime(3000);
        return productFromList.getAttribute("title");
    }

    @Step(value = "Нажать на кнопку \"Добавить в корзину\"")
    public static void addProductToBasket() {
        WebElement buttonAddToBasket = driver.findElement(By.cssSelector(buttonAddToBasketSelector));
        buttonAddToBasket.click();
    }

    @Step(value = "Перейти в корзину")
    public static void goToBasket() {
        ConfigSetup.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement buttonGoToBasket = driver.findElement(By.linkText(buttonGoToBasketSelector));
        buttonGoToBasket.click();
        waitTime(3000);
    }

    @Step(value = "Получение первого товара из списка товаров корзины")
    public static String getFirstProductFromBasket() {
        ConfigSetup.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> listOfGoodsInBasket = driver.findElements(By.className(listOfGoodsInBasketSelector));
        return listOfGoodsInBasket.get(0).getAttribute("title");
    }
}