package rev.project.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import rev.project.driver.BrowserType;
import rev.project.driver.DriverManager;
import rev.project.pages.RegPageFactory;
import rev.project.pages.RegistrationPage;

public class RegistrationStepDef {
    WebDriver driver;
    RegistrationPage registrationPage;
    RegPageFactory regPageFactory;
    public RegistrationStepDef(){
        this.driver= DriverManager.getDriver(BrowserType.CHROME);
//        this.registrationPage=new RegistrationPage(driver);
        this.regPageFactory=new RegPageFactory(driver);


    }
    @Given("User is on the Registration Page")
    public void userIsOnRegistrationPage(){
//       registrationPage.navigateToRegPage();
       regPageFactory.navigateToRegPage();
    }
    @When("Fill {string} in First Name")
    public void fillFirstName(String firstName){
//        registrationPage.fillFirstName(firstName);
        regPageFactory.fillFirstName(firstName);
    }
    @When("Fill {string} in Last Name")
    public void fillLastName(String lastName){
//        registrationPage.fillLastName(lastName);
        regPageFactory.fillLastName(lastName);
    }
}
