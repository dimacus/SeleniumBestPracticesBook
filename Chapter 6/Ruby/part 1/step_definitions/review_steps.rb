When(/^I create a new unique review$/) do
  @form_values = TestData.get_comment_form_values
  @form_values[:comment] << " #{Time.now.to_i}"
  @comment_id = create_a_comment(@form_values)
end

Then(/^my name should be attached to the comment$/) do  
  assert_equal(@form_values[:name], @selenium.get_inner_text("#" + @comment_id + " .comment-author-metainfo a.url"))
end

Then(/^my comment should be properly saved$/) do
  assert_equal(@form_values[:comment], @selenium.get_inner_text("#" + @comment_id + " .comment-content"))
end

Then(/^the comment date should be correct date$/) do
  date    = @selenium.get_inner_text("#" + @comment_id + " .comment-author-metainfo .commentmetadata")  
  parsed_date = DateTime.parse(date)
  assert_equal(Date.today.year, parsed_date.year)
  assert_equal(Date.today.month, parsed_date.month)
  # assert_equal(Date.today.day, parsed_date.day)
end

When(/^I try to add an identical review again$/) do
  create_a_comment(@form_values)
end

Then(/^I should see a duplicate comment error$/) do
  assert(@selenium.get_inner_text("body").include?("Duplicate comment detected"))
end 


def create_a_comment(form_info)
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
