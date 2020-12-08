package com.saucedemo.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryItemPage {
  private  By button_addToCart= By.xpath("//div[@id='inventory_item_container']/div/div/div/button");
  private  By button_back_toInventoryPage= By.xpath("//div[@id='inventory_item_container']/div/button");
    WebDriver webDriver;

    InventoryItemPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }
    public  static InventoryItemPage setWebDriver(WebDriver webDriver){
        return new InventoryItemPage(webDriver);
    }

    public  InventoryItemPage addToCart(){
        webDriver.findElement(button_addToCart).click();
        return this;
    }
    public  InventoryItemPage backToInventoryPage(){
        webDriver.findElement(button_back_toInventoryPage).click();
        return this;
    }
}
