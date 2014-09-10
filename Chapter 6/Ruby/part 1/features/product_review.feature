Feature: A product page should be able to accept user generated reviews.

Background:
  Given I am on a product page


Scenario: Adding new comment
  When I create a new unique review
  
  Then my name should be attached to the comment
  And my comment should be properly saved
  And the comment date should be correct date

Scenario: Adding a duplicate comment should be rejected
  When I create a new unique review
  And I try to add an identical review again
  
  Then I should see a duplicate comment error