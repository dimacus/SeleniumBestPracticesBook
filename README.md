SeleniumBestPracticesBook
=========================


# Installing The Project
To get started, you need to have GIT installed on your computer. Once GIT is installed, run the following command in your terminal to clone the project:

```git clone https://github.com/dimacus/SeleniumBestPracticesBook.git```              
After the project is cloned, follow the instructions on how how to execute the tests in a given programing language:

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
In Chapter 5, we have joined our 3 tests under a single runner called ```run_tests.rb```. To run all of the tests all we have to do is execute the following command ```ruby run_tests.rb```.

### Chapter 6
Chapter 6 comes in two parts. In part 1, we create a simple Cucumber project that looks very similar to the Test::Unit project we have been working with. About half way through the chapter, we refactor our code, and start using part 2 code. To execute the tests please follow these steps:
  
#### Part 1
To execute all of the tests in the test suite, just run the following command from Part 1 directory:
```cucumber features``` 

To execute all of the tests in a single feature file, add the filename to the end of the command like so:
```cucumber features/product_review.feature```

To execute a single test in a given file, add a line on which the test is located, like so:
```cucumber features/product_review.feature:15```

#### Part 2                                   
In the second part of this chapter, we introduce the concept of Cucumber Tags and Profiles. We can execute individual profiles by running the following command ```cucumber -p PROFILE_NAME features``` where the ```PROFILE_NAME``` refers to an existing profile in the ```config/cucumber.yml``` file.

The following commands demonstrate how to execute each profile:

* Default Profile: ```cucumber features```
* Continuous Integration Profile: ```cucumber -p ci features```
* Mobile Website Profile: ```cucumber -p mobile features```
* API Endpoint Test Profile: ```cucumber -p api features```

### Chapter 7
In Chapter 7, we have a test written in in Test::Unit, RSpec, and Cucumber. To run the test in each of the testing frameworks, run the following command:

* Test::Unit: ```ruby test_unit_example.rb```
* Cucumber: ```cucumber cucumber_example.feature```
* RSpec: ```rspec rspec_example.rb```



