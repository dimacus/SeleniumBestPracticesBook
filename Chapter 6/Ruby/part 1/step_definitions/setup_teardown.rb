Before do
   @selenium = SeleniumWrapper.new
end

After do
  @selenium.quit
end


