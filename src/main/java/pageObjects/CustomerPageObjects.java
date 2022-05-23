package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class CustomerPageObjects {

	
	WebDriver driver = null;

	public static By firstName = By.name("firstName");
	By lastName = By.name("lastName");
	By company = By.name("company");
	public By displayNameText = By.xpath("//input[@name='name']");
	public By displayNameLabel = By.xpath("//label[starts-with(text(),'Display name')]");
	By defaultBillAddress = By.name("defaultBillingAddress");
	By defaultShippingAddress = By.xpath("//input[@name='defaultShippingAddress']");
	By email = By.name("email");
	By phone = By.name("phone");
	By comment = By.name("comment");
	By billFname = By.xpath("/html/body/div[8]/div[3]/div/div[2]/div/div[1]/div[1]/div/input");
	By billLname = By.xpath("/html/body/div[8]/div[3]/div/div[2]/div/div[1]/div[2]/div/input");
	By billCmpny = By.xpath("/html/body/div[8]/div[3]/div/div[2]/div/div[1]/div[3]/div/input");
	By billPhone = By.xpath("/html/body/div[8]/div[3]/div/div[2]/div/div[1]/div[4]/div/input");
	By billAdd1 = By.xpath("//div/div/input[@name='line1']");
	By billAdd2 = By.xpath("//div/div/input[@name='line2']");
	By billCity = By.xpath("//div/div/input[@name='city']");
	By billState = By.xpath("//div/div/input[@name='state']");
	By billZip = By.xpath("//div/div/input[@name='zip']");
	By country = By.xpath("//div/div/input[@name='country']");
	By submit = By.xpath("//div/div/button[@id='submitButton']");
	By cancel = By.xpath("//div/div/button[@id='cancelButton']");
	By notSaved = By.xpath("//div[@class='jss45 notSaved katana-label print-hide']");
	public By emailTxt =By.xpath("//label[starts-with(text(),'Email')]");
	By closeCustWindow = By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-align-items-xs-center MuiGrid-justify-content-xs-flex-end']/button[@class='MuiButtonBase-root MuiIconButton-root print-hide'][1]");
	By settings = By.xpath("//span[@class='print-hide']/button[@class='MuiButtonBase-root MuiIconButton-root']");
	By delete = By.xpath("//ul/li[@data-testid='cardHeaderMenuButtonDELETE']"); 
	By yesBtn = By.xpath("//button[@data-testid='confirmDeleteButton']/span[@class='MuiButton-label']");
	
	
	
	public CustomerPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void pageConfirm() {
		Assert.assertTrue(driver.getCurrentUrl().contains("https://factory.katanamrp.com/customer"));
	}

	public String enterCustomerDetailsBasic(String fName, String lName, String cmpny, String e_mail, String phoneNo,
			String cmmnt) throws InterruptedException {
		Actions action =new Actions(driver);
		
		driver.findElement(firstName).sendKeys(fName);
		Thread.sleep(2000);
		action.sendKeys(Keys.TAB);
		driver.findElement(lastName).sendKeys(lName);
		Thread.sleep(2000);
		action.sendKeys(Keys.TAB);
		driver.findElement(company).sendKeys(cmpny);
		Thread.sleep(2000);
		action.sendKeys(Keys.TAB);
		driver.findElement(email).sendKeys(e_mail);
		action.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		driver.findElement(phone).sendKeys(phoneNo);
		action.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		driver.findElement(comment).sendKeys(cmmnt);
		Thread.sleep(2000);
		return fName;

	}

	public void enterDefaultBillDetails(String firstN, String lastN, String compny, String phone, String add1,
			String add2, String city, String state, String zip, String ctry) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(defaultBillAddress).click();
		driver.findElement(billFname).sendKeys(firstN);
		driver.findElement(billLname).sendKeys(lastN);
		driver.findElement(billCmpny).sendKeys(compny);
		driver.findElement(billPhone).sendKeys(phone);
		driver.findElement(billAdd1).sendKeys(add1);
		driver.findElement(billAdd2).sendKeys(add2);
		driver.findElement(billCity).sendKeys(city);
		driver.findElement(billState).sendKeys(state);
		driver.findElement(billZip).sendKeys(zip);
		driver.findElement(country).sendKeys(ctry);
		driver.findElement(submit).click();

	}
	
	public void enterDefaultShippingDetails(String firstN, String lastN, String compny, String phone, String add1,
			String add2, String city, String state, String zip, String ctry) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(defaultShippingAddress).click();
		driver.findElement(billFname).sendKeys(firstN);
		driver.findElement(billLname).sendKeys(lastN);
		driver.findElement(billCmpny).sendKeys(compny);
		driver.findElement(billPhone).sendKeys(phone);
		driver.findElement(billAdd1).sendKeys(add1);
		driver.findElement(billAdd2).sendKeys(add2);
		driver.findElement(billCity).sendKeys(city);
		driver.findElement(billState).sendKeys(state);
		driver.findElement(billZip).sendKeys(zip);
		driver.findElement(country).sendKeys(ctry);
		driver.findElement(submit).click();
	}
	
	public void editBillingAddress(String add1,
			String add2, String city, String state, String zip, String ctry) throws InterruptedException {
		driver.findElement(billAdd1).clear();
		driver.findElement(billAdd1).sendKeys(add1);
		driver.findElement(billAdd2).clear();
		driver.findElement(billAdd2).sendKeys(add2);
		driver.findElement(billCity).clear();
		driver.findElement(billCity).sendKeys(city);
		driver.findElement(billState).clear();
		driver.findElement(billState).sendKeys(state);
		driver.findElement(billZip).clear();
		driver.findElement(billZip).sendKeys(zip);
		driver.findElement(country).clear();
		driver.findElement(country).sendKeys(ctry);
		driver.findElement(submit).click();

	}

	public void deleteCust() throws InterruptedException {
		driver.findElement(settings).click();
		Thread.sleep(1000);
		driver.findElement(delete).click();
		Thread.sleep(1000);
		driver.findElement(yesBtn).click();
		Thread.sleep(2000);
	}
	
	public void verifyEmailLabelColor() {
		WebElement emailTxt = driver.findElement(By.xpath("//label[starts-with(text(),'Email')]"));
		String colorTxt = emailTxt.getCssValue("color");
		Assert.assertTrue(colorTxt.contains("rgba(228, 44, 0, 1)"));// convert red #e42c00 to rgba pattern
	}
	
	
}
