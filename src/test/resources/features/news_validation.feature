Feature: News Validation

  Scenario: Confirm the first Guardian news article is valid
    Given I am on The Guardian website
    When I click on the first news article
    And I collect the title and content of the article
    Then I search Google for articles with the same title and content
    And I verify that at least 2 similar articles are found
    Then the first Guardian news article is considered valid

  Scenario: Confirm the first Guardian news article is valid
    Given I am on The Guardian website
    When I click on the first news article
    And I collect the title and content of the article
    Then I search Google for articles with the same title and content
    And I verify that at least 2 similar articles are found
    Then the first Guardian news article is considered valid