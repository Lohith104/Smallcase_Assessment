package com.scenario1_runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.configuration.Configurationhelper;

import Base_class.Selenium_methods;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Lohith\\eclipse-workspace\\Smallcase_Assessment\\src\\test\\java\\com\\scenario1_feature\\Flipkart.feature",
		glue = "com\\scenario1_stepdef",
		monochrome=true,
		strict=true,
		dryRun = false,
		plugin = {"pretty","html:Reports/HTML_report.html",
				"json:Reports/Json_report.json",
				"junit:Reports/Junit.xml",
		"com.cucumber.listener.ExtentCucumberFormatter:Reports/Extent_report.html"})

public class Flipkart_runner extends Selenium_methods{
	
	public static WebDriver driver;	
	
	@BeforeClass
	public static void browserlaunch() throws Exception{

		String browser = Configurationhelper.getInstance().getBrowser();
      
	driver=Selenium_methods.getBrowser(browser);
	}
	
	@AfterClass
	public static void teardown() {
		quit();

	}
	
	
}

