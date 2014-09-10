require 'rubygems'
require 'selenium-webdriver'
require 'test/unit'   
require File.join(File.dirname(__FILE__), 'test_data')

class ProductValidationTests < Test::Unit::TestCase  
  def setup  
    require 'debug'
    @selenium = Selenium::WebDriver.for(:firefox)         
  end

  def teardown
     @selenium.quit
  end

  def test_all_products_with_fixtures     
     TestData.get_product_fixtures.values.each do | product_info |
       @selenium.get(TestData.get_base_url + product_info["url"])        
       verify_product_info(product_info)     
     end    
  end
  
  def test_all_products_with_api_response      
    TestData.get_products_from_api.each do |product_info|
       @selenium.get(TestData.get_base_url + product_info["url"])          
       verify_product_info(product_info)
    end                              
  end            
 
  private
  
  def verify_product_info(product_info)
     failure_info = "Product Name: #{product_info['name']} \nPermalink #{product_info['url']}\n"
     assert_equal(product_info["name"], get_product_title, failure_info)  
     assert_equal("#{TestData.get_base_url + product_info["url"].gsub(/^\//, "")}/", get_current_url, failure_info)
     assert_equal(product_info["description"], get_product_description, failure_info)
     assert_equal(product_info["price"].to_s, get_product_price, failure_info)
  end
  
  def get_product_title
    @selenium.find_element(:class, "category-title").text 
  end 
  
  def get_product_description
    @selenium.find_element(:id, "main-products").find_element(:class, "content").text
  end 
  
  def get_product_price
    @selenium.find_element(:class, "price-tag").text.gsub(/[\n\$]/, "")
  end
  
  def get_current_url
    @selenium.current_url
  end
   
end
