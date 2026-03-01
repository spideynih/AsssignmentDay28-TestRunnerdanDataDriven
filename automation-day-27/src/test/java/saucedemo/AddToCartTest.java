package saucedemo;

import core.BaseTest;
import core.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.saucedemo.CartPage;
import org.example.saucedemo.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(AddToCartTest.class);

    @Test(priority = 1, description = "Test adding items to cart")
    public void testAddItemsToCart() {
        log.info("========== Starting AddToCartTest - Add Items ==========");


        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("standardUser"), config.getProperty("password"));

        CartPage cartPage = new CartPage(DriverManager.getDriver());


        String backpack = "Sauce Labs Backpack";
        cartPage.addItemToCart(backpack);
        Assert.assertTrue(cartPage.isItemInCart(backpack), backpack + " should be in the cart");
        log.info("Verified '{}' is in the cart", backpack);


        String jacket = "Sauce Labs Fleece Jacket";
        cartPage.addItemToCart(jacket);
        Assert.assertTrue(cartPage.isItemInCart(jacket), jacket + " should be in the cart");
        log.info("Verified '{}' is in the cart", jacket);

        log.info("========== AddToCartTest - Add Items Completed ==========");
    }

}