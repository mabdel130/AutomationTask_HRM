package steps;

import com.github.javafaker.Faker;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;
import static pages.BasePage.quitBrowser;

import static util.Utlity.openBrowserNetworkTab;

public class Hooks {

    Faker faker = new Faker();
    public static String PROJECT_NAME;
    public static String PROJECT_URL;
    public static String USERNAME;
    public static String PASSWORD;
    public static String employeeName;
    public static String employeeUsername;

    static Properties prop;
    static FileInputStream readProperty;

    @Before
    public void setupDriver() throws AWTException, IOException {

        readProperty = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/properties/environment.properties");
        prop = new Properties();
        prop.load(readProperty);

        PROJECT_NAME = prop.getProperty("projectName");
        PROJECT_URL = prop.getProperty("url");
        USERNAME = prop.getProperty("username");
        PASSWORD = prop.getProperty("password");

        employeeName = prop.getProperty("employeeName").isEmpty() ?
                faker.options().option("A", "B", "C", "D") :
                prop.getProperty("employeeName").toUpperCase().substring(0, 1);

        employeeUsername = !prop.getProperty("employeeUsername").isEmpty() ?
                prop.getProperty("employeeUsername") : faker.name().username();


        setDriver(DriverFactory.getNewInstance(""));
        getDriver().get(PROJECT_URL);
        getDriver().manage().window().maximize();
        // open browser network
        openBrowserNetworkTab();
    }

    @After
    public void quiteDriver() {
        quitBrowser(getDriver());
    }
}
