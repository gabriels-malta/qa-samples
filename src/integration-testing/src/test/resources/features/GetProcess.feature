@processTest
Feature: Get all process

  Background: User already have access to http://agapito-server.herokuapp.com

  Scenario: User want to list all process
    Given User click on list all process button
    Then User should see status code 200

  Scenario Outline: User want to get a specific process
    Given User look for a single process
    When User enter id as "<processId>"
    And User click on search button
    Then User should see status code <number>
    Examples:
      | processId | number |
      | 905       | 200    |
      | 789789    | 404    |
