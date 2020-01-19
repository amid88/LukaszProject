Feature: Scenario2
  Scenario: Verify, that the automationpractice.com website can be found using google search engine.
    Given User open google page
    When User searching in google: automationpractice
    And User check that the automationpractice website can be found using google search engine
    And Enter the automationpractice website through google search results
    And Enter the Women category
    Then Verify that subcategory is available: Tops
    Then Verify that subcategory is available: Dresses