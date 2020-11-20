Feature:  As A User
  I want to search for trouser on amazon
  So I can select trousers using different criteria.

  @smoke @Severity(SeverityLevel.CRITICAL)
  Scenario: CheckOut -  Verify guest checkout process
    Given I visit the web site as a guest user
    And I search for "trouser"
    Then I should be in Search Result page
    And Page should have search keyword as "trouser"
    And I search for following criteria and ADD the one item of each
      | Popular Brands |
      | Any Brand      |
      | Price          |
    Then I navigate to Cart page
    And I remove a product from the Cart
    When I click on "Proceed to Checkout" button on Cart page
    Then I should be redirected to Login page
