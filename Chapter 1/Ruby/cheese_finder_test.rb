require 'rubygems'
require 'selenium-webdriver'
require 'test/unit'

class CheeseFinderTests < Test::Unit::TestCase

   def test_find_some_cheese
     selenium = Selenium::WebDriver.for(:firefox)     
     selenium.get("http://awful-valentine.com/")
     selenium.find_element(:id, "searchinput").clear
     selenium.find_element(:id, "searchinput").send_keys("cheese")
     selenium.find_element(:id, "searchsubmit").click  
     assert(selenium.find_element(:class, "entry").text.include?("No Results Found"))
     selenium.quit
   end
   
end