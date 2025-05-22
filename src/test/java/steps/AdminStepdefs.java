package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Admin;

import static drivers.DriverHolder.getDriver;

public class AdminStepdefs {

    @Given("Admin login with valid username {string} and valid password {string}")
    public void userLoginWithValidUsernameAndValidPasswordCredentials(String username, String password) {
        new Admin(getDriver())
                .enterUsername(username)
                .enterPassword(password);
    }

    @When("Admin click on login button")
    public void clickOnLoginButton() {
        new Admin(getDriver()).clickLoginButton();

    }

    @Then("Admin should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        String expectedMessage = "logged in successfully";
    }

    @Given("Admin click on  Admin tab on the left side menu")
    public void adminClickOnAdminFromMenuInOrangeHRM() {
        new Admin(getDriver()).click_on_Admin_From_Menu();
    }

    @And("Admin wants to get Number of Records before adding new user")
    public void getNumberooRecordesfound() {
        new Admin(getDriver()).storeInitialRecordCount();


    }

    @And("Admin scrollTo Search Results")
    public void userScrollToSearchResults() {
        new Admin(getDriver()).scrollToSearchResults();

    }

    @When("Admin click on Add button")
    public void userClickOnAddButton() {
        new Admin(getDriver()).click_to_Add_new_Admin();
    }

    @And("Admin click User role and select Admin from  Dropdown List")
    public void userClickAdminDropdownList() {
        new Admin(getDriver()).click_on_Admin_User();
        new Admin(getDriver()).clickAdminDropdown_List();
    }

    @And("Admin set Employee Name as {string}")
    public void adminSetEmployeeNameAs(String employeeName) throws InterruptedException {
        new Admin(getDriver()).setEmployee_Name(employeeName);
    }

    @And("Admin click on Status Button and  Admin click Enabled for Status")
    public void UserclickonStatusButton() {
        new Admin(getDriver()).clickStatusDropDown();
        new Admin(getDriver()).clickenableforstatus();

    }
    @And("set User Name as {string}")
    public void setUserNameAs(String userName) {
        new Admin(getDriver()).setUserName(userName);
    }

    @And("set Password as {string}")
    public void setPasswordAs(String password) {
        new Admin(getDriver()).setPassword(password);
    }

    @And("set Confirm Password as {string}")
    public void setConfirmPasswordAs(String password) {
        new Admin(getDriver()).setConfirmPassword(password);
    }

    @And("save Results")
    public void saveresults() {
        new Admin(getDriver()).saveResults();

    }

    @Then("Admin should verify record count increased by one")
    public void adminShouldGetTheNumberOfRecordsIsIncreasedbyOne() throws InterruptedException {
        new Admin(getDriver()).verifythatthenumberofrecordincreasedby1();
    }

    @Given("Admin search for user {string}")
    public void adminSearchForUser(String userName) {
        new Admin(getDriver()).searchByUserName(userName);
    }

    @And("Admin click on Search button")
    public void adminClickOnSearchButton() {
        new Admin(getDriver()).clickSearchButton();
    }



    @When("Admin click on delete button to Delete User")
    public void adminClickOnDeleteButtonFromListOfUsers() {
        new Admin(getDriver()).clickDeleteButton();
    }


    @And("Admin click on delete button in Confirmation Message")
    public void adminClickOnOkButtonToConfirmDelete() throws InterruptedException {
        new Admin(getDriver()).clickDeleteConfirmationButton();
    }

    @Then("Admin should verify record count decreased by one")
    public void adminShouldGetTheNumberOfRecordsIsDecreasedByOne() {
        new Admin(getDriver()).verifythatthenumberofrecorddecreasedby1();

    }


}
