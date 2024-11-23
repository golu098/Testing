package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void MultipleWindow(){
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        String originalWindow=driver.getWindowHandle();
        Set<String> windowHandles=driver.getWindowHandles();
        for(String i:windowHandles){
            if(!i.equals(originalWindow)){
                driver.switchTo().window(i);
                break;
            }
        }
        System.out.println(driver.getTitle()+" "+driver.getCurrentUrl());
        driver.switchTo().window(originalWindow);
        System.out.println(driver.getTitle()+" "+driver.getCurrentUrl());


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
