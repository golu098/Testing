package rev.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegPageFactory {
    WebDriver driver;
    public RegPageFactory(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//input[@name=\"name\"]")
    private WebElement firstNameLocator;

    @FindBy(xpath = "//label[text()='Last Name:']/following-sibling::input")
    private WebElement lastNameLocator;
    public void navigateToRegPage() {
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
    }

    public void fillFirstName(String firstName) {
        firstNameLocator.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameLocator.sendKeys(lastName);
    }



}
