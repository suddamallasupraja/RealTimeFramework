@Login
Feature: Login feature


  @sanity
  Scenario: Testing with valid credentials
    Given user launches the browser
    And open URL "https://demo.opencart.com/"
    When navigates to MyAccount menu
    And click on login
    And user enters Email as "ssuprajareddy@gmail.com" and Password as "supraja@98"
    And click on Login button
    Then User navigates to Myaccount Page 
    



