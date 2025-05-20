Feature: Admin Functionality in Orange HRM

  @Admin
  Scenario Outline: Add and delete user with dynamic count validation
    Given User login with valid username "<username>" and valid password "<password>" credentials
    When click on login button
    Then user should be logged in successfully
    Given Admin click on Admin From Menu in Orange HRM
    And Admin wants to get Number of Records before adding new user
    And Admin click on Add button
    And Admin click Admin Dropdown List
    And Admin set Employee Name as "<employeeName>"
    And Admin click on Status Button
    And Admin click Enabled for Status
    And set User Name as "<userName>"
    And set Password as "<password>"
    And set Confirm Password as "<password>"
    When save Results
    Then Admin should verify record count increased by one
    Given Admin search for user "<userName>"
    And Admin wants to delete user from Admin tab
    When Admin click on Search button
    And Admin Click on delete button from list of users
    And Admin click on Ok button to confirm delete
    Then Admin should verify record count decreased by one
    Examples:
      | username | password | employeeName | userName | password   |
      | Admin    | admin123 | A            | IslamAli | QKa1234567 |

