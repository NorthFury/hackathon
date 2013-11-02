Feature: Get task for a user

  

  Scenario: Get task for a user

    When I get "/account/myuser/task/1"
    Then the status should be 200
    