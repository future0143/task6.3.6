package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface ConfigSetup {

    String url = TestProperties.getValue("test.url");
    WebDriver driver = new ChromeDriver();

    @BeforeAll
    static void openChrome() {
        WebDriverManager.chromedriver().driverVersion("117.0.5938.92").setup();

        driver.get(url);
    }

    @AfterAll
    static void driverClose() {
        driver.quit();
    }
}