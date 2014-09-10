require 'rubygems'
require 'selenium-webdriver'        
require File.expand_path(File.join(File.dirname(__FILE__), "requires"))

Given(/^I am on the home page$/) do
  @selenium = Selenium::WebDriver.for(:firefox)
  @selenium.get "http://awful-valentine.com/"
end

Given(/^I add first special offers item to the cart$/) do
  page = HomePage.new(@selenium)
  page.special_items.first.add_to_cart    
end

Given(/^I navigate to Contact Us Page$/) do
  @selenium.get "http://awful-valentine.com/contact-us"  
end

Then(/^the shopping cart should have correct information$/) do
  page = ContactUsPage.new(@selenium)  
  expect(page.sidebar.cart.summary).to eq("You have 1 item ($5.77) in your shopping cart.")
  expect(page.sidebar.cart.subtotal).to eq("$5.77")
  @selenium.quit
end