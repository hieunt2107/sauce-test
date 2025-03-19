package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class SaucedemoSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().driverVersion("134.0.6998.89").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Given("User navigates to the Saucedemo login page")
    public void userNavigatesToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("User logs in with username {string} and password {string}")
    public void userLogsIn(String username, String password) {
        loginPage.login(username, password);
    }

    @When("User adds product {string} to the cart")
    public void userAddsProductToCart(String productName) {
        inventoryPage.addProductToCart(productName);
    }

    @Then("The {string} button should change to {string}")
    public void verifyButtonChange(String before, String after) {
        Assert.assertTrue(inventoryPage.isButtonChanged(after));
    }

    @Then("The cart badge count should be {string}")
    public void verifyCartBadge(String count) {
        Assert.assertEquals(count, inventoryPage.getCartBadgeCount());
    }

    @When("User navigates to the cart page")
    public void userNavigatesToCartPage() {
        cartPage.goToCart();
    }

    @Then("Product {string} should be displayed with correct details")
    public void productShouldBeDisplayedWithCorrectDetails(String productName) {
        Assert.assertTrue(cartPage.isProductDisplayed(productName));
    }

    @When("User clicks Checkout and fills in the required information")
    public void userClicksCheckoutAndFillsInformation() {
        cartPage.clickCheckout();
        checkoutPage.fillCheckoutInfo("John", "Doe", "12345");
    }

    @When("User completes the checkout process")
    public void userCompletesCheckoutProcess() {
        checkoutPage.completeCheckout();
    }

    @Then("{string} message should be displayed")
    public void verifyCheckoutMessage(String message) {
        Assert.assertEquals(message, checkoutPage.getCheckoutMessage());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
