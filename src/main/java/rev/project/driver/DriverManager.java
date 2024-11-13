package rev.project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

interface Driver{
    WebDriver createDriver();
}
class ChromeDriverSupplier implements Driver{
    @Override
    public WebDriver createDriver(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
class FireFoxDriverSupplier implements Driver{
    @Override
    public WebDriver createDriver(){
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
class EdgeDriverSupplier implements Driver{
    public WebDriver createDriver() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
public class DriverManager {
private static BrowserType browserType;
private static WebDriver driver;
private DriverManager(){}
    private static Driver getDriverSupply(BrowserType type){
    switch (type){
        case CHROME:
            return new ChromeDriverSupplier();
        case EDGE:
            return new EdgeDriverSupplier();
        case FIREFOX:
            return new FireFoxDriverSupplier();
        default:
            throw new IllegalArgumentException("This browser not supported");
    }
    }
    // singelton call to driver
    public synchronized static WebDriver getDriver(BrowserType type){
    if(driver==null){
        driver=getDriverSupply(type).createDriver();
    }
    return driver;
    }
public static void quitDriver(){
    if(driver!=null){
        driver.quit();
        driver=null;
    }
}
}
