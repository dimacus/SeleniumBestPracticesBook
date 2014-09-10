require 'rubygems'
require 'selenium-webdriver'

selenium = Selenium::WebDriver.for(:firefox)
selenium.get("http://awful-valentine.com/")
selenium.find_element(:id, "searchinput").clear
selenium.find_element(:id, "searchinput").send_keys("cheese")
selenium.find_element(:id, "searchsubmit").click
selenium.quit