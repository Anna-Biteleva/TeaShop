package org.biteleva.Lesson_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthTest extends AbstractTest  {


   @Test
     void AuthTest()  {

       Actions search = new Actions(getDriver());

       search.click(getDriver().findElement(By.linkText("Личный кабинет")))
               .click(getDriver().findElement(By.xpath(".//div[@id='top-links']/ul/li/ul/li[2]/a")))
               .build()
               .perform();
                search.click(getDriver().findElement(By.id("input-email")))
               .sendKeys(getDriver().findElement(By.id("input-email")),"a.biteleva@yandex.ru")
               .click(getDriver().findElement(By.id("input-password")))
               .sendKeys(getDriver().findElement(By.id("input-password")),"654321")
               .click(getDriver().findElement(By.cssSelector("input.btn-cart.btn-block")))
               .build()
               .perform();
       Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://artoftea.ru/my-account"), "Не удалось авторизоваться");

   }
}

