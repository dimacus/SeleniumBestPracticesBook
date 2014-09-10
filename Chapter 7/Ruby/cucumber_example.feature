Feature: sidebar cart should display correct information on all pages.


Scenario: User adds checks sidebar cart on contact us page
  Given I am on the home page
  And I add first special offers item to the cart

  And I navigate to Contact Us Page
  Then the shopping cart should have correct information
  

