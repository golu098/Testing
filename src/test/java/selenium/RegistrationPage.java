package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class RegistrationPage {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
//        driver.get("https://www.way2automation.com/way2auto_jquery/autocomplete.php");
    }

    @Test
    public void firstAndLastName(){
        WebElement firstName=driver.findElement(By.xpath("//input[@name=\"name\"]"));
        firstName.sendKeys("shiv kant");
//        WebElement errorMessage=driver.findElement(By.xpath("//label[text()='This field is required.']"));

        WebElement lastName=driver.findElement(By.xpath("//label[text()='Last Name:']/following-sibling::input"));

        lastName.sendKeys("kumar");


    }
    @Test
    public void martialStatusRadioButton(){
        WebElement single=driver.findElement(By.xpath("//label[text()=\" Single\"]"));
        WebElement married= driver.findElement(By.xpath("//label[text()=\" Married\"]"));
        WebElement divorced=driver.findElement(By.xpath("//label[text()=\" Divorced\"]"));
        if(!single.isSelected()){
            single.click();
        }
        if(!married.isSelected()){
            single.click();
        }
        if(!divorced.isSelected()){
            single.click();
        }
    }

    @Test
    public void hobbyCheckBox(){
        WebElement dance=driver.findElement(By.xpath("//label[text()=\" Dance\"]"));
        WebElement reading=driver.findElement(By.xpath("//label[text()=\" Reading\"]"));
        WebElement cricket=driver.findElement(By.xpath("//label[text()=\" Cricket\"]"));
        if(!dance.isSelected()){
            dance.click();
        }
        if(!reading.isSelected()){
            reading.click();
        }
        if(!cricket.isSelected()){
            cricket.click();
        }
    }
    @Test
    public void countryDropDown(){
        WebElement dropDown=driver.findElement(By.xpath("//option[text()=\"India\"][1]//parent::select[1]"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("India");
        select.selectByValue("India");
        select.selectByIndex(0);
    }
    @Test
    public void dateOfBirthDropDown(){
        WebElement monthDropDown=driver.findElement(By.xpath("//option[text()=\"Month\"][1]//parent::select[1]"));
        Select select=new Select(monthDropDown);
        select.selectByIndex(1);

        WebElement dayDropDown=driver.findElement(By.xpath("//option[text()=\"Day\"][1]//parent::select"));
        Select select1=new Select(dayDropDown);
        select1.selectByVisibleText("1");
        WebElement yearDropDown=driver.findElement(By.xpath("//option[text()=\"Year\"][1]//parent::select"));
        Select select2=new Select(yearDropDown);
        select2.selectByVisibleText("2014");
    }
    @Test
    public void phoneNoumber(){
        WebElement phoneNo=driver.findElement(By.xpath("//label[text()='Phone Number:']/following-sibling::input"));
        phoneNo.sendKeys("6202055728");
        WebElement userName=driver.findElement(By.xpath("//label[text()='Username:']/following-sibling::input[1]"));
        userName.sendKeys("shivKant");
    }
    @Test
    public void email(){
        WebElement emailPath=driver.findElement(By.xpath("//label[text()='E-mail:']/following-sibling::input"));
        emailPath.sendKeys("111111111111");
//        String errorMessage=driver.findElement(By.xpath("//label[.='Please enter a valid email address.']")).getText();
//
//        System.out.println( errorMessage.getText());
    }
    @Test
    public void fileUpload(){
        WebElement fileUpload=driver.findElement(By.xpath("//input[@type='file']"));
        String filePath = "C:\\Users\\shivkant_kumar\\Pictures\\274931.jpg";
        fileUpload.sendKeys(filePath);
    }
    @Test
    public void password(){
        WebElement password=driver.findElement(By.xpath("//input[@type='password'][1]"));
        password.sendKeys("12233");
        String typeAttribute=password.getAttribute("type");
        Assert.assertEquals(typeAttribute,"password","Password is not masked");
    }
    @Test
    public void validateErrorMessages() {
        // Locate the submit button and click it without entering any data
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit'][1]"));
        submitButton.click();

        // Capture and print error messages for each required field
        List<WebElement> errorMessages = driver.findElements(By.xpath("//label[text()='This field is required.']")); // Update XPath as per actual class or tag for error messages

        for (WebElement errorMessage : errorMessages) {
            System.out.println("Error message: " + errorMessage.getText());
        }
    }


//
//    @Test
//    public void textCard() {
//        // Locate all <li> elements under the specified <div> and <ul>
//        List<WebElement> cards = driver.findElements(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[2]/div[1]/ul/li"));
//
//        // Count the number of cards
//        int cardCount = cards.size();
//
//        // Print the count
//        System.out.println("Number of cards: " + cardCount); // Should print 5 if there are 5 <li> elements
//    }
@Test
public void textCard() {
    // Locate all <li> elements under the specified <ul> element
    List<WebElement> cards = driver.findElements(By.xpath("//div[@id='wrapper']//ul/li"));

    // Count the number of cards
    int cardCount = cards.size();

    // Print the count
    System.out.println("Number of cards: " + cardCount); // Should print the actual number of <li> elements
}






//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//
//    }

}
