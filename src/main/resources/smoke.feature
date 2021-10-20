Feature: Smoke
  As a Register user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check registrations with invalid data
    Given User opens '<homePage>' page
    When User clicks 'Hello,Sign in'  button
    And User clicks 'Create your Amazon account' button
    And User enters your name field with '<validName>'
    And User enters email field with '<validEmail>'
    And User enters password field with '<validPassword>'
    And User enters check password with '<invalidPassword>'
    And User clicks 'Create your Amazon account' button'
    Then User gets password mismatch error message
    Examples:
      | homePage                | validEmail   | validPassword | invalidPassword | validName |
      | https://www.amazon.com/ | vm@gmail.com | 03041984_Jane | 05121984_Jane   | Jane      |

  Scenario Outline: Check entering on account with valid data
    Given User opens '<homePage>' page
    When User clicks 'Hello,Sign in'  button
    And User enters '<validEmail>' in email  field
    And User clicks 'Continue' button
    And User enters '<validPassword>' in password field
    And User clicks 'rememberMeCheckBox' button
    And User clicks 'Sign in' button
    And User clicks 'Hello,Sign in'  button
    Then User checks that current url contains '<keyword>'
    Examples:
      | homePage                | validEmail          | validPassword |keyword        |
      | https://www.amazon.com/ | v06455089@gmail.com | 03041984_Jane |youraccount_btn|

  Scenario Outline:Check brand filter
    Given User opens '<homePage>' page
    When User clicks logo
    And User clicks 'Today's Deals' button
    And User clicks 'Registry' button
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks brand filer value
    Then User checks all products contains '<brandWords>'
    Examples:
      | homePage                | keyword                      | brandWords        |
      | https://www.amazon.com/ | saucony womens running shoes | Saucony Originals |

  Scenario Outline: Check add products to cart and change it's amount
    Given User opens '<homePage>' page
    When User clicks 'Hello,Sign in'  button
    And User enters '<validEmail>' in email  field
    And User clicks 'Continue' button
    And User enters '<validPassword>' in password field
    And User clicks 'rememberMeCheckBox' button
    And User clicks 'Sign in' button
    And User clicks 'Cart' button
    And User clicks add to 'Cart' on second product
    Then User checks that amount of products in 'Cart' are '<amountOfProducts>'
    Examples:
      | homePage                | validEmail          | validPassword | amountOfProducts |
      | https://www.amazon.com/ | v06455089@gmail.com | 03041984_Jane | 1                |

  Scenario Outline:Check sign up as a Amazon seller with invalid data
    Given User opens '<homePage>' page
    When User clicks logo
    And User clicks on 'Sell' button
    And User clicks on 'Sign up seller' button
    And User enters '<validEmail>' in email  field
    And User enters '<validPassword>' in password field
    And User clicks 'Continue' button
    And User chooses business location
    And User chooses business type
    And User enters '<validName>' in business name
    And User clicks on 'Agree and confirm' button
    Then User gets confirmation alert message
    Examples:
      | homePage                | validEmail            | validPassword | validName       |
      | https://www.amazon.com/ | mamaevajein@gmail.com | 05121984_Vova | Vladimir Mamaev |

  Scenario Outline:Check sort by Avg.Customer Review
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User chooses sort by 'Avg.Customer Review'
    And User checks the sorting of products by reviews
    Examples:
      | homePage                | keyword  |
      | https://www.amazon.com/ | computer |

  Scenario Outline:Check amount of displayed search results
    Given User opens '<homePage>' page
    When User clicks logo
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks 'Today's Deals' button
    Then User checks amount of search results
    Examples:
      | homePage                | keyword  |
      | https://www.amazon.com/ | computer |

  Scenario Outline: Check that amazon wedding registry registrations with invalid date
    Given User opens '<homePage>' page
    When User clicks 'Hello,Sign in'  button
    And User enters '<validEmail>' in email  field
    And User clicks 'Continue' button
    And User enters '<validPassword>' in password field
    And User clicks 'Sign in' button
    And User clicks 'Registry' button
    And User clicks 'Wedding Registry' button
    And User clicks 'Create your registry' button
    And User enters '<nameOne>' in name first partner
    And User enters '<surnameOne>' surname first partner
    And User enters '<nameTwo>' name second partner
    And User enters '<surnameTwo>'surname second partner
    And User clicks 'Next' button
    And User clicks 'Next' button
    Then User gets alert message
    Examples:
      | homePage                | validEmail          | validPassword | nameOne  | surnameOne | nameTwo | surnameTwo |
      | https://www.amazon.com/ | v06455089@gmail.com | 03041984_Jane | Vladimir | Mamaev     | Jane    | Orin       |

  Scenario Outline:Check top 100
    Given User opens '<homePage>' page
    When User clicks logo
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User clicks on 'Top 100' link
    And User clicks 'Next page' button
    Then User checks last product number
    Examples:
      | homePage                | keyword                    |
      | https://www.amazon.com/ | saucony mens running shoes |

  Scenario Outline: Check get amazon prime for free for 30 days with invalid data
    Given User opens '<homePage>' page
    When User clicks logo
    And User clicks 'Hello,Sign in'  button
    And User enters '<validEmail>' in email  field
    And User clicks 'Continue' button
    And User enters '<validPassword>' in password field
    And User clicks 'Sign in' button
    And User clicks 'Hello,Sign in'  button
    And User clicks 'Prime' button
    And User clicks 'Try Prime free' button
    And User gets warning message
    Examples:
      | homePage                | validEmail          | validPassword |
      | https://www.amazon.com/ | v06455089@gmail.com | 03041984_Jane |