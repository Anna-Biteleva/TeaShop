package org.biteleva.Lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SocialMedia extends AbstractPage {

    public SocialMedia(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".topbar_inner .socsetii-vk > .fa")
    private WebElement iconVK;

    @FindBy(xpath ="//*[@id=\"page_info_wrap\"]/div/div/div[2]/div/a")
    private WebElement linkVK;


    @FindBy(css=".topbar_inner .socsetii-youtube > .fa")
    private WebElement iconYoutube;

    @FindBy(linkText ="https://artoftea.ru")
    private WebElement linkYoutube;



    public void checkVK () {
      iconVK.click();

    }

    public void returnVK(){
        linkVK.click();

    }

    public SocialMedia checkYoutube () {
        iconYoutube.click();
        return this;
    }

    public SocialMedia returnYoutube(){
        linkYoutube.click();
        return this;
    }

    }

