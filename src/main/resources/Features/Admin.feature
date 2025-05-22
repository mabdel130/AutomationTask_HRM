Feature: Admin Functionality in Orange HRM

  @Admin
  Scenario Outline: Admin login with valid credentials
    Given Admin login with valid username "<username>" and valid password "<password>"
    When Admin click on login button
    Then  Admin should be logged in successfully
    Examples:
      | username | password |
      | Admin    | admin123 |

  Scenario Outline:Admin retrieves initial user count, adds user via Admin tab, and confirms count increases by one
    Given Admin click on  Admin tab on the left side menu
    And Admin wants to get Number of Records before adding new user
    And Admin click on Add button
    And Admin click User role and select Admin from  Dropdown List
    And Admin set Employee Name as "<employeeName>"
    And Admin click on Status Button and  Admin click Enabled for Status
    And set User Name as "<userName>"
    And set Password as "<user password>"
    And set Confirm Password as "<user password>"
    When save Results
    Then Admin should verify record count increased by one
    Examples:
      | employeeName | userName   | user password |
      | A            | Said Ahmed | Qa123ed@      |

  Scenario Outline: Admin Want to delete Added user and Confirmed That numbers of records decreased by one
    Given Admin search for user "<userName>"
    And Admin click on Search button
    When Admin click on delete button to Delete User
    And Admin click on delete button in Confirmation Message
    Then Admin should verify record count decreased by one
    Examples:
      | userName   |
      | Said Ahmed |

