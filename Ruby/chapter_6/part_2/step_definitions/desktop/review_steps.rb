Then(/^my name should be attached to the comment$/) do  
  assert_equal(@form_values[:name], 
               @selenium.get_inner_text("#" + @comment_id + " .comment-author-metainfo a.url"))
end

Then(/^my comment should be properly saved$/) do
  assert_equal(@form_values[:comment], @selenium.get_inner_text("#" + @comment_id + " .comment-content"))
end

Then(/^the comment date should be correct date$/) do
  date    = @selenium.get_inner_text("#" + @comment_id + " .comment-author-metainfo .commentmetadata")  
  parsed_date = DateTime.parse(date)
  assert_equal(Date.today.year, parsed_date.year)
  assert_equal(Date.today.month, parsed_date.month)
  assert_equal(Date.today.day, parsed_date.day)
end

