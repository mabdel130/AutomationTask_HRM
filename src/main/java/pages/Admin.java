package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static drivers.DriverHolder.getDriver;


public class Admin extends BasePage {

    public Admin(WebDriver driver) {
        super(driver);
    }

    private static int initialRecordCount;
    private final By USERNAME_TEXT = By.xpath("//input[@placeholder='Username']");
    private final By PASSWORD_TEXT = By.xpath("//input[@placeholder='Password']");
    private final By LOGIN_BUTTON = By.xpath("//button[normalize-space()='Login']");


    private final By admin_Button = By.linkText("Admin");
    private final By AddAdmin_Button = By.xpath("//button[normalize-space()='Add']");
    private final By AdminDropDown_DWlist = By.xpath("(//i[@data-v-bddebfba='' and @data-v-67d2aedf='' and contains(@class, 'oxd-icon bi-caret-down-fill oxd-select-text--arrow')])[1]");
    private final By statusDropDown_Dwlist = By.xpath("(//div[@class='oxd-select-text-input'])[2]");  // (//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]
    private final By employeeName_Text = By.xpath("//input[@placeholder='Type for hints...']");

    private final By userName_Text = By.xpath("(//input[contains(@class, 'oxd-input--active')] )[2]"); // (//input[@class='oxd-input oxd-input--active'])[2]
    private final By password_Text = By.xpath("(//input[@class='oxd-input oxd-input--active' and @type='password' and @autocomplete='off'])[1]");
    private final By confirmPassword_Text = By.xpath("(//input[@type='password'])[2]");
    private final By saveButton = By.xpath("//button[@type='submit']");
    private final By searchbyusername_Text = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"); // (//input[@class='oxd-input oxd-input--active'])[2]

    private final By search_Button = By.xpath("//button[normalize-space()='Search']");

    private final By delete_Button = By.xpath("(//i[@class='oxd-icon bi-trash'])[1]");
    private final By deleted_confirmation = By.xpath("//button[contains(@class, 'oxd-button--label-danger') and contains(., 'Yes, Delete')]");

    public Admin enterUsername(String username) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(USERNAME_TEXT)).sendKeys(username);
        return new Admin(driver);
    }

    public Admin enterPassword(String password) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_TEXT)).sendKeys(password);
        return new Admin(driver);
    }

    public Admin clickLoginButton() {
        shortWait(getDriver()).until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        driver.findElement(this.LOGIN_BUTTON).sendKeys(Keys.ENTER);
        return new Admin(driver);
    }

    public Admin click_on_Admin_From_Menu() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(admin_Button));
        driver.findElement(this.admin_Button).sendKeys(Keys.ENTER);
        return new Admin(driver);
    }

    public Admin scrollToSearchResults() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300);");
        return new Admin(driver);
    }


    public int getNumberooRecordesfound() {

        WebElement countElement = shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(., 'Records Found') or contains(., 'No Records Found')]")
        ));

        String countText = countElement.getText().trim();


        if (countText.equalsIgnoreCase("No Records Found")) {
            return 0;
        }


        Matcher matcher = Pattern.compile("\\d+").matcher(countText);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        throw new RuntimeException("Failed to parse record count from: " + countText);
    }

    public void storeInitialRecordCount() {

        initialRecordCount = getNumberooRecordesfound();
    }


    public Admin click_to_Add_new_Admin() {
        shortWait(getDriver()).until(ExpectedConditions.elementToBeClickable(AddAdmin_Button));
        driver.findElement(this.AddAdmin_Button).click();
        return new Admin(driver);
    }

    public Admin click_on_Admin_User() {
        shortWait(getDriver()).until(ExpectedConditions.elementToBeClickable(AdminDropDown_DWlist));
        driver.findElement(this.AdminDropDown_DWlist).click();
        return new Admin(driver);
    }

    public Admin clickAdminDropdown_List() {
        Actions actions = new Actions(driver);
        longWait(getDriver()).until(ExpectedConditions.elementToBeClickable(AdminDropDown_DWlist));
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        return new Admin(driver);
    }

    public Admin setEmployee_Name(String employeeName) throws InterruptedException {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(employeeName_Text)).sendKeys(employeeName);
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        return new Admin(driver);
    }

    public Admin clickStatusDropDown() {
        longWait(getDriver()).until(ExpectedConditions.elementToBeClickable(statusDropDown_Dwlist));
        driver.findElement(this.statusDropDown_Dwlist).click();
        return new Admin(driver);
    }

    public Admin clickenableforstatus() {
        Actions actions = new Actions(driver);
        longWait(getDriver()).until(ExpectedConditions.elementToBeClickable(statusDropDown_Dwlist));
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        return new Admin(driver);
    }


    public Admin setUserName(String employeeUsername) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(userName_Text));
        driver.findElement(this.userName_Text).sendKeys(employeeUsername);
        return new Admin(driver);
    }

    public Admin setPassword(String addPassword) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(password_Text));
        driver.findElement(this.password_Text).sendKeys(addPassword);
        return new Admin(driver);
    }

    public Admin setConfirmPassword(String addPassword) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(confirmPassword_Text));
        driver.findElement(this.confirmPassword_Text).sendKeys(addPassword);
        return new Admin(driver);
    }

    public Admin saveResults() {
        longWait(getDriver()).until(ExpectedConditions.elementToBeClickable(saveButton));
        driver.findElement(this.saveButton).click();
        return new Admin(driver);
    }


    public Admin Verifythatthenumberofrecordincreasedby1() throws InterruptedException {
        int newCount = getNumberooRecordesfound();
        if (newCount != initialRecordCount + 1) {
            Thread.sleep(200);
            throw new RuntimeException("Count didn't increase. Initial: " + initialRecordCount + ", New: " + newCount);

        }
        return new Admin(driver);
    }

    public Admin searchByUserName(String employeeUsername) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(searchbyusername_Text)).sendKeys(employeeUsername);
        return new Admin(driver);
    }

    public Admin clickSearchButton() {
        longWait(getDriver()).until(ExpectedConditions.elementToBeClickable(search_Button));
        driver.findElement(this.search_Button).click();
        return new Admin(driver);
    }

    public Admin clickDeleteButton() {
        longWait(getDriver()).until(ExpectedConditions.elementToBeClickable(delete_Button));
        driver.findElement(this.delete_Button).click();
        return new Admin(driver);
    }

    public Admin clickDeleteConfirmationButton() throws InterruptedException {
        WebElement deleteBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(deleted_confirmation));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", deleteBtn);
        Thread.sleep(2000);
        return new Admin(driver);
    }

    public Admin Verifythatthenumberofrecorddecreasedby1() {
        int finalCount = getNumberooRecordesfound();
        if (finalCount != 0) {
            throw new RuntimeException("Record count mismatch. Expected: 0, Actual: " + finalCount);
        }
        return new Admin(driver);
    }

}




    
    

