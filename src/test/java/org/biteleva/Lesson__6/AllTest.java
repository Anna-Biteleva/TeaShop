package org.biteleva.Lesson__6;


import org.biteleva.Lesson6.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AllTest extends AbstrTest {

@Test
    void authTest(){

AuthPage authPage = new AuthPage (getDriver());

authPage.authentication();
 Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://artoftea.ru/my-account"), "Не удалось авторизоваться");

}
@Test
    void vkTest(){

    SocialMedia socialMedia = new SocialMedia(getDriver());
    socialMedia.checkVK();
    //socialMedia.returnVK();
     Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://vk.com/theartoftea"),"Не удалось переключиться на страницу VK ");

}
    @Test
    void youtubeTest(){
        SocialMedia socialMedia = new SocialMedia(getDriver());
        socialMedia
                .checkYoutube()
                .returnYoutube();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://www.youtube.com/channel/UCDayjH1CPNwCTg3vBOPcY0Q"),"Сбой переключения на страницу Youtube ");

    }

@Test
    void oolongTest(){
    Oolong oolong  = new Oolong(getDriver());

    oolong.OolongBuy();

    Assertions.assertTrue(oolong.getBasket().getText().contains("«Знакомство с Габа-чаем», "),"В корзину попал не тот товар, который выбран");
    oolong.OolongRemove();

}

@Test
    void contactTest(){
    ContactPage contactPage = new ContactPage(getDriver());
    contactPage.switchContacts();
    Assertions.assertTrue(contactPage.getPhone().getText().contains("Телефон"),"На странице 'Контакты' нет раздела 'Телефон' " );
    Assertions.assertTrue(contactPage.getEmail().getText().contains("Email"),"На странице 'Контакты' нет раздела 'Email'" );
    Assertions.assertTrue(contactPage.getAddress().getText().contains("Адрес"),"На странице 'Контакты' нет раздела 'Адрес'");
}

@Test
    void bonusTest(){
    BonusPage bonusPage= new BonusPage(getDriver());
    bonusPage.pressBonus();
    Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://artoftea.ru/avtomaticheskiy-uchet-skidok-po-karte-postoyannogo-pokupatelya"),
            "Не удалось переключиться на страницу с бонусами");

}

}







