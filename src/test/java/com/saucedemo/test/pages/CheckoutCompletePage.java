package com.saucedemo.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    private By header =By.xpath("//div[@id='header_container']/div");
    private By menu_button =By.xpath("//div[@id='menu_button_container']/div/div[3]/div/button");
    private By button_logout =By.id("logout_sidebar_link");
    WebDriver webDriver;

    CheckoutCompletePage(WebDriver webDriver){
        this.webDriver=webDriver;
    }
    public  static CheckoutCompletePage setWebDriver(WebDriver webDriver){
        return new CheckoutCompletePage(webDriver);
    }

    public  CheckoutCompletePage openMenu(){
        webDriver.findElement(header).click();
        webDriver.findElement(menu_button).click();
        return this;
    }
    public  void clickOnLogOut(){
        webDriver.findElement(button_logout).click();
    }
}
