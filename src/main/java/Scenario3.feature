Feature: Scenario3
  Scenario: Verify that the item price and total price are correctly displayed.
    Given User open automationpractice page
    When Scroll down by "500"
    When User add first item to cart Type: 1
    Then Item price and total price are correctly displayed