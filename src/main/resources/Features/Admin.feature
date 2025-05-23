Feature: Admin Functionality in Orange HRM

  @Admin
  Scenario Outline: Admin login with valid credentials and add user then delete user
    Given Admin login with valid username "<username>" and valid password "<password>"
    When Admin click on login button
    Then  Admin should be logged in successfully
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
    Given Admin search for user "<userNameafterAdding>"
    And Admin click on Search button
    When Admin click on delete button to Delete User
    And Admin click on delete button in Confirmation Message
    Then Admin should verify record count decreased by one
    Examples:
      | username | password | employeeName | userName  | user password | userNameafterAdding |
      | Admin    | admin123 | A            | Ahmed ali | Qa@12234      | Ahmed ali           |



