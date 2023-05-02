@tag
Feature: Title of your feature
 

  @tag1
  Scenario:pagination
    Given user launches the browser
    And open URL "https://demo.opencart.com/admin/index.php"
    When user enters the username as "demo" and password as "demo"
    And clicks on login button
    And user navigates to dashboard page
    And user navigates to customers
    And click on customers
    Then user enters to customers page
    And click on all avaliable pages in the table
    
