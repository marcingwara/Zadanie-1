Feature: Adding a new address

  Scenario Outline: User logs in and adds a new address
    Given The user is on the login page
    When I sign in
    And The user logs in with email "marcingwara@gmx.de" and "zanbiF-zyzxyn-vysni2"
    And The user goes to "Addresses"
    And The user clicks Create new address
    And The user fills in the form with: "<alias>", "<address>", "<city>", "<zip>", "<country>", "<phone>"
    And The user saves the address
    Then The new address should be displayed with the correct details "marcon gawron", "<address>", "<city>", "<zip>", "<country>", "<phone>"
    And The user delete address
    And The delete address should be displayed with the correct details"Address successfully deleted!"
    And The user close browser


    Examples:
      | alias | address | city      | zip    | country        | phone     |
      | Home  | Test St | Buxtehude | 00-123 | United Kingdom | 123456789 |
