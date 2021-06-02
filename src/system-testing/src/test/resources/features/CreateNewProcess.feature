@malta
Feature: Create a new process

  Background:
    Given user should be in home page
    And user click in button "btn-novo"
    And fill select field with value "S"
    And fill option field with value "S"
    And fill field "processo_data_entrada" with value "04/07/2020"
    And fill field "processo_status" with value "status_999"

  Scenario Outline: user want to register a new process without required fields
    And fill field "processo_vara" with value "<VARA>"
    And fill field "processo_numero_processo" with value "<NUM_PROCESSO>"
    And fill field "processo_natureza" with value "<NATUREZA>"
    And fill field "processo_partes" with value "<PARTE>"
    When user click in button "btn-save"
    Then user should see the alert  "<RESULT>"
    Examples:
      | VARA     | NUM_PROCESSO | NATUREZA     | PARTE     | RESULT                                         |
      | vara_789 |              | natureza_789 | parte_789 | Numero processo não pode ser deixado em branco |
      |          | numero_79    | natureza_789 | parte_789 | Vara não pode ser deixado em branco            |
      | vara_789 | numero_79    |              | parte_789 | Natureza não pode ser deixado em branco        |

    Scenario: user want to register a new process
      And fill field "processo_vara" with value "vara_789"
      And fill field "processo_numero_processo" with value "processo_789"
      And fill field "processo_natureza" with value "natureza_789"
      And fill field "processo_partes" with value "parte_789"
      When user click in button "btn-save"
      Then user should see the message "Processo foi criado com sucesso."
