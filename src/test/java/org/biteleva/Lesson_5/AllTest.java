package org.biteleva.Lesson_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AllTest extends AbstractTest {
    Actions search = new Actions(getDriver());

    @Test
    void AuthTest()  {

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

    @Test
    void OolongTest()throws InterruptedException {

       // new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://artoftea.ru"));

        //Actions search = new Actions(getDriver());

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
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-primary.btn-block")));
        search.click(getDriver().findElement(By.cssSelector("a.btn.btn-primary.btn-block"))) // кликнуть  в выпадающем окне
                .build()
                .perform();
        WebElement webElement2=getDriver().findElement(By.xpath("//*[@id='simplecheckout_cart']/div[1]/table/tbody/tr/td[2]/a"));
        Assertions.assertTrue(webElement2.getText().contains("«Знакомство с Габа-чаем», "),"В корзину попал не тот товар, который выбран");

        search.click(getDriver().findElement(By.cssSelector(".fa-times-circle"))) //очистка корзины
                .build()
                .perform();
    }

    @Test
    void  VkTest () {

        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://artoftea.ru"));

        WebElement webElement1 = getDriver().findElement(By.cssSelector(".topbar_inner .socsetii-vk > .fa"));
        webElement1.click();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://vk.com/theartoftea"), "Не удалось перейти на страницу VK");
        WebElement webElement2 = getDriver().findElement(By.xpath("//*[@id=\"page_info_wrap\"]/div/div/div[2]/div/a"));
        webElement2.click();

    }


    @Test
    void YouTest () {

        getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebElement webElement1 = getDriver().findElement(By.cssSelector(".topbar_inner .socsetii-youtube > .fa"));
        webElement1.click();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://www.youtube.com/channel/UCDayjH1CPNwCTg3vBOPcY0Q"), "Не удалось перейти на  канал в youtube");
        WebElement webElement2 = getDriver().findElement(By.linkText("https://artoftea.ru"));
        webElement2.click();

    }

    @Test
    void Auth() {

        WebElement webElement1 = getDriver().findElement(By.xpath("\n" +
                "//*[@id=\"menu\"]/div/nav/div/div[2]/ul/li[7]/a\n"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.xpath("//*[@id='content']/div/div/h1[1]"));
        Assertions.assertTrue(webElement2.getText().contains("Телефон"), "На странице 'Контакты' нет раздела 'Телефон' ");
        WebElement webElement3 = getDriver().findElement(By.xpath("//*[@id='content']/div/div/h1[2]"));
        Assertions.assertTrue(webElement3.getText().contains("Email"), "На странице 'Контакты' нет раздела 'Email'");
        WebElement webElement4 = getDriver().findElement(By.xpath("//*[@id='content']/div/div/h1[3]"));
        Assertions.assertTrue(webElement4.getText().contains("Адрес"), "На странице 'Контакты' нет раздела 'Адрес'");
    }

    @Test
    void BonusTest(){
        WebElement webElement1 = getDriver().findElement(By.xpath("(//a[contains(text(),'Бонусы')])[2]"));
        webElement1.click();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://artoftea.ru/avtomaticheskiy-uchet-skidok-po-karte-postoyannogo-pokupatelya"),
                "Не удалось авторизоваться");

    }

    }
