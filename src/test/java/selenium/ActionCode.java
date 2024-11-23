package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class ActionCode {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }
    @Test
    public void dragAndDrop(){
        Actions obj=new Actions(driver);
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(100));
       WebElement dragandDropLink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Drag and Drop']")));
//        WebElement dragandDropLink=driver.findElement(By.xpath("//mark[@class='cb7bc01f default-orange-da01945e-1964-4d27-8a6c-3331e1fe7f14']"));
        dragandDropLink.click();
        WebElement item1=driver.findElement(By.id("column-a"));
        WebElement item2=driver.findElement(By.id("column-b"));

        obj.dragAndDrop(item1,item2).build().perform();

    }
    @Test(description = "checking hovering")
    public void hover(){
        Actions obj=new Actions(driver);
        WebElement hoverElement=driver.findElement(By.xpath("//a[text()='Hovers']"));
        hoverElement.click();
        WebElement hoverImage=driver.findElement(By.xpath("//*[@id=\"content\"]"));
        obj.moveToElement(hoverImage).perform();

    }
    @Test(description = "checking context menu")
    public void context(){
        Actions obj=new Actions(driver);
        WebElement hoverElement=driver.findElement(By.xpath("//a[text()='Context Menu']"));
        hoverElement.click();
        WebElement rightClick=driver.findElement(By.id("hot-spot"));
        obj.contextClick(rightClick).perform();

    }

}
