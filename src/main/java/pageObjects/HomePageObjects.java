package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObjects {
	

	WebDriver driver = null;

	By GlobalAdd = By.xpath("//button[@id='globalAdd']");
	By customerAdd = By.xpath("//div[@class='MuiListItemText-root MuiListItemText-dense']/span[starts-with(text(),'Customer')]");
	By salesOrder = By.id("add-sales");
	
	
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void globalAddClick() {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
		w.until(ExpectedConditions.presenceOfElementLocated(GlobalAdd));
		driver.findElement(GlobalAdd).click();

	}

	public void clickCustomerAdd() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(customerAdd).click();
	}

	public void clickSalesOrder() {
		
		driver.findElement(salesOrder).click();
	}
	
}
