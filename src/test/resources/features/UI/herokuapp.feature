@UITests
Feature: perform basic selenium operation in http://the-internet.herokuapp.com/

  Scenario: perform basic auth
    Given I goto URL http://the-internet.herokuapp.com/
    When I make a get call
    Then the status code is 200

  Scenario: Get particular employee details and verify
    Given I set the URL http://dummy.restapiexample.com/api/v1/employee/17
    When I make a get call
    Then the status code is 200
    And response includes the following
    | data.id		        | 17		  |
    | data.employee_name 	| Paul Byrd   |
    | data.employee_age	    | 64	      |
    | data.profile_image    |             |