package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertCode {
   WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void jsAlert(){
        WebElement resConfirm=driver.findElement(By.xpath("//p[@id='result']"));
      WebElement jsalert= driver.findElement(By.xpath("//button[text()=\"Click for JS Alert\"]"));
      jsalert.click();
        Alert jsAlertVar=driver.switchTo().alert();
        System.out.println(jsAlertVar.getText());
        jsAlertVar.accept();
        System.out.println(resConfirm.getText());

        WebElement jsConfirm=driver.findElement(By.xpath("//button[text()=\"Click for JS Confirm\"]"));
        jsConfirm.click();
        Alert jsConfirmVar=driver.switchTo().alert();
        System.out.println(jsConfirmVar.getText());
//        jsConfirmVar.accept();
        jsConfirmVar.dismiss();

        String resConfirmText=resConfirm.getText();
        System.out.println(resConfirmText);

        WebElement jsPrompt =driver.findElement(By.xpath("//button[text()=\"Click for JS Prompt\"]"));
        jsPrompt.click();
        Alert jsPromptVar=driver.switchTo().alert();
        System.out.println(jsPromptVar.getText());
        jsPromptVar.sendKeys("Shiv kant");
        jsPromptVar.accept();
        System.out.println(resConfirm.getText());
//
//
//
////


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
