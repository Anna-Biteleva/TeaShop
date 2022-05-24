package org.biteleva.Lesson_7;

import io.qameta.allure.*;
import org.biteleva.Lesson6.*;
import org.biteleva.Lesson__6.AbstrTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class AnnotAllTest extends AbstrTest {

    @Test
    @DisplayName("Проверка логов")
    @Feature(value = "Logs capture")
    public void MainPageLogs(){

        List<LogEntry> allLogRows = getDriver().manage().logs().get(LogType.BROWSER).getAll();

             if (allLogRows.size() > 0 ) {
                allLogRows.forEach(logEntry -> {
                    System.out.println("Log message:" + logEntry.getMessage() );
                });
            }
            else { System.out.println("No logs is found");}
        Assertions.assertTrue(true);

        }

    @Test
    @DisplayName("Авторизация")
    @Feature(value = "Authorisation")
    @Severity(SeverityLevel.CRITICAL)
    void authTest(){

        AuthPage authPage = new AuthPage (getDriver());

        authPage.authentication();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://artoftea.ru/my-account"), "Не удалось авторизоваться");

    }


    @Test
    @DisplayName("Cкрин VK")
    @Feature(value = "Social networks")
    @Story(value = " Скрин ВКонтакте")
    @Severity(SeverityLevel.MINOR)

    void ScreenVK () throws InterruptedException, IOException {
        SocialMedia socialMedia = new SocialMedia(getDriver());
        socialMedia.checkVK();
        Thread.sleep(1000);
        File file = Utilituy.makeScreenshot(getDriver(),"VK Page" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(((File) file).toPath()));
        Assertions.assertTrue(true);
    }

    @Attachment(value = " VK Page ", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Test
    @DisplayName("ВКонтакте")
    @Feature(value = "Social networks")
    @Story(value = "ВКонтакте")
    @Severity(SeverityLevel.MINOR)

    void vkTest(){

        SocialMedia socialMedia = new SocialMedia(getDriver());
        socialMedia.checkVK();
       // socialMedia.returnVK();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://vk.com/theartoftea"),"Не удалось переключиться на страницу VK ");



    }
    @Test
    @DisplayName("Youtube")
    @Feature(value = "Social networks")
    @Story(value = "Youtube")
    @Severity(SeverityLevel.MINOR)
    void youtubeTest(){
        SocialMedia socialMedia = new SocialMedia(getDriver());
        socialMedia
                .checkYoutube()
                .returnYoutube();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://www.youtube.com/channel/UCDayjH1CPNwCTg3vBOPcY0Q"),"Сбой переключения на страницу Youtube ");

    }

    @Test
    @DisplayName("Покупка ")
    @Feature(value = "Purchase")
    @Severity(SeverityLevel.CRITICAL)
    void oolongTest(){
        Oolong oolong  = new Oolong(getDriver());

        oolong.OolongBuy();

        Assertions.assertTrue(oolong.getBasket().getText().contains("«Знакомство с Габа-чаем», "),"В корзину попал не тот товар, который выбран");
        oolong.OolongRemove();

    }

    @Test
    @DisplayName("Контакты")
    @Feature(value ="Main menu")
    @Story(value = "Contacts")
    @Severity(SeverityLevel.CRITICAL)
    void contactTest(){
        ContactPage contactPage = new ContactPage(getDriver());
        contactPage.switchContacts();
        Assertions.assertTrue(contactPage.getPhone().getText().contains("Телефон"),"На странице 'Контакты' нет раздела 'Телефон' " );
        Assertions.assertTrue(contactPage.getEmail().getText().contains("Email"),"На странице 'Контакты' нет раздела 'Email'" );
        Assertions.assertTrue(contactPage.getAddress().getText().contains("Адрес"),"На странице 'Контакты' нет раздела 'Адрес'");
    }

    @Test
    @DisplayName("Бонусы")
    @Feature(value = "Main menu")
    @Story(value = "Бонусы")
    @Severity(SeverityLevel.NORMAL)
    void bonusTest(){
        BonusPage bonusPage= new BonusPage(getDriver());
        bonusPage.pressBonus();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://artoftea.ru/avtomaticheskiy-uchet-skidok-po-karte-postoyannogo-pokupatelya"),
                "Не удалось переключиться на страницу с бонусами");

    }

}
