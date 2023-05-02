@DDT
Feature: Login with DDT with excel

  @regression
  Scenario Outline: Data driven testing with excel
    Given user launches the browser
    And open URL "https://demo.opencart.com/"
    When navigates to MyAccount menu
    And click on login
    Then check user navigates to Myaccount Page  by passing Email and Pssword with excel row "<row_index>"

    Examples: 
      |row_index|
      |1|
      |2|
      |3|
      |4|
      |5|