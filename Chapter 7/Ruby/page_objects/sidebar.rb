class Sidebar  
  def initialize(selenium)
    @selenium = selenium
  end
   
  def cart
    SidebarCart.new(@selenium)
  end
  
  def advertisement
     #Implement getter for 
     #the ad section
     #if you want to test it     
  end  
end