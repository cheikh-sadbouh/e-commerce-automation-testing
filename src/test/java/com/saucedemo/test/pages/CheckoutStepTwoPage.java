package com.saucedemo.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutStepTwoPage {
    private By items_list= By.className("cart_item");
    private By button_finish= By.linkText("FINISH");
    WebDriver webDriver;

    CheckoutStepTwoPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }
    public  static CheckoutStepTwoPage setWebDriver(WebDriver webDriver){
        return new CheckoutStepTwoPage(webDriver);
    }
    public Boolean verifyProductsAreCorrect(String products[]){

        List<WebElement> prouctFound = webDriver.findElements(By.className("inventory_item_name"));
        int productCheker=0;
       for(WebElement product:prouctFound){
          for(String item:products){
              if(item.equalsIgnoreCase( product.getText()))
                 productCheker++;
          }
          if (productCheker !=2 )
               return  false;
       }

        return true;
    }

    public void ClickOnFinish(){
       webDriver.findElement(button_finish).click();
    }
}
