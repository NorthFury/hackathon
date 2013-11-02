Feature: Get achievement

  

  Scenario: Get achievement

    When I get "/achievements"
    Then the status should be 200