include HttpHelper

Given(/^I am on the purchase page$/) do
  #Do nothing, because we make an HTTP request directly against and endpoint
  #So there is no need for this step at all, but deleting it will
  #make Cucumber think that this step is undefined
end

Given(/^I submit valid values on the purchase form$/) do                               
  url = "http://api.awful-valentine.com/purchase"
  @post_data = {"name" => TestData.get_full_name, 
                "cc" => TestData.get_credit_card_number,
                "month" => TestData.get_credit_card_expiry_date.month,
                "year" => TestData.get_credit_card_expiry_date.year,
                "product_id" => 12345}
  
   @purchase_status = JSON.parse(make_post_request(url, @post_data))
end

Then(/^I should have a successful purchase transaction$/) do
  assert_equal(@post_data["name"], @purchase_status["name"])   
  assert_equal(@post_data["product_id"], @purchase_status["product"].to_i)   
  assert_equal("purchased", @purchase_status["status"])         
end

