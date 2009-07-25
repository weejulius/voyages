require 'spec/expectations' # so we can call .should


    Given /^I have 3 green cukes$/  do 
     pending
    end
    When /^I add a table$/ do |table|
    table.hashes do |hashes|
    hashes["a"].should==3
    hashes["b"].should==2
    end
    end
    Then /^I should have 3  green cukes$/ do
     pending
    end
   

