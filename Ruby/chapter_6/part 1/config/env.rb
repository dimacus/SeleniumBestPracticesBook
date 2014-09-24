require 'rubygems'
           
#Load all the fixture and helpter files into memory
base_dir = File.expand_path(File.join(File.dirname(__FILE__), ".."))
helpers_dir  = File.join(base_dir, "helpers")
fixtures_dir  = File.join(base_dir, "fixtures")
$LOAD_PATH.unshift(helpers_dir)
$LOAD_PATH.unshift(fixtures_dir)
require 'selenium_wrapper'
require 'test_data'


#Supresses some I18n deprication warnings, not nessery
I18n.enforce_available_locales = false 


#Use Test::Unit assertions instead of Rsepec shoulds
require 'test/unit/assertions'
World(Test::Unit::Assertions)
