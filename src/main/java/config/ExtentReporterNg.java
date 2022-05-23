package config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
	
	static ExtentReports extent = new ExtentReports();
	
	public static ExtentReports getReport() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Katana Tet Automation Test Results");
		reporter.config().setDocumentTitle("Katana Tet Automation Test Results");

		extent.attachReporter(reporter);
		
		return extent;
	}

}
