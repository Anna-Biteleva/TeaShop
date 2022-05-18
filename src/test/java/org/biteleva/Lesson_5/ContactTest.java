package org.biteleva.Lesson_5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactTest extends AbstractTest{

    @Test
    void Auth(){

        WebElement webElement1 = getDriver().findElement(By.xpath("\n" +
                "//*[@id=\"menu\"]/div/nav/div/div[2]/ul/li[7]/a\n"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.xpath("//*[@id='content']/div/div/h1[1]"));
        Assertions.assertTrue(webElement2.getText().contains("Телефон"),"На странице 'Контакты' нет раздела 'Телефон' " );
        WebElement webElement3 = getDriver().findElement(By.xpath("//*[@id='content']/div/div/h1[2]"));
        Assertions.assertTrue(webElement3.getText().contains("Email"),"На странице 'Контакты' нет раздела 'Email'" );
        WebElement webElement4 = getDriver().findElement(By.xpath("//*[@id='content']/div/div/h1[3]"));
        Assertions.assertTrue(webElement4.getText().contains("Адрес"),"На странице 'Контакты' нет раздела 'Адрес'");




     /* JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,850);");
        WebElement webElement5 = getDriver().findElement(By.cssSelector(".layout-control-group:nth-child(4) .button__text"));
        webElement5.click();

      new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Открыть в Яндекс Картах')]")));
         WebElement webElement5 = getDriver().findElement(By.xpath("//span[contains(.,'Открыть в Яндекс Картах')]"));
          webElement5.click();
       Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://yandex.ru/maps/2/saint-petersburg/"),"Яндекс-карта недоступна" );*/

    }
}
