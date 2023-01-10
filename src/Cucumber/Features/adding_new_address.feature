Feature: Create and verify new address for a logged in user.

  Scenario Outline:
    Given I am logging in on the "https://mystore-testlab.coderslab.pl/index.php" page using correct "<email>" and "<password>"
    And I click on the Addresses button and Create new address button
    And I fill out the New Address form with "<alias>", "<address>", "<city>", "<zip_code>", "<country>", and "<phone>" and click save button.
    Then the new address should be displayed with the correct "<alias>", "<address>"," <city>", "<zip_code>", "<country>", and "<phone>"
    Then delete address
    And checking if address with proper "<alias>" is deleted

    Examples:
     |email              | password | alias | address     | city     | zip_code | country         | phone     |
     |kontovod@gmail.com | zzii9338 | Piotr | Woronicza   | Warszawa | 10-123   | United Kingdom  | 533243444 |
