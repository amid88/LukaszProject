Feature: Scenario7
  Scenario: Create an account and confirm that you can log in with the newly created account
    Given User open automationpractice page
    When Open the Sign in section
    And Create an account
    And Fill all fields on the form
    And Confirm the account creation
    And Logout
    Then Confirm that you can log in with the newly created account