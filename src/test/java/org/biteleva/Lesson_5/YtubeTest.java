package org.biteleva.Lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class YtubeTest extends AbstractTest {

   @Test
     void YouTest () {

        getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebElement webElement1 = getDriver().findElement(By.cssSelector(".topbar_inner .socsetii-youtube > .fa"));
        webElement1.click();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://www.youtube.com/channel/UCDayjH1CPNwCTg3vBOPcY0Q"), "Не удалось перейти на  канал в youtube");
        WebElement webElement2 = getDriver().findElement(By.linkText("https://artoftea.ru"));
        webElement2.click();


} }
