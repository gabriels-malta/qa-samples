@processTest
Feature: Update an existing process

  Background: User already have access to http://agapito-server.herokuapp.com

  Scenario: User must create a new process to update later
    Given User already in new process page
    And User fill field vara with value "vara:789"
    And User fill field numero_processo with value "numero_processo:789"
    And User fill field natureza with value "natureza:789"
    And User fill field partes with value "partes:789"
    And User fill field urgente with value "N"
    And User fill field arbitramento with value "N"
    And User fill field assistencia_social with value "assistencia_social:789"
    And User fill field data_entrada with value "06-06-2020"
    And User fill field status with value "status:789"
    And User click on save button
    Then User should see status code 201

  Scenario: User want to update the social assistance
    Given User already has the process id previously created
    And User fill field vara with value "ATUALIZADO:789"
    And User fill field numero_processo with value "ATUALIZADO:789"
    And User fill field natureza with value "ATUALIZADO:789"
    And User fill field partes with value "ATUALIZADO:789"
    And User fill field urgente with value "S"
    And User fill field arbitramento with value "S"
    And User fill field assistencia_social with value "ATUALIZADO"
    And User fill field data_entrada with value "06-06-2020"
    And User fill field status with value "ATUALIZADO:789"
    And User click on button save update
    Then User should see status code 200

  Scenario: User want check updated value
    Given User already has the process id previously created
    When User click on search button
    Then Response should contain "ATUALIZADO:789" as field vara value