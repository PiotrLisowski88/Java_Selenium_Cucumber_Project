Feature: Purchase product with discount and pay by check

  Scenario Outline:
    Given I open "https://mystore-testlab.coderslab.pl/index.php" page, enter my "<email>" and "<password>" and click the login button
    When I search for the the product in searchbar and click on it
    And verify that there is a "-20%" discount on the product
    And select size "<size>"
    And select "<number>" of pieces
    Then I add the product to my basket
    And I go to the checkout option
    And I confirm my address
    And I select the pickup method pick up in store
    And I select the payment option Pay by Check
    And I click on order with an obligation to pay
    Then I take a screenshot of the order confirmation and the amount

    Examples:

      | size  | number | email              | password |
      | 2     | 5     | kontovod@gmail.com | zzii9338 |

