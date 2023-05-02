
@tag
Feature: jdbc
 

  @jdbc
  Scenario: jdbc connectivity
    Given user launches the browser
    And open URL "https://demo.opencart.com/"
    When navigates to MyAccount menu
    And click on login
    Then execute query "Insert INTO Employee (emp_id,emp_dept) values(10,100)"
    
    
