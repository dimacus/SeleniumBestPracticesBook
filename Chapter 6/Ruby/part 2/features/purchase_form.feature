@mobile @api
Feature: As a user, I should be able to fill out the purchase form and successfully complete a purchase

Scenario: User fills out purchase form with valid results
  Given I am on the purchase page
  And I submit valid values on the purchase form

  Then I should have a successful purchase transaction  