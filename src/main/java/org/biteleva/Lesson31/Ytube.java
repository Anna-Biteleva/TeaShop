package org.biteleva.Lesson31;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Ytube {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://artoftea.ru");
        WebElement webElement1 = driver.findElement(By.cssSelector(".topbar_inner .socsetii-youtube > .fa"));
        webElement1.click();
        //    WebElement webElement2 = driver.findElement(By.cssSelector(".ytp-chrome-bottom:nth-child(30) .ytp-play-button"));
        //  webElement2.click();
        WebElement webElement3 = driver.findElement(By.linkText("https://artoftea.ru"));
        webElement3.click();

        //driver.quit();
} }
