Feature: Validating News Article
  As a news validation site user,
  I want to confirm the validity of a news article from The Guardian,
  So that I can ensure it is not fake news.

  @functional
  Scenario: Confirm the first Guardian news article is valid
    Given I am on The Guardian website
    And I collect the title and content of the article
    Then I search "GOOGLE" for articles with the same title and content
    And I verify that at least 2 similar articles are found

  @functional
  Scenario: Failing to validate when no matching sources found
    Given I have a fake news article from The Guardian
    Then I search "GOOGLE" for articles with the same title and content
    Then the system should mark the news article as fake if no matching articles are found

  @functional
  Scenario: Testing with different search engines
    Given I am on The Guardian website
    And I collect the title and content of the article
    Then I search "BING" for articles with the same title and content
    And I verify that at least 2 similar articles are found

  @wip
  Scenario: Handling edge cases
    Given I have news articles with unusual formatting and structures
    When I validate them
    Then the system should handle diverse content effectively

  @wip
  Scenario: Handling invalid URLs
    Given I enter invalid or unreliable URLs
    Then the system should reject them appropriately