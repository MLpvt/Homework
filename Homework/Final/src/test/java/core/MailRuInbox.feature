Feature: Test login page

  Scenario: Test sending message
  Given I am logged into application
  When I click "Написать Письмо" button
  And I fill up letter 
  And I click "Отправить" button
  Then Letter is sent
 
  Scenario: Test deleting message
  Given I am logged into application
  When I delete letter
 Then Success Message is displayed
 
 
  Scenario: Test clearing rubish bin
  Given I am logged into application
  When I clear "Корзина" folder
  Then Rubish bin is empty
 
  Scenario: Test add message to spam
  Given I am logged into application
  When I add letter to spam
  Then Success Message is displayed
 
 Scenario: Test remove message from spam
 Given I am logged into application
 When I remove message from spam
 Then Success Message is displayed
 
  Scenario: Test mark message with flag
  Given I am logged into application
  When I mark letter with flag
  Then Message is marked with flag
 
  Scenario: Test unmark message with flag
  Given I am logged into application
  When I unflag letter
  Then Message is unmarked with flag
 

 
   