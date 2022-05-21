package org.biteleva.Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BonusPage extends AbstractPage {

    public BonusPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//a[contains(text(),'Бонусы')])[2]")
    private WebElement bonusButton;

    public void pressBonus(){

        bonusButton.click();
    }

}
