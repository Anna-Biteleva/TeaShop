package org.biteleva.Lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private static WebDriver driver;

    @BeforeAll
      static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

      @BeforeEach
        void goTo() {
       //  driver.get("https://artoftea.ru");
          // Assertions.assertTrue(driver.getCurrentUrl().contains("https://artoftea.ru"), "Главная страница недоступна");
       Assertions.assertDoesNotThrow( () -> driver.navigate().to ("https://artoftea.ru"), "Страница недоступна");
   }

    @AfterAll
    static void close(){
      driver.quit();
    }

public static WebDriver getDriver() {

return driver; }

}