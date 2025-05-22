package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

;


@CucumberOptions(features = "src/main/resources/Features/",
        glue = {"steps"}, monochrome = true,
        plugin = {
                "pretty", "html:target/HtmlReports/report.html", "json:target/JsonReport/report.json",
                "junit:target/JunitReport/report.xml"}, tags = "@Admin"
)
public class AdminPageRunner extends AbstractTestNGCucumberTests {


}

