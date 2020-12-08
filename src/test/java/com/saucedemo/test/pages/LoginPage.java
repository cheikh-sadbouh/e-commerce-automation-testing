package com.saucedemo.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
   private   By input_username= By.id("user-name");
   private By input_password = By.id("password");
   private  By button_login = By.id("login-button");
   private static By  logginErrorMessge = By.xpath("//*[contains(text(),'Epic sadface')]");
   private static WebDriver webDriver;

    LoginPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }
  public  static LoginPage setWebDriver(WebDriver webDriver){
      return new LoginPage(webDriver);
   }

   public LoginPage enterUserName(String username){
        webDriver.findElement(input_username).sendKeys(username);
        return this;
    }
   public LoginPage enterPassword(String password){
       webDriver.findElement(input_password).sendKeys(password);
       return this;
    }
   public LoginPage clickLogin(){
       webDriver.findElement(button_login).click();

       return this;
    }
    public static Boolean hasLoginFailed(){
        WebElement loginError = webDriver.findElement(logginErrorMessge);
        return loginError.isDisplayed();
    }


}
