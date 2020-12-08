package com.saucedemo.test.scenario;

import com.saucedemo.test.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import saucedemo.test.pages.*;

import java.util.concurrent.TimeUnit;

public class SuccessfulPathTest {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir")+"\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void successfulPathScenarioTest() throws Exception {
        driver.get("https://www.saucedemo.com/");
        LoginPage.setWebDriver(driver)
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();

        InventoryPage inventoryPage = InventoryPage
                .setWebDriver(driver)
                .filterItem()
                .byPriceLowToHigh()
                .selectFirstItem();

        InventoryItemPage
                .setWebDriver(driver)
                .addToCart()
                .backToInventoryPage();

        inventoryPage
                .addFirstItemToShoppingCart()
                .ProceedToShoppingCartPage();

        CartPage.setWebDriver(driver)
                .clickCheckout();

        CheckoutStepOnePage.setWebDriver(driver)
                .enterFistName("Mohamed")
                .enterLastName("aboumedyne")
                .enterPostalCode("0000")
                .clickContinueButton();

        CheckoutStepTwoPage.setWebDriver(driver)
                .verifyProductsAreCorrect(InventoryPage.getProductList());

        CheckoutStepTwoPage.setWebDriver(driver).ClickOnFinish();
        CheckoutCompletePage.setWebDriver(driver)
                .openMenu()
                .clickOnLogOut();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

}
