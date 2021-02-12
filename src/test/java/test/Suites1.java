package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Suites1 {
	
	//co response to statement
	//@Test(priority =1,enabled=false)
	@Test(priority =1)
	public void register() {
		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://magento.com");
        driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
        driver.findElement(By.id("register")).click();
        driver.findElement(By.id("firstname")).sendKeys("Sheetal");
        driver.findElement(By.id("lastname")).sendKeys("Bhavsar");
        driver.findElement(By.id("email_address")).sendKeys("sbhavsar01@hotmail.com");
        //select class for drop down menu
        Select cp = new Select(driver.findElement(By.id("company_type")));
        cp.selectByIndex(3);
        
        Select cp1 = new Select(driver.findElement(By.id("individual_role")));
        cp1.selectByIndex(1);
        

        Select cp2 = new Select(driver.findElement(By.id("individual_role")));
        cp2.selectByIndex(1);
        
        Select country = new Select(driver.findElement(By.id("country")));
       country.selectByVisibleText("United States");
        
        
        //cp.selectByValue("development");
       // cp.deselectByVisibleText("Provides deployment, cutomization and integration services to merchants");
        
        
        driver.findElement(By.id("password")).sendKeys("Welcom123");
        driver.findElement(By.id("password-confirmation")).sendKeys("Welcome123");
        
      // driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"msp-recaptcha-d84b65fc916e7398083ea5f17089d8f1\"]/div/div/iframe"))); 
     //  driver.findElement(By.className("recaptcha-checkbox-border")).click();
      // driver.switchTo().defaultContent();
        if(!driver.findElement(By.id("agree_terms")).isSelected())
        {
        	driver.findElement(By.id("agree_terms")).click();
        }
        
        driver.quit();
		
	}
	
	@Test(priority =2)	
	public void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.get("http://magento.com");
	        driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
	        
	        driver.findElement(By.id("email")).sendKeys("sbhavsar01@hotmail.com");			
	        driver.findElement(By.id("pass")).sendKeys("Welcome");
	        driver.findElement(By.id("send2")).click();
	        Thread.sleep(5000);
	        
	        System.out.println(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText());
	        
	        driver.quit();
	        
	}
	
	

}
