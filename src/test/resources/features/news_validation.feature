Feature: Validating News Article
  As a news validation site user,
  I want to confirm the validity of a news article from The Guardian,
  So that I can ensure it is not fake news.

  Background:
    Given I am on The Guardian website
    And I collect the title and content of the article
    Then I search Google for articles with the same title and content

  @Functional
  Scenario: Confirm the first Guardian news article is valid
    And I verify that at least 2 similar articles are found
