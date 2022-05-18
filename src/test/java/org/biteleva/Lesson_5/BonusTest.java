package org.biteleva.Lesson_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BonusTest extends AbstractTest{

@Test
    void BonusTest(){
    WebElement webElement1 = getDriver().findElement(By.xpath("(//a[contains(text(),'Бонусы')])[2]"));
    webElement1.click();
    Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://artoftea.ru/avtomaticheskiy-uchet-skidok-po-karte-postoyannogo-pokupatelya"),
            "Не удалось авторизоваться");

    }
}
