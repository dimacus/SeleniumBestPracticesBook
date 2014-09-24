When(/^they add the item to their cart$/) do
  @selenium.click("single-addtocart", :class)
  @selenium.click("addToCart_3", :id)
end

Then(/^will see "(.*?)" in the grand total section$/) do |price|
  assert_equal(price, @selenium.get_inner_text("grand-total-amount", :class))
end
                                                        
Then(/^they will see a cart summary with "(.*?)"$/) do |cart_summary|
  assert_equal(cart_summary, @selenium.get_inner_text("Cart66WidgetCartEmptyAdvanced", :id))
end

