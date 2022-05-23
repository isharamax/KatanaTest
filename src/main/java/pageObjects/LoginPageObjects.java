package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObjects {

	WebDriver driver = null;

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	By email = By.name("email");
	By password = By.name("password");
	By submitBtn = By.name("submit");
	
	
	public void EnterLoginInfo(String emailAdd, String pwd) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(email).sendKeys(emailAdd);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(submitBtn).click();
	}
	
	

}
