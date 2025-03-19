package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String productName) {
        String xpath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button";
        driver.findElement(By.xpath(xpath)).click();
    }

    public boolean isButtonChanged(String newLabel) {
        String xpath = "//button[text()='" + newLabel + "']";
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

    public String getCartBadgeCount() {
        return driver.findElement(By.className("shopping_cart_badge")).getText();
    }
}
