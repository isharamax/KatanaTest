package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import config.PropertiesFile;
import junit.framework.Assert;
import pageObjects.ContactsPageObjects;
import pageObjects.CustomerPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.SalesOrderPageObjects;



@Listeners({ listners.TestNGListners.class})


public class TestCase {

	public static String webdriver;
	public static String chromeExeLocation;
	public static String username;
	public static String pwd;
	public static String url;

	WebDriver driver = null;
	ChromeOptions options = new ChromeOptions();
	ExtentReports extent = new ExtentReports();

	Properties prop = new Properties();



	@BeforeMethod
	public void LaunchBrowser() throws IOException {

		PropertiesFile.readPropertiesFile();// Read global variables defined in properties file

		System.setProperty(webdriver, chromeExeLocation);
		// headless mode
		options.addArguments("--headless");
		options.addArguments("window-size=1280,800");
		driver = new ChromeDriver(options);

		// driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(url);

	}

	@Test(priority = 1) // Testcase #1 : Add customer from Global Add Button menu
	public void customerAddGlobalButton() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		HomePageObjects objHome = new HomePageObjects(driver);
		CustomerPageObjects objCust = new CustomerPageObjects(driver);
		ContactsPageObjects objContacts = new ContactsPageObjects(driver);
		LoginPageObjects objLogin = new LoginPageObjects(driver);
		SalesOrderPageObjects objSales = new SalesOrderPageObjects(driver);

		objLogin.EnterLoginInfo(username, pwd);
		objHome.globalAddClick();
		objHome.clickCustomerAdd();
		Thread.sleep(1000);
		objCust.pageConfirm();

		objCust.enterCustomerDetailsBasic("Ishara", "Pathirana", "Mobitel", "ishara@gmail.com", "0715420338",
				"Test comment 1");

		objCust.enterDefaultBillDetails("Vinavi", "Hansani", "ABC", "0715445667", "Colombo 1", "Colombo 2", "Colombo",
				"Western", "10100", "Sri Lanka");

		objCust.enterDefaultShippingDetails("Akindu", "Pathirana", "DEF", "0772383471", "Col 2", "Col 3", "Colombo",
				"Western", "10100", "Sri Lanka");

