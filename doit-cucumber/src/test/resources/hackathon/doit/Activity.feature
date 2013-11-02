Feature: Get activity

  

  Scenario: Get activity

    When I get "/activities"
    Then the status should be 200