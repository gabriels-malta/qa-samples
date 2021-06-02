@malta
  Feature: Delete s specific process

    Scenario: user must delete a process
      Given user should be in home page
      When user click in first delete button
      And user answer yes in the confirm box
      Then home page should reload