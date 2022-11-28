Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/test/{product} for getting the products.
### Available products: "apple", "mango", "tofu", "water"
### Prepare Positive and negative scenarios

  @apple
  Scenario: "User verifies apple endpoint"
    When he calls endpoint "apple"
    Then he sees the results displayed for "apple"
  @mango
  Scenario: "User verifies mango endpoint"
    When he calls endpoint "mango"
    Then he sees the results displayed for "mango"
  @tofu
  Scenario: "User verifies tofu endpoint"
    When he calls endpoint "tofu"
    Then he sees the results displayed for "tofu"
  @car
  Scenario: "User verifies wrong endpoint car"
    When he calls endpoint "car"
    Then he does not see the results