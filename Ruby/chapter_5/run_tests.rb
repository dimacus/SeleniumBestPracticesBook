base_dir = File.expand_path(File.join(File.dirname(__FILE__)))
helpers_dir  = File.join(base_dir, "helpers")
fixtures_dir  = File.join(base_dir, "fixtures")
test_dir = File.join(base_dir, "tests")

$LOAD_PATH.unshift(helpers_dir)
$LOAD_PATH.unshift(fixtures_dir)

require 'rubygems'
require 'test/unit'
require 'selenium_wrapper'
require 'test_data'
                  

I18n.enforce_available_locales = false #Supresses some I18n deprication warnings, not nessery

exit Test::Unit::AutoRunner.run(true, test_dir)                  


