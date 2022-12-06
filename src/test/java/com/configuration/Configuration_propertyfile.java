package com.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration_propertyfile {
	public static Properties pro;
	
	public Configuration_propertyfile() throws IOException {
		
		File file=new File("C:\\Users\\Lohith\\eclipse-workspace\\Smallcase_Assessment\\resource\\com\\smallcase\\properties\\config.properties");
		
		FileInputStream input=new FileInputStream(file);
		
		pro=new Properties();
		pro.load(input);
	}
	
	public String getBrowser() {
		String browser = pro.getProperty("browser");
		return browser;
	}

	public String getFlipkartURL() {
		String flipkarturl = pro.getProperty("FlipkartURL");
		return flipkarturl;
	}
	
	public String getSearch_box() {
		String search=pro.getProperty("Search_text");
		return search;
	}
	
	public String getprod_quantity() {
		String quantity=pro.getProperty("product_quatity");
		return  quantity;
	}
	
	public String getscreenshot_filename() {
		String filename=pro.getProperty("ScreenShot");
		return  filename;
	}
	
	public String getinputtext() {
		String input_text = pro.getProperty("Searchttext");
		return input_text;
	}
	public String getAmazonURL() {
		String amazon_url = pro.getProperty("AmazonURL");
		return amazon_url;

	}
	

}
