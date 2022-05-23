package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class SalesOrderPageObjects {
	WebDriver driver = null;
	By dropdownName = By.xpath("//input[@placeholder='Search or create customer']");
	By billAddress = By.xpath("//div[@data-testid='address-field-location']");
	By salesorderNo = By.xpath("//input[@name='orderNo']");
	By salesorderLabel = By.xpath("//h6/span[@data-testid='header-name-salesOrder']");

	public SalesOrderPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void enterCustomer(String newCust) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(dropdownName).click();
		driver.findElement(dropdownName).sendKeys(newCust);
		Thread.sleep(2000);
		driver.findElement(dropdownName).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(dropdownName).sendKeys(Keys.ENTER);
		
	}

	public void verifySoNo(String CustName) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.findElement(dropdownName).sendKeys(custName);
		
		String SONo = driver.findElement(salesorderNo).getAttribute("value");
		Thread.sleep(1000);
		String expectfinalSO = SONo+" "+CustName;
		String ActfinalSO = driver.findElement(salesorderLabel).getText();

		if (ActfinalSO.equals(expectfinalSO)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	public void clickBillAddress() {
		driver.findElement(billAddress).click();
	}

}
