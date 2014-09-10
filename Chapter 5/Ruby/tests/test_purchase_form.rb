
class PurchaseFormTests < Test::Unit::TestCase
   def setup      
     @selenium = SeleniumWrapper.new
   end 
   
   def teardown
      @selenium.quit
   end
   
   def test_fillout_purchase_form
     @selenium.get(TestData.get_base_url + "/purchase-forms/3rd-party-links")
     
     @selenium.type_text(TestData.get_full_name, "name", :id)
     @selenium.type_text(TestData.get_credit_card_number, "cc", :id)
     @selenium.type_text(TestData.get_credit_card_expiry_date.month, "month", :id)
     @selenium.type_text(TestData.get_credit_card_expiry_date.year, "year", :id) 

     @selenium.click("go", :id)
     assert_equal("Purchase complete!", @selenium.get_inner_text("success", :id))     
   end                   
end