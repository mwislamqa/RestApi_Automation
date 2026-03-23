
Feature: User Login API

  Scenario: Successful login with valid credentials
    Given the login API endpoint is available
    When I send a POST request with valid username and password
    Then the response status code should be 200
