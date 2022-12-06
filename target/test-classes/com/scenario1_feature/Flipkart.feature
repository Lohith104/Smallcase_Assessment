Feature: Flipkart 


Scenario: Flipkart add to cart
Given user Launch The URL Of Flipkart 
When user Search Of TV Product
And user Click On The First Product 
And user Print The Product price
And user Add The Product To Cart
And user Go To Cart Page And Increse The Quantity By One
Then user Print The Price After Increasing The Quantity


  
