When(/^I create a new unique review$/) do
  @form_values = TestData.get_comment_form_values
  @form_values[:comment] << " #{Time.now.to_i}"
  @comment_id = create_a_review(@form_values)
end


When(/^I try to add an identical review again$/) do
  create_a_review(@form_values)
end

Then(/^I should see a duplicate comment error$/) do
  assert(@selenium.get_inner_text("body").include?("Duplicate comment detected"))
end 


def create_a_review(form_info)
   fill_out_comment_form(form_info)     
   sleep 10                             
   @selenium.current_url.split("#").last
end      

def fill_out_comment_form(form_info)
  @selenium.type_text(form_info[:name], "author", :id)
  @selenium.type_text(form_info[:email], "email", :id)
  @selenium.type_text(form_info[:website], "url", :id)
  @selenium.click("a[title='5']")
  @selenium.type_text(form_info[:comment], "comment", :id)
  @selenium.click("submit", :id)
end
