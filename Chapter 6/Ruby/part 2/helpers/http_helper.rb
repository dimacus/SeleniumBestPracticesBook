module HttpHelper

  def make_post_request(url, post_data)
    uri = URI.parse(url)          
    http = Net::HTTP.new(uri.host, uri.port) 
    http.open_timeout= 120
    http.read_timeout = 120
    http.continue_timeout= 120

    request = Net::HTTP::Post.new(uri.request_uri)
    request.set_form_data(post_data)

     http.request(request).body    
  end
  
end   

               
