package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDown {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void dropDown(){


       Select firstoption=new Select(driver.findElement(By.id("dropdown")));
       firstoption.selectByIndex(1);
       firstoption.selectByValue("2");
       firstoption.selectByVisibleText("Option 1");
       List<WebElement> a=firstoption.getOptions();

        System.out.println(a.get(0).getText());
        System.out.println(a.get(1).getText());
        System.out.println(a.get(2).getText());

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
