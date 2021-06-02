@processTest
Feature: Create a new process

  Background: User already have access to http://agapito-server.herokuapp.com

  Scenario: User must create a new process to delete later
    Given User already in new process page
    And User fill field vara with value "vara:999"
    And User fill field numero_processo with value "numero_processo:999"
    And User fill field natureza with value "natureza:999"
    And User fill field partes with value "partes:999"
    And User fill field urgente with value "N"
    And User fill field arbitramento with value "N"
    And User fill field assistencia_social with value "assistencia_social:999"
    And User fill field data_entrada with value "06-06-2020"
    And User fill field status with value "status:999"
    And User click on save button
    Then User should see status code 201

  Scenario: User want delete the previously created process
    Given User already has the process id previously created
    And User click on button delete
    Then User should see status code 204

  Scenario: User want check if the entity was deleted
    Given User already has the process id previously created
    When User click on search button
    Then User should see status code 404