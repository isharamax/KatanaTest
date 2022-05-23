package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import testCases.TestCase;

public class PropertiesFile {

	public static void readPropertiesFile() throws IOException {
		Properties prop = new Properties();

		InputStream input = new FileInputStream(
				"E:\\selenium\\selenium\\eclipseWorkspace\\KatanaTest\\src\\main\\java\\config\\data.properties");
		prop.load(input);
		TestCase.webdriver = prop.getProperty("webdriver");
		TestCase.url = prop.getProperty("url");
		TestCase.chromeExeLocation = prop.getProperty("chromeLocation");
		TestCase.username = prop.getProperty("userName");
		TestCase.pwd = prop.getProperty("pwd");

	};
}
