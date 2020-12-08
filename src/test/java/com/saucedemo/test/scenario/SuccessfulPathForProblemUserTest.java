package com.saucedemo.test.scenario;

import com.saucedemo.test.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import saucedemo.test.pages.*;

import java.util.concurrent.TimeUnit;

public class SuccessfulPathForProblemUserTest {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir")+"\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void successfulPathScenarioForProblemUserTest() throws Exception {
        driver.get("https://www.saucedemo.com/");
        LoginPage.setWebDriver(driver)
                .enterUserName("problem_user")
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

      Boolean ProductsAreNotOk=  CheckoutStepTwoPage.setWebDriver(driver)
                .verifyProductsAreCorrect(InventoryPage.getProductList());


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(ProductsAreNotOk.equals(true),
                "products are not correct they should be two products but  only find product is there");
        softAssert.assertAll();

        CheckoutStepTwoPage.setWebDriver(driver) .ClickOnFinish();
        CheckoutCompletePage.setWebDriver(driver)
                .openMenu()
                .clickOnLogOut();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
