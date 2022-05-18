package org.biteleva.Lesson_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OolongTest extends AbstractTest {

    @Test
     void OolongTest()  {


        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://artoftea.ru"));
        Actions search = new Actions(getDriver());

        search.click(getDriver().findElement(By.name("search")))
                .sendKeys(getDriver().findElement(By.name("search")), "ГАБА")
                .click(getDriver().findElement(By.cssSelector(".btn-default > .fa")))
                .build()
                .perform();
         search.click(getDriver().findElement(By.xpath("//button[@onclick=\"addCartOption('search','524', '1');\"]")))
                 .build()
                 .perform();
        WebElement webElement1 = getDriver().findElement(By.cssSelector("#cart > button")); // иконка корзины
        webElement1.click();
      //  new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-primary.btn-block")));
          search.click(getDriver().findElement(By.cssSelector("a.btn.btn-primary.btn-block"))) // кликнуть  в выпадающем окне
                 .build()
                 .perform();
          WebElement webElement2=getDriver().findElement(By.xpath("//*[@id='simplecheckout_cart']/div[1]/table/tbody/tr/td[2]/a"));
          Assertions.assertTrue(webElement2.getText().contains("«Знакомство с Габа-чаем», "),"В корзину попал не тот товар, который выбран");

              search.click(getDriver().findElement(By.cssSelector(".fa-times-circle"))) //очистка корзины
                .build()
                .perform();
    } }






