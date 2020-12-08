package com.saucedemo.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage {
    private  By input_firstname = By.id("first-name");
    private  By input_lastname = By.id("last-name");
    private  By input_postalcode = By.id("postal-code");
    private  By button_continue = By.xpath("//input[@value='CONTINUE']");

    WebDriver webDriver;

    CheckoutStepOnePage(WebDriver webDriver){
        this.webDriver=webDriver;
    }
    public  static CheckoutStepOnePage setWebDriver(WebDriver webDriver){
        return new CheckoutStepOnePage(webDriver);
    }
    public  CheckoutStepOnePage enterFistName(String firstname){
        webDriver.findElement(input_firstname).sendKeys(firstname);
        return this;
    }
    public  CheckoutStepOnePage enterLastName(String lastname){
        webDriver.findElement(input_lastname).sendKeys(lastname);
        return this;
    }
    public  CheckoutStepOnePage enterPostalCode(String postalcode){
        webDriver.findElement(input_postalcode).sendKeys(postalcode);
        return this;
    }
    public  CheckoutStepOnePage clickContinueButton(){
        webDriver.findElement(button_continue).click();
        return this;
    }
}
