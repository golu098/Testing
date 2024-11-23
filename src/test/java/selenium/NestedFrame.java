package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class  NestedFrame {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");
    }

    @Test
    public void nestedFrame() {
        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Switch to the first iframe
        WebElement iframeElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[1]")));
        driver.switchTo().frame(iframeElement1);

        // Verify the iframes present in the first iframe
        // This assumes you want to locate the second iframe within the first one
        // You may want to adjust the XPath based on the actual HTML structure
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[2]"))); // Adjust if needed

        // Get the text from the body of the second iframe
        String b = driver.findElement(By.tagName("body")).getText();
        System.out.println(b);

        // Switch back to the parent frame
        driver.switchTo().parentFrame(); // Switches back to the first iframe
    }

    @AfterMethod
    public void tearDown() {
        driver.quit(); // Close the browser
    }
}
