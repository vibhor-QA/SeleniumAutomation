package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {
	
	WebDriver driver;
	By usernamelocator = By.id("username");
	By passwordlocator = By.id("password");
	By loginformlocator = By.id("login");
	By successmessagelocator = By.cssSelector(".flash.success");
	By failuremessagelocator = By.cssSelector(".flash.error");
	
	public Login(WebDriver driver){
		this.driver = driver;
		this.driver.get("http://the-internet.herokuapp.com/login");
		Assert.assertTrue(driver.findElement(By.id("login")).isDisplayed());
	}
	
	public void with(String username, String password) {
		driver.findElement(usernamelocator).sendKeys(username);
		driver.findElement(passwordlocator).sendKeys(password);
		driver.findElement(loginformlocator).submit();
	}
	
	public Boolean successMessagePresent() {
		return driver.findElement(successmessagelocator).isDisplayed();
	}
	
	public Boolean failureMessagePresent() {
		return driver.findElement(failuremessagelocator).isDisplayed();
	}

}
