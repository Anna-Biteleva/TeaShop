package org.biteleva.Lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class VkTest extends AbstractTest {

    @Test
     void  VkTest () {

        new WebDriverWait(getDriver(),
                Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://artoftea.ru"));

        WebElement webElement1 = getDriver().findElement(By.cssSelector(".topbar_inner .socsetii-vk > .fa"));
        webElement1.click();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://vk.com/theartoftea"), "Не удалось перейти на страницу VK");
        WebElement webElement2 = getDriver().findElement(By.xpath("//*[@id=\"page_info_wrap\"]/div/div/div[2]/div/a"));
        webElement2.click();
        //driver.quit();


} }
