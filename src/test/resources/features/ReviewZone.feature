Feature: Test login for reviewzone.ai

  @RZ-Login
  Scenario Outline: Test login with one user
    Given User launches new Browser
    And User navigates to "https://reviewzone.ai/"
    And User logs in with "<userId>"
    Then User validates if the title of the page is "ReviewZone"
    Examples:
      | userId |
      | kk@mail.com|
      | nn@mail.com|