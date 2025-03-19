package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    public boolean isProductDisplayed(String productName) {
        String xpath = "//div[text()='" + productName + "']";
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

    public void clickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }
}
