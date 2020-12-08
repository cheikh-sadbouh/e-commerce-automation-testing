package com.saucedemo.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
   private By button_checkout= By.linkText("CHECKOUT");

    WebDriver webDriver;

    CartPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }
    public  static CartPage setWebDriver(WebDriver webDriver){
        return new CartPage(webDriver);
    }
    public CartPage clickCheckout(){
        webDriver.findElement(button_checkout).click();
     return this;
    }

}
