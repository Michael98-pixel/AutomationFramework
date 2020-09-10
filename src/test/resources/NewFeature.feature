@NewUserRegistration
Feature:  Registration of the new user

  @Scenario1
  Scenario: Ability of registration of the new user
    Given user navigates to 'https://www.aliexpress.com/' page
    And user is on the 'HomePage' page
    Then 'Join' button is displayed
    When user clicks on 'Join' button
   And 'Registration' is displayed
    And user fills the 'Email' and 'Password' fields
    And user click on 'Submit' button
    Then 'Welcome' message is displayed

@Scenario2
Scenario: Ability of searching through search box and adding random item to cart
  Given user navigates to  'https://www.aliexpress.com/' page
  And user is on the 'HomePage' page
  Then user write in Search box 'Xiaomi' and press ENTER key
  And results were displayed
  Then User clicks on first displayed 'Item'
  And user is redirected to new 'ItemPage' page
  Then  user chose one 'Type' and 'Color' and press 'AddToCart' button
  And 'Success' message is displayed
  Then  user checks 'Cart'
  And  chosen Item is in the cart

  @Scenario3
  Scenario: Ability of logging an existing user
    Given user navigates to 'https://www.aliexpress.com/' page and 'SignIn' button is displayed
    When user clicks on   'SignIn' button
    Then 'Form'  form is displayed
    And user fills the existing 'Login' and 'Pass' fields
    And user click on 'Sub'   button
    Then  Mihai user is logged in message is displayed
