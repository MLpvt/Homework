Feature: Test login page

 Scenario: Test available hotels in Moscow
 Given I am on main application page
 When I fill city "Москва" in searchline 
 And I click "Проверить цены" button
 And I set dates
 Then Page with available options is opened
 
  Scenario: Test hotel with top rating
 Given I am on main application page
 When I search hotels in Moscow
 And I filter hotels by rating
 And I open top-rated hotel
 Then Rating of hotel is higher than 9

 
   