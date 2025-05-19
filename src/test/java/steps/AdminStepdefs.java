package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Admin;

import static drivers.DriverHolder.getDriver;

public class AdminStepdefs {
    @Given("User login with user name {string} and password {string} to Orange HRM")
    public void userLoginWithAndToOraneHRM(String USERNAME, String PASSWORD) {
        new Admin(getDriver()).enterUsername(USERNAME).enterPassword(PASSWORD);
    }

    @When("click on login button")
    public void clickOnLoginButton() throws InterruptedException {
        new Admin(getDriver()).clickLoginButton();

    }

    @Then("user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        String expectedMessage = "";
        System.out.println("User logged in successfully");
    }

    @Given("Admin click on Admin From Menu in Orange HRM")
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

    @And("Admin click Admin Dropdown List")
    public void userClickAdminDropdownList() {
        new Admin(getDriver()).click_on_Admin_User();
        new Admin(getDriver()).clickAdminDropdown_List();
    }


    @And("Admin set Employee Name {string}")
    public void userSetEmployeeName(String EmployeeName) {
        new Admin(getDriver()).setEmployee_Name(EmployeeName);
    }

    @And("Admin click on Status Button")
    public void UserclickonStatusButton() {
        new Admin(getDriver()).clickStatusDropDown();
    }

    @And("Admin click Enabled for Status")
    public void userClickEnabled() {
        new Admin(getDriver()).clickenableforstatus();
    }

    @And("set User Name {string}")
    public void setUserName(String Username) {
        new Admin(getDriver()).setUserName(Username);

    }

    @And("set Password {string}")
    public void setPassword(String addPassword) {
        new Admin(getDriver()).setPassword(addPassword);
    }

    @And("set Confirm Password {string}")
    public void setConfirmPassword(String addPassword) {
        new Admin(getDriver()).setConfirmPassword(addPassword);

    }

    @And("save Results")
    public void saveresults() {
        new Admin(getDriver()).saveResults();

    }

    @Then("Admin should verify record count increased by one")
    public void adminShouldGetTheNumberOfRecordsIsIncreasedbyOne() {
        new Admin(getDriver()).Verifythatthenumberofrecordincreasedby1();
    }

    @Given("Admin wants to delete user from Admin tab")
    public void adminWantsToDeleteUserFromAdminTab() {
        new Admin(getDriver()).clickDeleteButton();
    }


    @When("Admin Click on delete button from list of users")
    public void adminClickOnDeleteButtonFromListOfUsers() {
        new Admin(getDriver()).clickDeleteButton();
    }


    @And("Admin click on Ok button to confirm delete")
    public void adminClickOnOkButtonToConfirmDelete() {
        new Admin(getDriver()).clickDeleteConfirmationButton();
    }

    @Then("Admin should verify record count decreased by one")
    public void adminShouldGetTheNumberOfRecordsIsDecreasedByOne() {
        new Admin(getDriver()).Verifythatthenumberofrecorddecreasedby1();

    }
}
