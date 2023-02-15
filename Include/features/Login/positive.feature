Feature: Login with valid data

  Scenario: user can login into apps
    Given user in hompage
    When user click toogle button menu
    And user click login menu
    And user input uername with value 'John Doe'
    And user input password with value 'ThisIsNotAPassword'
    And user click button login
    Then user in appointment page
