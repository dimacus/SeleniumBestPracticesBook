Given(/^I am on the purchase page$/) do
  @selenium.get(TestData.get_base_url + "/purchase-forms/perfect-world")
end

Given(/^I submit valid values on the purchase form$/) do
  @selenium.type_text(TestData.get_full_name, "name", :id)
  @selenium.type_text(TestData.get_credit_card_number, "cc", :id)
  @selenium.type_text(TestData.get_credit_card_expiry_date.month, "month", :id)
  @selenium.type_text(TestData.get_credit_card_expiry_date.year, "year", :id)
  
  @selenium.click("go", :id)
end

Then(/^I should have a successful purchase transaction$/) do
  assert_equal("Purchase complete!", @selenium.get_inner_text("success", :id))
end