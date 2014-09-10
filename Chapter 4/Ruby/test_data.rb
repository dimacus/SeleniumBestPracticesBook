require 'yaml'  
require 'net/http'
require 'json'
require 'faker'

class TestData 
  
  def self.get_full_name
    Faker::Name.name
  end
  
  def self.get_email
    Faker::Internet.email
  end
  
  def self.get_website
    Faker::Internet.url
  end
  
  def self.get_buzzword
    Faker::Company.catch_phrase
  end
  
  def self.get_comment_form_values(overwrites = {})
    {
      :name    => self.get_full_name,
      :email   => self.get_email,
      :url     => self.get_website,
      :comment => self.get_buzzword
    }.merge(overwrites)      
  end
  
     
  def self.get_product_fixtures  
    fixture_file = File.join(File.dirname(__FILE__), 'product_fixtures.yml')
    YAML.load_file(fixture_file)
  end 
  
  def self.get_products_from_api
    uri = URI.parse("http://api.awful-valentine.com")
    json_string = Net::HTTP.get(uri)
    JSON.parse(json_string)
  end 
  
  def self.get_base_url
    "http://awful-valentine.com"
  end  
  
  def self.get_environment
     ENV['environment'] || "test"
  end  
  
  def self.get_base_url
    {
      "production" => "http://awful-valentine.com/",
      "staging"    => "http://staging.awful-valentine.com/",
      "test"       => "http://test.awful-valentine.com/"
    }[self.get_environment]     
  end
  
end

