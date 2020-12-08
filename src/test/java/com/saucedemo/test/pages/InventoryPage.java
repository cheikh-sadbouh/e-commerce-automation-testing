package com.saucedemo.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    private  By select_product_sort = By.className("product_sort_container");
    private By  link_first_Product = By.xpath("//a[@id='item_2_title_link']/div");
    private By  image_first_Product = By.xpath("//div[@id='inventory_container']/div/div/div[3]/button");
    private  By cart_product = By.cssSelector("path");


    private static   String [] ProductList = {"Sauce Labs Backpack","Sauce Labs Onesie"};

    public static  String[] getProductList() {
        return ProductList;
    }
     WebDriver webDriver;

    InventoryPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }
    public  static InventoryPage setWebDriver(WebDriver webDriver){
        return new InventoryPage(webDriver);
    }

    public InventoryPage filterItem(){
        webDriver.findElement(select_product_sort).click();
        return this;
    }
    public InventoryPage byPriceLowToHigh(){
        new Select(webDriver.findElement(select_product_sort)).selectByValue("lohi");
        return this;
    }
    public InventoryPage selectFirstItem(){
        webDriver.findElement(link_first_Product).click();
        return this;
    }

    public InventoryPage addFirstItemToShoppingCart(){
        webDriver.findElement(image_first_Product).click();

        return this;
    }
    public InventoryPage ProceedToShoppingCartPage(){
        webDriver.findElement(cart_product).click();
        return this;
    }
}
