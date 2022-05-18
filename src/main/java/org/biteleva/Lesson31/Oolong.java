package org.biteleva.Lesson31;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Oolong {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://artoftea.ru");

        WebElement webElement1 = driver.findElement(By.name("search"));
        webElement1.click();
        webElement1.sendKeys("ГАБА");
        WebElement webElement2 = driver.findElement(By.cssSelector(".btn-default > .fa")); // поиск
        webElement2.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick=\"addCartOption('search','524', '1');\"]")));
        WebElement webElement3 = driver.findElement(By.xpath("//button[@onclick=\"addCartOption('search','524', '1');\"]")); // кнопка "Купить"
        webElement3.click();
       // WebElement webElement4 = driver.findElement(By.cssSelector(".fa-shopping-cart")); // иконка корзины
        WebElement webElement4 = driver.findElement(By.cssSelector("#cart > button")); // иконка корзины
        webElement4.click();
        WebElement webElement6 = driver.findElement(By.cssSelector("a.btn.btn-primary.btn-block")); // выпадающее окно
        webElement6.click();
        WebElement webElement7 = driver.findElement(By.cssSelector(".fa-times-circle")); //очистить корзину
        webElement7.click();

        //driver.quit();
    }
}
