Feature: A user must be able to login/logout

  

  Scenario: Account login

    When I get "/account/login"
    Then the status should be 200
  
  Scenario: Account logout

    When I get "/account/logout"
    Then the status should be 200