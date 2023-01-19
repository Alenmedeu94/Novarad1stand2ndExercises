Feature: LoanPro Automation Example
  @ui
  Scenario: user logins on LoanPro Environment

    Given   user in on the login page
    Then verify controls displayed
    When user login to main page
    Then user verifies correct url
    And user validates controls on main page
    And user searches loans by status “Approved”
    Then user validates loan count with status approved

