@phones
Feature: phone and pdas

  @sanity
  Scenario: phones & pdas
    Given user launches the browser
    And open URL "https://demo.opencart.com/"
    When user navigates to Phones & PDAs menu
    And choose "Rating (Highest)" by clicking on Sort By dropdown
    Then it will show Highest rating mobiles accordingly
