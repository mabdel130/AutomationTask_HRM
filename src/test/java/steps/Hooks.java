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
    private static String PROJECT_NAME = null;
    private static String PROJECT_URL = null;
    static Properties prop;
    static FileInputStream readProperty;
    protected String lang;
    protected Logger log;

    @Before
    public void setupDriver() throws AWTException, IOException {
        // TODO: Step1: define object of properties file
        readProperty = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/properties/environment.properties");
        prop = new Properties();
        prop.load(readProperty);

        // define project name from properties file
        PROJECT_NAME = prop.getProperty("projectName");
        PROJECT_URL = prop.getProperty("url");
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
