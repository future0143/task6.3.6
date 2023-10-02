package selectElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectElements {

    public static WebElement selectElementById(WebDriver driver, String id) {
        return driver.findElement(By.id(id));
    }

    public static WebElement selectElementByXPath(WebDriver driver, String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

    public static List<WebElement> selectListOfElementsByClassName(WebDriver driver, String className) {
        return driver.findElements(By.className(className));
    }

    public static WebElement selectElementByCssSelector(WebDriver driver, String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public static WebElement selectElementByText(WebDriver driver, String text) {
        return driver.findElement(By.linkText(text));
    }

    public static String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }
}