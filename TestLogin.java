package example;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;
import pageobject.Login;

public class TestLogin {	
	    private WebDriver driver;	
	    private Login login;
	    
		@Test				
		public void succeeded() {
			login.with("tomsmith","SuperSecretPassword!");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(login.successMessagePresent(),"success message not present");
		}
		
		@Test				
		public void failed() {
			login.with("tomsmith","BadPassword!");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(login.failureMessagePresent(),"failure message not present");
		}
		
		@BeforeTest
		public void beforeTest() {	
		    driver = new FirefoxDriver();  
		    login = new Login(driver);
		}		
		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}	