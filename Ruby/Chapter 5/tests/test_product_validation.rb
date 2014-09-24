
class ProductValidationTests < Test::Unit::TestCase  
  def setup  
    @selenium = SeleniumWrapper.new         
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
     assert_equal("#{TestData.get_base_url + product_info["url"].gsub(/^\//, "")}/", @selenium.current_url, failure_info)
     assert_equal(product_info["description"], get_product_description, failure_info)
     assert_equal(product_info["price"].to_s, get_product_price, failure_info)
  end
  
  def get_product_title
    @selenium.get_inner_text("category-title", :class)
  end 
  
  def get_product_description
    @selenium.get_inner_text("#main-products .content", :css)
  end 
  
  def get_product_price
    @selenium.get_inner_text("price-tag", :class).gsub(/[\n\$]/, "")
  end
     
end
