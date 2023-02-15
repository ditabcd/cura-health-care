Feature: Login with invalid data

  Scenario: user can login into apps
    Given user in hompage
    When user click toogle button menu
    And user click login menu
    And user input uername with value 'John Doex'
    And user input password with value 'xThisIsNotAPassword'
    And user click button login
    Then user can see error message 'Login failed! Please ensure the username and password are valid.'
