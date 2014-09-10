SeleniumBestPracticesBook
=========================

              

## Running Tests With Ruby

To run our Selenium tests with Ruby programming language, we will first need to install several dependent components. We will start by installing "bundler," which is a very good project dependency manager.

To install bundler, run the following command in your terminal:  
```
gem install bundler
```

Once the bundler gem is installed on your computer, navigate to the root of this project (Make sure the Gemfile is in the current directory) and run the following command:
```
bundle install
```

Once all of the components have been installed, we are ready to execute tests on per chapter basis. The following directions demonstrate how to execute the tests for each chapter. It is assumed that you already changed the current directory to the appropriate chapter's Ruby directory. For example, if we want to execute tests in Chapter 1, we will run the following command in terminal:

```
cd Chapter\ 1/Ruby/
```

This will change our current directory to Chapter 1, Ruby example.

### Chapter 1
To execute the ```cheese_finder_tests.rb``` run the following command:

```ruby cheese_finder_test.rb```

You can also execute the test inside of ```search_test.rb``` by running ```ruby search_test.rb```. However, this test is written without a testing framework, so you will not see any passing/failing counts. Just the browser executing the code.

### Chapter 2
To execute the ```product_review_test.rb```, run the following command:

```ruby product_review_test.rb``` 

### Chapter 3 
Similar to Chapter 2 example, we will run the following command to execute tests for Chapter 3:

```ruby product_review_test.rb```

### Chapter 4
Chapter 4 has two tests which we can execute, they are:

* ```product_review_test.rb```: Will generate a new review for the current product.
* ```product_validation_test.rb```: Will validate the contents of each product.

We can execute both of these tests by running the following commands: ```ruby product_review_test.rb``` and ```ruby product_validation_test.rb```

### Chapter 5
### Chapter 6
### Chapter 7