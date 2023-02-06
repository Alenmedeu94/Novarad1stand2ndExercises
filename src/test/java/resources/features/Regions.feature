Feature: Regions Automation Example
  @ui
  Scenario: user applies for loan on Regions website

    Given   user in on the main page
    When user navigates to Personal tab
    And user navigates to Online & Mobile Banking tab
    And user clicks on Mobile banking
    And user scrolls down to More Resources
    Then user validates additional modules under More Resources


