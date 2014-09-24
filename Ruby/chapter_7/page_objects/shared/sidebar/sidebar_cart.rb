class SidebarCart
  def initialize(selenium)
    @selenium = selenium
  end 
  
  def summary
    @selenium.find_element(:id, "Cart66WidgetCartEmptyAdvanced").text
  end
  
  def subtotal
     @selenium.find_element(:class, "Cart66Subtotal").text
  end     
end                                           