package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class IPLTable {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("https://www.w3schools.com/sql/sql_where.asp");
        driver.get("https://www.iplt20.com/points-table/men/2024");

    }

    @Test
    public void table() {
//        WebElement tableLocator=driver.findElement(By.xpath("//div[@class=\"w3-responsive\"]//table[@class=\"ws-table-all notranslate\"]"));

        List<WebElement> allCustomerNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allpostalCodes = driver.findElements(By.xpath("//tr//td[6]"));
        int rowCount = Math.min(allCustomerNames.size(), allpostalCodes.size());

        for (int i = 0; i < rowCount; i++) {
            String customerName = allCustomerNames.get(i).getText();

            String postalCode = allpostalCodes.get(i).getText();
            if (postalCode.matches("\\d+")) {
                System.out.println("Customer name :" + customerName + " Postal Code: " + postalCode);
            }
        }
    }

    @Test
    public void iplTeam1(){
       List<WebElement> teamNames=driver.findElements(By.xpath("//h2[@class=\"ih-pt-cont mb-0 ng-binding\"]"));
        List<WebElement> teamPoints=driver.findElements(By.xpath("//td[@class=\"bt ng-binding\"]"));
        int minirow=Math.min(teamNames.size(),teamPoints.size());

Comparator<String>comparator=new Comparator<>(){
    public int compare(String o1,String o2){
        return Integer.compare(Integer.parseInt(o2),Integer.parseInt(o1));
//        Integer points=Integer.parseInt(o2);
//        return points.compareTo(Integer.parseInt(o1));

    }
};
        Map<String,String>mp=new TreeMap<>(comparator);
        for (int i=0;i<minirow;i++){
            String teamName=teamNames.get(i).getText();
            String teamPoint=teamPoints.get(i).getText();
            mp.put(teamPoint,mp.getOrDefault(teamPoint,"")+teamName);
        }
        for(Map.Entry<String,String>i: mp.entrySet()){

            System.out.println("Team Points "+i.getKey()+" and team name "+i.getValue());
        }
    }
    @Test
    public void iplTeam() {
        List<WebElement> teamNames = driver.findElements(By.xpath("//h2[@class=\"ih-pt-cont mb-0 ng-binding\"]"));
        List<WebElement> teamPoints = driver.findElements(By.xpath("//td[@class=\"bt ng-binding\"]"));

        int miniRow = Math.min(teamNames.size(), teamPoints.size());
        Map<String, Integer> teamData = new HashMap<>();

        // Store team names and points in the map
        for (int i = 0; i < miniRow; i++) {
            String teamName = teamNames.get(i).getText();
            String teamPointText = teamPoints.get(i).getText();

                int teamPoint = Integer.parseInt(teamPointText);
                teamData.put(teamName, teamPoint);

        }

        // Convert the map to a list of entries and sort it
        List<Map.Entry<String, Integer>> sortedTeams = new ArrayList<>(teamData.entrySet());
        Collections.sort(sortedTeams, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue()); // Sort in descending order of points
            }
        });

        // Print sorted team names and points
        for (Map.Entry<String, Integer> entry : sortedTeams) {
            System.out.println("Team: " + entry.getKey() + " - Points: " + entry.getValue());
        }
    }

//    @Test
//public void table() {
//    List<WebElement> allCustomerNames = driver.findElements(By.xpath("//tr//td[2]"));
//    List<WebElement> allPostalCodes = driver.findElements(By.xpath("//tr//td[6]"));
//
//    int rowCount = Math.min(allCustomerNames.size(), allPostalCodes.size());
//
//    // Print table header
//    System.out.printf("%-30s | %-15s%n", "Customer Name", "Postal Code");
//
//
//    for (int i = 0; i < rowCount; i++) {
//        String customerName = allCustomerNames.get(i).getText();
//        String postalCode = allPostalCodes.get(i).getText();
//
//        // Only print rows with numeric postal codes
//        if (postalCode.matches("\\d+")) {  // check if the postal code contains only digits
//            System.out.printf("%-30s | %-15s%n", customerName, postalCode);
//        }
//    }
//}

    @Test
    void iplTeamTest(){
        List<WebElement>teamNames=driver.findElements(By.xpath("//h2[@class='ih-pt-cont mb-0 ng-binding']"));
        List<WebElement>teamPoints=driver.findElements(By.xpath("//td[@class=\"bt ng-binding\"]"));
        int maxi=Math.min(teamNames.size(),teamPoints.size());
        Map<String,String>mp=new LinkedHashMap<>();
        for(int i = 0; i<maxi; i++){
            String teamName=teamNames.get(i).getText();
            String teamPoint=teamPoints.get(i).getText();
            mp.put(teamName,mp.getOrDefault(teamName," ")+teamPoint);
        }
        for(Map.Entry<String,String>mp1:mp.entrySet()){
            System.out.println(mp1.getKey()+" : "+mp1.getValue());
        }

    }

    @Test
    void iplTeamTestUsingComparator(){
        List<WebElement>teamNames=driver.findElements(By.xpath("//h2[@class='ih-pt-cont mb-0 ng-binding']"));
        List<WebElement>teamPoints=driver.findElements(By.xpath("//td[@class=\"bt ng-binding\"]"));
        int maxi=Math.min(teamNames.size(),teamPoints.size());
        Comparator <String>comparator=new Comparator<>(){

            public int compare(String o1,String o2){
                return Integer.compare(Integer.parseInt(o1),Integer.parseInt(o2));
            }
        };
        Map<String,String>mp=new TreeMap<>(comparator);
        for(int i = 0; i<maxi; i++){

            String teamName=teamNames.get(i).getText();
            String teamPoint=teamPoints.get(i).getText();
            mp.put(teamPoint,mp.getOrDefault(teamPoint," ")+teamName);
//            mp.put(teamPoint,teamName);
        }
        for(Map.Entry<String,String>mp1:mp.entrySet()){
            System.out.println(mp1.getKey()+" : "+mp1.getValue());
        }

    }
    @Test
    void iplTeamTestUsingList(){
        List<WebElement>teamNames=driver.findElements(By.xpath("//h2[@class='ih-pt-cont mb-0 ng-binding']"));
        List<WebElement>teamPoints=driver.findElements(By.xpath("//td[@class=\"bt ng-binding\"]"));
        int maxi=Math.min(teamNames.size(),teamPoints.size());
       for (int i=0;i<maxi;i++){
           String teamName=teamNames.get(i).getText();
           String teamPoint=teamPoints.get(i).getText();
           System.out.println("Team Name"+teamName+" and team Points"+teamPoint);
       }

    }
    @Test
    void iplTeamTestUsingIntegerKeysWithMultipleTeams() {
        List<WebElement> teamNames = driver.findElements(By.xpath("//h2[@class='ih-pt-cont mb-0 ng-binding']"));
        List<WebElement> teamPoints = driver.findElements(By.xpath("//td[@class=\"bt ng-binding\"]"));
        int maxi = Math.min(teamNames.size(), teamPoints.size());

        // TreeMap to store points as keys and a list of team names as values
        Map<Integer, List<String>> mp = new TreeMap<>();

        for (int i = 0; i < maxi; i++) {
            String teamName = teamNames.get(i).getText();
            int teamPoint = Integer.parseInt(teamPoints.get(i).getText()); // Convert points to Integer

            // Add team name to the list for the given points
            mp.computeIfAbsent(teamPoint, k -> new ArrayList<>()).add(teamName);
        }

        // Print the sorted map
        for (Map.Entry<Integer, List<String>> entry : mp.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            System.out.println(String.join(", ", entry.getValue())); // Join team names with commas
        }
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


