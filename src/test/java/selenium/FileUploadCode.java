package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadCode {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload"); // Example URL with file upload form
    }

    @Test
    public void fileUploadTest() {
        // Locate the file input element (input[type="file"])
        WebElement fileInput = driver.findElement(By.id("file-upload"));

        // Provide the absolute path to the file you want to upload
        String filePath = "C:\\Users\\shivkant_kumar\\Pictures\\274931.jpg"; // Replace with the actual file path

        // Send the file path to the input element
        fileInput.sendKeys(filePath);

        // Submit the file upload by clicking the 'Upload' button
        driver.findElement(By.id("file-submit")).click();

        // Optional: Verify that the file upload was successful
        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        System.out.println("Uploaded file name: " + uploadedFile.getText());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