		System.out.println("Test 1 passed");

	}

	@Test(priority = 2) // Testcase #2 : Add customer from Sales Order
	public void customerAddfromSalesOrder() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		HomePageObjects objHome = new HomePageObjects(driver);
		CustomerPageObjects objCust = new CustomerPageObjects(driver);
		ContactsPageObjects objContacts = new ContactsPageObjects(driver);
		LoginPageObjects objLogin = new LoginPageObjects(driver);
		SalesOrderPageObjects objSales = new SalesOrderPageObjects(driver);

		objLogin.EnterLoginInfo(username, pwd);
		objHome.globalAddClick();
		objHome.clickSalesOrder();
		objSales.enterCustomer("TestUser");
		System.out.println("Test 2 passed");

	}

	@Test(priority = 3) // Testcase #3 : Verify Sales Order No contains customer name and generated SO
						// no
	public void verifySONo() throws InterruptedException {
		HomePageObjects objHome = new HomePageObjects(driver);
		CustomerPageObjects objCust = new CustomerPageObjects(driver);
		ContactsPageObjects objContacts = new ContactsPageObjects(driver);
		LoginPageObjects objLogin = new LoginPageObjects(driver);
		SalesOrderPageObjects objSales = new SalesOrderPageObjects(driver);

		objLogin.EnterLoginInfo(username, pwd);
		objHome.globalAddClick();
		objHome.clickSalesOrder();
		objSales.enterCustomer("Ishara Pathirana");
		objSales.verifySoNo("Ishara Pathirana");
		System.out.println("Test 3 passed");

	}

	@Test(priority = 4) // Testcase #4 : Editing customer address on Sales Order
	// page
	public void editCustAddressSalesOrder() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		HomePageObjects objHome = new HomePageObjects(driver);
		CustomerPageObjects objCust = new CustomerPageObjects(driver);
		ContactsPageObjects objContacts = new ContactsPageObjects(driver);
		LoginPageObjects objLogin = new LoginPageObjects(driver);
		SalesOrderPageObjects objSales = new SalesOrderPageObjects(driver);

		objLogin.EnterLoginInfo(username, pwd);
		objHome.globalAddClick();
		objHome.clickSalesOrder();
		objSales.enterCustomer("Ishara");
		objSales.clickBillAddress();
		objCust.editBillingAddress("New Add1", "New Add2", "New city1", "New State 1", "10200", "Estonia");
		objContacts.searchContacts("Ishara");
		System.out.println("Test 4 passed");

	}

	@Test(priority = 5) // Testcase #5 : Check color of the email text label
	// turns to red if
	// user entered invalid format for email
	public void validateEmailCustomerAdd() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		HomePageObjects objHome = new HomePageObjects(driver);
		CustomerPageObjects objCust = new CustomerPageObjects(driver);
		ContactsPageObjects objContacts = new ContactsPageObjects(driver);
		LoginPageObjects objLogin = new LoginPageObjects(driver);
		SalesOrderPageObjects objSales = new SalesOrderPageObjects(driver);

		objLogin.EnterLoginInfo(username, pwd);
		objHome.globalAddClick();
		Thread.sleep(1000);
		objHome.clickCustomerAdd();
		Thread.sleep(1000);
		objCust.pageConfirm();

		objCust.enterCustomerDetailsBasic(" ", " ", " ", "emailabcdef", " ", " ");
		Thread.sleep(2000);
		objCust.verifyEmailLabelColor();

		System.out.println("Test 5 passed");

	}

	@Test(priority = 6) // Testcase #6 :Search existing customer from contacts
	public void searchExistingCustomer() throws InterruptedException {

		ContactsPageObjects objContacts = new ContactsPageObjects(driver);
		LoginPageObjects objLogin = new LoginPageObjects(driver);
		HomePageObjects objHome = new HomePageObjects(driver);

		objLogin.EnterLoginInfo(username, pwd);
		objHome.globalAddClick();
		objHome.clickCustomerAdd();
		objContacts.searchContacts("Ishara");
		System.out.println("Test 6 passed");
	}

	@Test(priority = 7) // Testcase #7 :Check color of the Display Name text label turns to red display
						// name is empty
	public void validateDisplayName() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		HomePageObjects objHome = new HomePageObjects(driver);
		CustomerPageObjects objCust = new CustomerPageObjects(driver);
		ContactsPageObjects objContacts = new ContactsPageObjects(driver);
		LoginPageObjects objLogin = new LoginPageObjects(driver);
		SalesOrderPageObjects objSales = new SalesOrderPageObjects(driver);

		objLogin.EnterLoginInfo(username, pwd);
		objHome.globalAddClick();
		objHome.clickCustomerAdd();
		WebElement textDisplayName = driver.findElement(objCust.displayNameText);
		WebElement LabelDisplayName = driver.findElement(objCust.displayNameLabel);

		String ColotxtDisplayName = LabelDisplayName.getCssValue("color");

		String txtDisplayName = textDisplayName.getAttribute("value");

		if ((txtDisplayName.isEmpty())) {
			Assert.assertTrue(ColotxtDisplayName.contains("rgba(228, 44, 0, 1)"));
			System.out.println("Test 7 passed");
		}

	}

	@Test(priority = 8)
	public void deleteExistingCustomer() throws InterruptedException {
		HomePageObjects objHome = new HomePageObjects(driver);
		CustomerPageObjects objCust = new CustomerPageObjects(driver);
		ContactsPageObjects objContacts = new ContactsPageObjects(driver);
		LoginPageObjects objLogin = new LoginPageObjects(driver);
		SalesOrderPageObjects objSales = new SalesOrderPageObjects(driver);

		objLogin.EnterLoginInfo(username, pwd);
		objHome.globalAddClick();
		objHome.clickCustomerAdd();
		objContacts.searchContacts("Ishara Pathirana");
		objCust.deleteCust();
		System.out.println("Test 8 passed");

	}

	// @AfterMethod
	public void quitTest() {
		driver.quit();
	}
}
