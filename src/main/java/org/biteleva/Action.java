package org.biteleva;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Action {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        Actions search = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://artoftea.ru");
       // new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://artoftea.ru"));


        search.click(driver.findElement(By.name("search")))
                .sendKeys(driver.findElement(By.name("search")), "ГАБА")
                .click(driver.findElement(By.cssSelector(".btn-default > .fa")))
                .click(driver.findElement(By.xpath("//button[@onclick=\"addCartOption('search','524', '1');\"]")))
                .click(driver.findElement(By.cssSelector(".fa-shopping-cart")))
                .click(driver.findElement(By.cssSelector("a.btn.btn-primary.btn-block")))
                .click(driver.findElement(By.cssSelector(".fa-times-circle")))
                .build()
                .perform();
    } }
