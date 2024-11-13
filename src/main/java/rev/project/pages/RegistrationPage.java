package rev.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;
    public By firstNameLocator= By.xpath("//input[@name=\"name\"]");
    public By lastNameLocator=By.xpath("//label[text()='Last Name:']/following-sibling::input");
    public RegistrationPage(WebDriver driver){
        this.driver=driver;
    }
    public void navigateToRegPage(){
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
    }
    public void fillFirstName(String firstName){
        driver.findElement(firstNameLocator).sendKeys(firstName);
    }
    public void fillLastName(String lastName){
        driver.findElement(lastNameLocator).sendKeys(lastName);
    }

}
