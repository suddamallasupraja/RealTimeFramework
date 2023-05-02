@tag
Feature: pages
 

  @tag1
  Scenario: desktops
    Given user launches the browser
    And open URL "https://demo.opencart.com/"
    When user navigates to Desktops menu
    And click on Show All Desktops
    Then user navigates to Desktops page
    And click on all available pages
    
    
