@malta
  Feature: Edit process data

    Background:
      Given user should be in home page
      And user are in the home page
      When user click in button "btn-show_1795"

    Scenario: user want to see a specific process
      Given user click in edit button
      When fill field "processo_observacao" with value "value updated by automated teste"
      And user click in button "btn-save"
      Then user should see the message "Processo atualizado com sucesso."