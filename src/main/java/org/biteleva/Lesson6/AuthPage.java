package org.biteleva.Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends AbstractPage{

    public AuthPage(WebDriver driver) {
        super(driver);

    }

    // WebElement webElement1 = driver.findElement(By.linkText("Личный кабинет"));
    //   webElement1.click();
    @FindBy(linkText="Личный кабинет")
    private WebElement personalAccount;

    @FindBy(xpath=".//div[@id='top-links']/ul/li/ul/li[2]/a")
    private WebElement registration;

    @FindBy(id="input-email")
   private WebElement inputEmail;

    @FindBy(id="input-password")
    private WebElement inputPassword;

    @FindBy(css ="input.btn-cart.btn-block" )
    private WebElement input;

    public void authentication(){
        personalAccount.click();
        registration.click();
        inputEmail.click();
        inputEmail.sendKeys("a.biteleva@yandex.ru");
        inputPassword.click();
        inputPassword.sendKeys("654321");
        input.click();

    }

}
