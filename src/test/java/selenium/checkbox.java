package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class checkbox {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkbox(){
        Wait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
       WebElement checkbox1= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@id='checkboxes']//input[1]"))));
//        WebElement checkbox1= driver.findElement(By.xpath("//form[@id='checkboxes']//input[1]"));
        WebElement checkbox2= driver.findElement(By.xpath("//form[@id='checkboxes']//input[2]"));


//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='checkboxes']//input[1]")));
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }
        if(!checkbox2.isSelected()){
            checkbox2.click();
        }
        Assert.assertTrue(checkbox1.isSelected(), "1st checkbox is clickable");
        Assert.assertTrue(checkbox2.isSelected(), "2nd checkbox is clickable");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
