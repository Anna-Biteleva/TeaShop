package org.biteleva.Lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Oolong  extends AbstractPage {

    public Oolong(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "search")
    private WebElement winSearch;

    @FindBy(css = ".btn-default > .fa")
    private WebElement buttonSearch;

    @FindBy(xpath = "//button[@onclick=\"addCartOption('search','524', '1');\"]")
    private WebElement buttonBuy;

    @FindBy(css = "#cart > button")
    private WebElement iconBasket;

    @FindBy(css = "a.btn.btn-primary.btn-block")
    private WebElement popUp;

    @FindBy(css = ".fa-times-circle")
    private WebElement cleanBasket;


    @FindBy(xpath = "//*[@id='simplecheckout_cart']/div[1]/table/tbody/tr/td[2]/a")
            private WebElement basket;

    public  WebElement getBasket() {
        return basket;
    }

    public void OolongBuy() {
        winSearch.click();
        winSearch.sendKeys("ГАБА");
        buttonSearch.click();
        buttonBuy.click();
        iconBasket.click();
        popUp.click();
    }


    public void OolongRemove() {

        cleanBasket.click();
    }
}


/*    WebElement webElement1 = driver.findElement(By.name("search"));
        webElement1.click();
        webElement1.sendKeys("ГАБА");

    WebElement webElement2 = driver.findElement(By.cssSelector(".btn-default > .fa")); // поиск
        webElement2.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick=\"addCartOption('search','524', '1');\"]")));
    WebElement webElement3 = driver.findElement(By.xpath("//button[@onclick=\"addCartOption('search','524', '1');\"]")); // кнопка "Купить"
        webElement3.click();
    // WebElement webElement4 = driver.findElement(By.cssSelector(".fa-shopping-cart")); // иконка корзины
    WebElement webElement4 = driver.findElement(By.cssSelector("#cart > button")); // иконка корзины
        webElement4.click();
    WebElement webElement6 = driver.findElement(By.cssSelector("a.btn.btn-primary.btn-block")); // выпадающее окно
        webElement6.click();
    WebElement webElement7 = driver.findElement(By.cssSelector(".fa-times-circle")); //очистить корзину
        webElement7.click();
}*/
