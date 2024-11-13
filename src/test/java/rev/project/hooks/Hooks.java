package rev.project.hooks;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;
import rev.project.driver.BrowserType;
import rev.project.driver.DriverManager;


public class Hooks {


    private WebDriver driver;

    @Before
    public void setup(){

        driver= DriverManager.getDriver(BrowserType.CHROME);

    }
//    @After
    public void tearDown(){
//        driver.quit();
        DriverManager.quitDriver();
    }




}
