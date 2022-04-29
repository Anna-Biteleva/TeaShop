package org.biteleva.Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AuthTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://artoftea.ru");

        WebElement webElement1 = driver.findElement(By.linkText("Личный кабинет"));
        webElement1.click();
        WebElement webElement2 = driver.findElement(By.xpath(".//div[@id='top-links']/ul/li/ul/li[2]/a"));
                webElement2.click();
        WebElement webElement3 = driver.findElement(By.id("input-email"));
        webElement3.click();
        webElement3.sendKeys("a.biteleva@yandex.ru");
        WebElement webElement4 = driver.findElement(By.id("input-password"));
        webElement4.click();
        webElement4.sendKeys("654321");
        WebElement webElement5 = driver.findElement(By.cssSelector("input.btn-cart.btn-block"));
        webElement5.click();

        //driver.quit();


    }
}
