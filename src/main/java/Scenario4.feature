Feature: Scenario4
  Scenario: User verify that + and - buttons work for changing item quantity
    Given User open automationpractice page
    When Scroll down by "500"
    And User add first item to cart Type: 1
    And Proceed to checkout
    Then On the summary page, user verify that buttons work for changing item quantity