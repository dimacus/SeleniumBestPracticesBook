Feature: users can add products to their shopping cart.

Scenario: Anonymous user adds product to the cart
  Given I am on a product page	
  When they add the item to their cart

  Then will see "$68.99" in the grand total section
  Then they will see a cart summary with "You have 1 item ($68.99) in your shopping cart."