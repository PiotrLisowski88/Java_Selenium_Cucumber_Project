# Java_Selenium_Cucumber_Project
2 cucumber projects using Java and Selenium Webdriver

@newAddressTest: Java + Selenium WebDriver + Cucumber + Page Object Pattern + Junit

Create a user manually at https://mystore-testlab.coderslab.pl.

Write a script that:

will log in to this created user,
will enter by clicking on the Addresses tile after logging in (the address we should be at is: https://mystore-testlab.coderslab.pl/index.php?controller=addresses ),
will click on + Create new address,
will fill out the New address form - the data should be taken from the Examples table in Gherkin (alias, address, city, zip/postal code, country, phone),
will check if the data in the added address is correct.
will delete the above address by clicking on "delete",
will check if the address has been deleted.


@productPurchaseTest: Java + Selenium WebDriver + Cucumber + Page Object Pattern + Junit

Write a script that:

logs in the same user
will select the Hummingbird Printed Sweater for purchase (additional option: make it so that you can check if the discount on it is 20%),
will choose size M (additional option: make it so that you can parameterize the size and choose S,M,L,XL),
will select 5 pieces according to the parameter given in the test (additional option: make it so that you can parameterize the number of pieces),
add the product to the cart,
will go to the option - checkout,
will confirm the address,
will select the pickup method - PrestaShop "pick up in store",
will select the payment option - Pay by Check,
will click on "order with an obligation to pay",
will take a screenshot of the order confirmation and the amount.
