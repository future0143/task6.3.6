import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StepsForTest {

    public static void waitTime(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Step(value = "Поиск элемента по id")
    public static WebElement searchById(WebDriver driver, String id) {
        WebElement searchInput = driver.findElement(By.id(id));
        waitTime(3000);
        return searchInput;
    }

    @Step(value = "Ввод текста в поле ввода")
    public static void sendKeys(WebElement element, String keys) {
        element.sendKeys(keys);
        waitTime(3000);
    }

    @Step(value = "Поиск элемента по xpath")
    public static WebElement searchByXPath(WebDriver driver, String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

    @Step(value = "Нажатие на кнопку")
    public static void clickButton(WebElement element) {
        element.click();
        waitTime(3000);
    }

    @Step(value = "Поиск списка элементов по имени класса")
    public static List<WebElement> searchListOfElementsByClassName(WebDriver driver, String className) {
        return driver.findElements(By.className(className));
    }

    @Step(value = "Поиск списка элементов по css-селектору")
    public static WebElement searchListOfElementsByCssSelector(WebDriver driver, String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    @Step(value = "Поиск списка элементов по тексту")
    public static WebElement searchListOfElementsByText(WebDriver driver, String text) {
        return driver.findElement(By.linkText(text));
    }
}