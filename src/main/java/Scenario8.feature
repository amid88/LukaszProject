Feature: Scenario8
  Scenario: Create an account, complete the shopping process, write the receipt to another file.
    Given User open automationpractice page
    When Open the Sign in section
    And Create an account with data provided in the test file
    And Enter the Women category
    And Scroll down by "500"
    And User add first item to cart Type: 2
    And Proceed to checkout
    And Complete the shopping process
    Then Write the products and prices to another file