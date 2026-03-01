package saucedemo;

import core.BaseTest;
import core.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.saucedemo.CartPage;
import org.example.saucedemo.CheckoutPage;
import org.example.saucedemo.LoginPage;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(CheckoutTest.class);

    @Test(description = "Test checkout item")
    public void testCheckout() {

        log.info("========== Starting CheckoutTest ==========");

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("standardUser"),
                config.getProperty("password"));

        CartPage cartPage = new CartPage(DriverManager.getDriver());

        cartPage.addItemToCart("Sauce Labs Backpack");
        cartPage.addItemToCart("Sauce Labs Fleece Jacket");

        cartPage.openShoppingCart();


        CheckoutPage checkoutPage = cartPage.clickCheckout();

        checkoutPage.fillCheckoutInformation("Adinda", "Nimas", "12345");

        log.info("========== CheckoutTest Completed ==========");
    }
}