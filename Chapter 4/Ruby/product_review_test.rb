require 'rubygems'
require 'selenium-webdriver'
require 'test/unit'
require File.join(File.dirname(__FILE__), 'test_data')

I18n.enforce_available_locales = false

class ProductReview < Test::Unit::TestCase
   
   def setup
     @product_permalink = TestData.get_product_fixtures["fixture_4"]["url"]
     @selenium = Selenium::WebDriver.for(:firefox)
   end
  
   def teardown
     @selenium.quit
   end     
  
   def test_add_new_review  
     review_form_info = TestData.get_comment_form_values({:name => "Dima"})
     review_id = generate_new_product_review(review_form_info)  
                                    
     review = @selenium.find_element(:id, review_id)           
     
     name = review.find_element(:class, "comment-author-metainfo").find_element(:class, "url").text     
     comment = review.find_element(:class, "comment-content").text     

     assert_equal("Dima", name)      
     assert_equal(review_form_info[:comment], comment)
     
     parsed_date = DateTime.parse(review.find_element(:class, "comment-author-metainfo").find_element(:class, "commentmetadata").text)
     assert_equal(Date.today.year, parsed_date.year)
     assert_equal(Date.today.month, parsed_date.month)
     assert_equal(Date.today.day, parsed_date.day)               
   end
   
   def test_adding_a_duplicate_review
     review_form_info = TestData.get_comment_form_values
     generate_new_product_review(review_form_info)
     sleep 10
     generate_new_product_review(review_form_info)
     error = @selenium.find_element(:id, "error-page").text
     assert_equal("Duplicate comment detected; it looks as though you\u2019ve already said that!", error)      
   end          

   private  
   
   def find_element(element, strategy=:css) 
     @selenium.find_element(strategy, element)
   end
   
   def type_text(text, element, strategy=:css)
      find_element(element, strategy).send_keys(text)
   end
   
   def click(element, strategy=:css)
      find_element(element, strategy).click
   end
   
   def select_desired_product_on_homepage(permalink) 
     click(".special-item a[href*='#{permalink}'].more-info")
   end
   
   def generate_new_product_review(review)
      navigate_to_homepage
      select_desired_product_on_homepage(@product_permalink)
      fill_out_comment_form(review)
      get_newly_created_review_id
   end   
   
   def fill_out_comment_form(form_info) 
      type_text(form_info[:name], "author", :id)
      type_text(form_info[:email], "email", :id)
      type_text(form_info[:url], "url", :id)
      click("a[title='5']")
      find_element("comment", :id).clear
      type_text(form_info[:comment], "comment", :id)
      click("submit", :id)
   end 
   
   def navigate_to_homepage
    @selenium.get(TestData.get_base_url)     
   end
   
   def generate_unique_comment
      "This is a comment for product and is for #{Time.now.to_i}"
   end 
   
   def get_newly_created_review_id
     @selenium.current_url.split("#").last
   end   
end

