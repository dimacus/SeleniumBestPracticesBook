Then(/^my name should be attached to the comment$/) do  
  @review =  @selenium.find_elements(".comment").last
  assert_equal(@form_values[:name], @review.find_element(:css, ".comment-author").text)
end

Then(/^my comment should be properly saved$/) do
  assert_equal(@form_values[:comment], @review.find_element(:css, ".comment-body").text)
end

Then(/^the comment date should be correct date$/) do
  date    = @review.find_element(:css, ".comment-time").text  
  parsed_date = DateTime.parse(date)
  assert_equal(Date.today.year, parsed_date.year)
  assert_equal(Date.today.month, parsed_date.month)
  assert_equal(Date.today.day, parsed_date.day)  
end         

def fill_out_comment_form(form_info)
  @selenium.type_text(form_info[:name], "author", :id)
  @selenium.type_text(form_info[:email], "email", :id)
  @selenium.type_text(form_info[:website], "url", :id)
  @selenium.type_text(form_info[:comment], "comment", :id)
  @selenium.click("submit", :id)
end

