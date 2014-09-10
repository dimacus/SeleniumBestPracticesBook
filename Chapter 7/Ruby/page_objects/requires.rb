require 'rubygems'
require 'rspec'
require 'cucumber'
require 'test/unit'
require 'selenium-webdriver'
require 'nokogiri'

require File.expand_path(File.join(File.dirname(__FILE__), "shared" , "page"))

require File.expand_path(File.join(File.dirname(__FILE__), "home_page", "home_page"))
require File.expand_path(File.join(File.dirname(__FILE__), "home_page", "special_item"))

require File.expand_path(File.join(File.dirname(__FILE__), "contact_us_page", "contact_us_page"))
require File.expand_path(File.join(File.dirname(__FILE__), "shared", "sidebar", "sidebar"))
require File.expand_path(File.join(File.dirname(__FILE__), "shared", "sidebar", "sidebar_cart"))

