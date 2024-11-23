package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SalaryWebTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        List<WebElement>contactList=driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement>salaryList=driver.findElements(By.xpath("//tr//td[4]"));
        int maxi=Math.min(contactList.size(),salaryList.size());
        Map<String,String> mp=new TreeMap<>();
        for(int i=0;i<maxi;i++){
            String contactName=contactList.get(i).getText();
            String salary=salaryList.get(i).getText();
            mp.put(salary,contactName);
        }
        for(Map.Entry<String,String>i:mp.entrySet()){
            System.out.println(i.getKey()+" : "+i.getValue());
        }

        for(int i=0;i<maxi;i++){
            String contactName=contactList.get(i).getText();
            String salary=salaryList.get(i).getText();
            if(contactName.contains("a-z")) {
                System.out.println("Contact Name " + contactName + " : " + salary);
            }
        }

    }

    }

