package org.biteleva.Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends AbstractPage {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='menu']/div/nav/div/div[2]/ul/li[7]/a")
    private WebElement contacts;

    @FindBy(xpath = "//*[@id='content']/div/div/h1[1]")
    private WebElement phone;

    @FindBy(xpath = "//*[@id='content']/div/div/h1[2]")
    private WebElement email;

    @FindBy(xpath = "//*[@id='content']/div/div/h1[3]")
    private WebElement address;


    public WebElement getPhone() {
        return phone;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getAddress() {
        return address;
    }

  public void switchContacts(){
        contacts.click();

  }

}




 /*   void ContactTest(){

        WebElement webElement1 = getDriver().findElement(By.xpath("\n" +
                "//*[@id=\"menu\"]/div/nav/div/div[2]/ul/li[7]/a\n"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.xpath("//*[@id='content']/div/div/h1[1]"));
        Assertions.assertTrue(webElement2.getText().contains("Телефон"),"На странице 'Контакты' нет раздела 'Телефон' " );

        Assertions.assertTrue(webElement3.getText().contains("Email"),"На странице 'Контакты' нет раздела 'Email'" );

        Assertions.assertTrue(webElement4.getText().contains("Адрес"),"На странице 'Контакты' нет раздела 'Адрес'");
}*/
