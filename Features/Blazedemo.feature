
@tag
Feature: feature


  @tag1
  Scenario: blazedemo
    Given user launches the browser
    And open URL "https://blazedemo.com/index.php"
    When user navigates to home page check the title
    And click on hyperlink 
    And user navigates to new tab and check the url has string vacation
    And user navigates to home page tab
    And select 'Mexico City' in departure city
    And select 'London' in destination city
    And click on FindFlights
    And select the flight with lowest price by clicking on choose the flight
    And user navigates to purchase page
   # And check the total cost
    And check the price available
    And click on purchase flight button
    Then user navigates to purchase confirmation page
    And store id in the console
    
   


