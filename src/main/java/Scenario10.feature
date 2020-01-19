Feature: Scenario10
  Scenario: Download all “thumbs” images of the opened product
    Given User open automationpractice page
    When  Scroll down by "500"
    And Open the Quick View of any product from the list
    And Download all thumbs images of the opened product
    Then Log the number of downloaded images
