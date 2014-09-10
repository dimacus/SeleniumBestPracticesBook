class SpecialItem
   def initialize(element, selenium)
      @element = element
      @selenium = selenium
   end
   
   def add_to_cart
     @element.find_element(:class, "add-to-cart").click  
     @selenium.find_element(:id, "fancybox-outer").find_element(:class, "purAddToCart").click
     ShoppingCartPage.new(@selenium)
   end        
end
