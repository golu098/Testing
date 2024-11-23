package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class FlipkartAddToCartItem {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    int totalSum = 0;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);

    }
    @Test
    public void checkCart() throws InterruptedException {
        WebElement search = driver.findElement(By.xpath("//input[@class = 'Pke_EE']"));
        search.sendKeys("iphone", Keys.ENTER);

        List<WebElement> iphoneProducts = driver.findElements(By.xpath("//div[@class = 'KzDlHZ']"));
        String originalTab = driver.getWindowHandle();
        clickProduct(originalTab,iphoneProducts,1);
//        driver.switchTo().window(originalTab);
        clickProduct(originalTab,iphoneProducts,3);

        WebElement cart = driver.findElement(By.className("_9Wy27C"));
        cart.click();
        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = '_1Y9Lgu']//span//div[@class = '_1Y9Lgu']//span")));

        int price = Integer.parseInt(priceElement.getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(totalSum,price,"Price is not equal");

    }

    public void clickProduct(String originalTab, List<WebElement> iphoneProducts, int position){
        iphoneProducts.get(position).click();
        Set<String> allTabs = driver.getWindowHandles();
        for(String tab : allTabs){
            if(!tab.equals(originalTab)){
                driver.switchTo().window(tab);
                break;
            }
        }
        int price = Integer.parseInt(driver.findElement(By.xpath("//div[contains(@class,'Nx9bqj CxhGGd')]")).getText().replaceAll("[^0-9]", ""));

        WebElement addToCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'QqFHMw vslbG+ In9uk2')]")));
        addToCart.click();
        totalSum += price;
        System.out.println(totalSum);
        driver.close();
        driver.switchTo().window(originalTab);
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}