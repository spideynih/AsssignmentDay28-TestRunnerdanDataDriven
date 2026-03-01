package org.example.saucedemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    private static final Logger log = LogManager.getLogger(InventoryPage.class);

    @FindBy(id = "react-burger-menu-btn")
    private WebElement hamburgerMenu;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCart;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addSauceLabsBackpack;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeSauceLabsBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addSauceLabsJacket;

    public InventoryPage(WebDriver driver) {
        super(driver);
        log.info("Inventory Page initialized");
    }

    public void addBackpackToCart(){
        log.info("Add Sauce Labs Backpack to cart");
        addSauceLabsBackpack.click();
    }

    public void removeBackpackFromCart() {
        log.info("Removing Sauce Labs Backpack from cart");
        removeSauceLabsBackpack.click();
    }

    public void addJacketToCart(){
        log.info("Add Sauce Labs Jacket to cart");
        addSauceLabsJacket.click();
    }

    public void openShoppingCart() {
        log.info("Opening shopping cart");
        shoppingCart.click();
    }





}
