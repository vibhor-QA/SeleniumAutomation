package NewPackageJava;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class NewClassJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new FirefoxDriver();
		driver.get("http://www.guru99.com/selenium-tutorial.html");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Free Selenium Tutorials"));
		driver.quit();
	}

}
