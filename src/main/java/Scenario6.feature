Feature: Scenario6
  Scenario: Log the names and prices of all displayed products to console, and to a txt file.
    Given User open automationpractice page
    When Open the Bestsellers section -clothes-
    And Log the names and prices of all displayed products to console, and to a txt file
    And Scroll down by "700"
    Then Capture a screenshot
