class HomePage < Page  
  def page_path
    "/"
  end
  
  def body
    nil
  end
  
  def special_items
    @selenium.find_elements(:class, "special-item").collect do |element|
       SpecialItem.new(element, @selenium)
    end
  end
  
  def featured_item_carousel
     #Implement me
  end
  
  def recent_products
     #Implement me    
  end  
  
end           
            

