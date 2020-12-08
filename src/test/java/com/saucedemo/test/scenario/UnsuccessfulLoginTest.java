package com.saucedemo.test.scenario;

import com.saucedemo.test.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import saucedemo.test.pages.*;

import java.util.concurrent.TimeUnit;

public class UnsuccessfulLoginTest {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir")+"\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void unsuccessfulLoginTest() throws Exception {
        driver.get("https://www.saucedemo.com/");
        LoginPage.setWebDriver(driver)
                .enterUserName("xerer")
                .enterPassword("secret_sauce")
                .clickLogin();

        if(LoginPage.hasLoginFailed())
        {
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(false,
                    "Wrong username/password combinations");
           softAssert.assertAll();

        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

}
