package rev.project.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features="src/test/resources/features/registration.feature",
    glue={"rev.project.stepDefinitions","rev.project.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome=true
)
public class RegRunner extends  AbstractTestNGCucumberTests{
}
