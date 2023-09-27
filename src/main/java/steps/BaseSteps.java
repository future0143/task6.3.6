package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static selectElements.SelectElements.*;

public class BaseSteps {

    public static void waitTime(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Step(value = "Поиск элемента по id и ввод текста в поле ввода")
    public static void sendKeysToInput(WebDriver driver, String id, String keys) {
        WebElement webElement = selectElementById(driver, id);
        waitTime(3000);
        webElement.sendKeys(keys);
        waitTime(3000);
    }

    @Step(value = "Поиск элемента по xpath и нажатие на него")
    public static void clickElementByXPath(WebDriver driver, String xPath) {
        WebElement webElement = selectElementByXPath(driver, xPath);
        webElement.click();
        waitTime(3000);
    }

    @Step(value = "Поиск списка элементов по имени класса")
    public static WebElement getElementFromListWithClassName(WebDriver driver, String className, int index) {
        List<WebElement> listOfGoods = selectListOfElementsByClassName(driver, className);
        return listOfGoods.get(index);
    }

    @Step(value = "Поиск списка элементов по css-селектору и нажатие на него")
    public static void clickElementByCssSelector(WebDriver driver, String cssSelector) {
        WebElement webElement = selectListOfElementsByCssSelector(driver, cssSelector);
        webElement.click();
    }

    @Step(value = "Поиск списка элементов по тексту и нажатие на него")
    public static void clickElementByText(WebDriver driver, String text) {
        WebElement webElement = selectListOfElementsByText(driver, text);
        webElement.click();
        waitTime(3000);
    }
}