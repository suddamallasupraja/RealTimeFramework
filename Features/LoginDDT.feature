@DDT
Feature: Login with DDT

  @master
  Scenario Outline: Data driven testing
    Given user launches the browser
    And open URL "https://demo.opencart.com/"
    When navigates to MyAccount menu
    And click on login
    And user enters Email as "<Email>" and Password as "<Password>"
    And click on Login button
    Then User navigates to Myaccount Page 

    Examples: 
      | Email                   | Password   |
      | ssuprajaredd@gmail.com  | supraja@98 |
      | ssuprajareddy@gmail.com | supraja@98 |
