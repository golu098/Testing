package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;



public class JavascriptExecutorCode {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }
    @Test
    public void test(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.backgroundColor = arguments[0];", "black");
//        js.executeScript("window.scrollBy(0,10000);");
        WebElement element=driver.findElement(By.xpath("//a[text()='WYSIWYG Editor']"));
        js.executeScript("arguments[0].scrollIntoView(true);",element);

    }
}
