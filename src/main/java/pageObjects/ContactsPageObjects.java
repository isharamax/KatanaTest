package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContactsPageObjects {

	WebDriver driver = null;

	public ContactsPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	CustomerPageObjects objCust = new CustomerPageObjects(driver);

	By searchTextBox = By.xpath("//input[@data-testid='nameFilterInput']");
	By contacts = By.xpath("//a[@id='contactsTab']");

	public void searchContacts(String searchText) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		By cell = By.linkText(searchText);
		
		driver.findElement(contacts).click();
		driver.findElement(searchTextBox).sendKeys(searchText);
		driver.findElement(cell).click();

		

	
	}

}
