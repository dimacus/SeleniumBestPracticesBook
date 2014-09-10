require File.expand_path(File.join(File.dirname(__FILE__), "page_objects", "requires"))

class ShoppingCartOnContactUsPageTest < Test::Unit::TestCase

  def setup  
    @selenium = Selenium::WebDriver.for(:firefox)    
  end
  
  def teardown
     @selenium.quit
  end  
  
  def test_cart_on_contact_page    
    @selenium.get "http://awful-valentine.com/"
    
    page = HomePage.new(@selenium)  
    page.special_items.first.add_to_cart
    
    @selenium.get "http://awful-valentine.com/contact-us"
    page = ContactUsPage.new(@selenium)
    assert_equal("You have 1 item ($5.77) in your shopping cart.", 
                  page.sidebar.cart.summary)
    assert_equal("$5.77", page.sidebar.cart.subtotal)
  end
  
end