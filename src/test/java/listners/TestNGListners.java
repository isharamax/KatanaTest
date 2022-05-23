package listners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import config.ExtentReporterNg;



public class TestNGListners implements ITestListener{

	ExtentTest test;
	ExtentReports extent= ExtentReporterNg.getReport();
	
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test started:"+" "+result.getMethod().getMethodName());
		test= extent.createTest(result.getMethod().getMethodName());
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		
		test.fail(result.getThrowable());
		
		String methodName= result.getMethod().getMethodName();
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
