@malta
  Feature: View detailed info about a process

    Background:
      Given user should be in home page

      Scenario: user want to see a specific process
        Given user are in the home page
        When user click in button "btn-show_1795"
        Then user should see the "span#codigo" equal "1795"