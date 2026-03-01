package org.example.saucedemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    private static final Logger log = LogManager.getLogger(CartPage.class);

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    private WebElement backpackItem;

    @FindBy(xpath = "//div[text()='Sauce Labs Fleece Jacket']")
    private WebElement jacketItem;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCart;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        log.info("Cart Page initialized");
    }

    public boolean isBackpackDisplayed() {
        return isItemDisplayed(backpackItem, "Backpack");
    }

    public boolean isJacketDisplayed() {
        return isItemDisplayed(jacketItem, "Jacket");
    }

    private boolean isItemDisplayed(WebElement element, String itemName) {
        log.info("Checking if '{}' is displayed in cart", itemName);
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            log.error("{} is not displayed: {}", itemName, e.getMessage());
            return false;
        }
    }

    public boolean isItemInCart(String itemName) {
        switch (itemName) {
            case "Sauce Labs Backpack":
                return isBackpackDisplayed();
            case "Sauce Labs Fleece Jacket":
                return isJacketDisplayed();
            default:
                log.warn("Item '{}' is not in CartPage", itemName);
                return false;
        }
    }

    public void addItemToCart(String itemName) {
        String xpath = String.format("//button[text()='Add to cart' and contains(@data-test,'%s')]",
                itemName.toLowerCase().replace(" ", "-"));
        WebElement addButton = driver.findElement(By.xpath(xpath));
        addButton.click();
        log.info("Clicked 'Add to Cart' for '{}'", itemName);
    }

    public void openShoppingCart() {
        log.info("Click Cart Icon");
        shoppingCart.click();
    }

    public CheckoutPage clickCheckout() {
        log.info("Click Checkout button");
        checkoutButton.click();
        log.info("Checkout button clicked");
        return new CheckoutPage(driver);
    }
}