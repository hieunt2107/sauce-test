Feature: Saucedemo Checkout Process

  Scenario: User adds a product to cart and completes checkout
    Given User navigates to the Saucedemo login page
    When User logs in with username "standard_user" and password "secret_sauce"
    And User adds product "Sauce Labs Backpack" to the cart
    Then The "Add to cart" button should change to "Remove"
    And The cart badge count should be "1"
    When User navigates to the cart page
    Then Product "Sauce Labs Backpack" should be displayed with correct details
    When User clicks Checkout and fills in the required information
    And User completes the checkout process
    Then "Thank you for your order!" message should be displayed