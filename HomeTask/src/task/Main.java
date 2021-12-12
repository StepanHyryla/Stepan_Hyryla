package task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){
        WebDriver driver;

        //Should be changed, if .exe file is placed in other directory
        String ref = "C:\\Users\\HomeOffice\\eclipse-workspace\\HomeTask\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", ref);
        driver = new ChromeDriver();

        // Go to webpage mentioned in task
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Login
        
        WebElement name_field = driver.findElement(By.id("txtUsername"));
        WebElement password_field = driver.findElement(By.id("txtPassword"));
        WebElement button = driver.findElement(By.id("btnLogin"));
        name_field.sendKeys("Admin");
        password_field.sendKeys("admin123");
        button.click();

        // Adding new job
        
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewJobTitleList");
        button = driver.findElement(By.id("btnAdd"));
        button.click();
        
        String Job_title = "Job";
        String Job_description = "Common description";
        String Job_note = "Common note";
        
        
        WebElement name = driver.findElement(By.id("jobTitle_jobTitle"));
        name.sendKeys(Job_title);
        driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(Job_description);
        driver.findElement(By.id("jobTitle_note")).sendKeys(Job_note);
       

        button = driver.findElement(By.id("btnSave"));
        button.click();

        // Check added title
        
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewJobTitleList");
		List<WebElement> rows = driver.findElement(By.id("resultTable")).findElements(By.tagName("tr"));
       
        List<String> addedVals = Arrays.asList("", Job_title, Job_description);
        int addedRowNumber = 0;
        for(WebElement row : rows) {
            List<String> cols = row.findElements(By.tagName("td")).stream().map(val -> val.getText()).toList();
            if (cols.equals(addedVals)) {
                break;
            }
            addedRowNumber++;
        }

        System.out.println("Added row was found at position ¹" + addedRowNumber);
        
        //Modifying job title
        
        String Modified_job_description = "Modified description";
        rows.get(addedRowNumber).findElement(By.tagName("a")).click();
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("jobTitle_jobDescription")).clear();
        driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(Modified_job_description);
        driver.findElement(By.id("btnSave")).click();
        
        //Check modified title
        
        rows = driver.findElement(By.id("resultTable")).findElements(By.tagName("tr"));
        List<String> modifiedVals = Arrays.asList("", Job_title, Modified_job_description);
        for(WebElement row : rows) {
            List<String> cols = row.findElements(By.tagName("td")).stream().map(val -> val.getText()).toList();
            if (cols.equals(modifiedVals)) {
            	System.out.println("Ñhanges have been applied! ");
            	break;
            }
        }

        // Deleting

        rows.get(addedRowNumber).findElement(By.tagName("input")).click();
        driver.findElement(By.id("btnDelete")).click();
        driver.findElement(By.id("dialogDeleteBtn")).click();
        System.out.println("Title has been deleted succesfully!");
        
    }
    
}