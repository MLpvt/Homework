Feature: Test login page

 Scenario: Test login with valid credentials
 Given I am on main application page
 When I login as correct user
 Then I see logout link
 
 Scenario: Test login with invalid credentials
 Given I am on main application page
 When I login as incorrect user
 Then I see error message
 
  Scenario: Test login without login and password
 Given I am on main application page
 When I login without credentials
 Then I see error message

 
   