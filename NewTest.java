package practice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;	

public class NewTest {		
	    private WebDriver driver;		
		@Test				
		public void succeeded() {
			driver.get("http://the-internet.herokuapp.com/login");
			driver.findElement(By.id("username")).sendKeys("tomsmith");
			driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
			driver.findElement(By.cssSelector("button")).submit();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(driver.findElement(By.cssSelector(".flash.success")).isDisplayed(),"success message not present");
		}	
		@BeforeTest
		public void beforeTest() {	
		    driver = new ChromeDriver();  
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}	