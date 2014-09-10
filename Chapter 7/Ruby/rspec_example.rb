require File.expand_path(File.join(File.dirname(__FILE__), "page_objects", "requires"))

describe "Sidebar Shopping cart" do  
  context "contact us page" do
    
    before(:all) do
       @selenium = Selenium::WebDriver.for(:firefox)
    end
    
    after(:all) do
      @selenium.quit
    end
    
    it "should have correct subtotal and summary" do
      @selenium.get "http://awful-valentine.com/"

      page = HomePage.new(@selenium)
      page.special_items.first.add_to_cart
      @selenium.get "http://awful-valentine.com/contact-us"

      page = ContactUsPage.new(@selenium)  
      expect(page.sidebar.cart.summary).to eq("You have 1 item ($5.77) in your shopping cart.")
      expect(page.sidebar.cart.subtotal).to eq("$5.77")
    end      
  end     
end 

 