package com.scenario2_Testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.configuration.Configurationhelper;
import com.configuration.RetryAnalyzer;

import Base_class.Selenium_methods;
import SDP_Flipkart.Single_design;
import SDP_amazon.Single_amazon;

public class Flipkart_Amazon extends Selenium_methods {

	public static WebDriver driver;

	public static String product_page;
	public static WebElement cart_price;
	public static int Flipkart_cartPrice;
	public static int Amazon_cartPrice;

	@BeforeSuite
	public void browser_launch() throws IOException, Exception {
		driver = getBrowser(Configurationhelper.getInstance().getBrowser());
	}

	public static void flipkart_price() {
		String text = text(cart_price);
		String replace = text.replace("₹", "").replace(",", "");
		Flipkart_cartPrice = Integer.parseInt(replace);
		System.out.println("Product price in Flipkart is  " + Flipkart_cartPrice);

	}

	public static void amazon_price() {
		String price = text(cart_price);
		String replace = price.replace(",", "").replace(".00", "").replace("  ", "");
		Amazon_cartPrice = Integer.parseInt(replace);
		System.out.println("Product price in Amazon is " + Amazon_cartPrice);

	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void flipkart_addtoCart() throws IOException, InterruptedException {
		Single_design flipkart = new Single_design(driver);

		getUrl(Configurationhelper.getInstance().getFlipkartURL());

		clickonWebelement(flipkart.getHp().getClose_login());

		String search_box = Configurationhelper.getInstance().getinputtext();
		inputValuestoWebelement(flipkart.getHp().getSearch_box(), search_box);
		clickonWebelement(flipkart.getHp().getSearch());

		product_page = driver.getWindowHandle();
		page_title();
		clickonWebelement(flipkart.getCategory().getPhone_redmi());

		System.out.print("Product price in Flipkart is  ");
		WebElement Redmi_11 = flipkart.getProd_page().getProduct_price();
		String redmi_price = text(Redmi_11);
		System.out.println(redmi_price);

		windowsHandling(product_page);
		clickonWebelement(flipkart.getProd_page().getAdd_tocart());

		Thread.sleep(3000);
		cart_price = flipkart.getCart().getCart_price();
		flipkart_price();
		
	}

	@Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	private void amazon_Addtocart() throws IOException, InterruptedException {

		Single_amazon amazon = new Single_amazon(driver);

		newURL(Configurationhelper.getInstance().getAmazonURL());

		String search_box = Configurationhelper.getInstance().getinputtext();
		inputValuestoWebelement(amazon.getHomepage().getInput_textbox(), search_box);
		clickonWebelement(amazon.getHomepage().getSearch());

		
		page_title();
		String product = driver.getWindowHandle();
		clickonWebelement(amazon.getCategory_page().getProduct());



		windowsHandling(product);
		Thread.sleep(3000);
		WebElement price = amazon.getProduct_page().getPrice();
		String text = text(price);
		String redmi_price = text.replace(".00", "");
		System.out.println("product price in Amazon is " + redmi_price);

		Thread.sleep(3000);
		scrollUsingCoOrdinates("window.scrollBy(0,500)");
		explicit_wait(amazon.getProduct_page().getAdd_ToCart());

		clickonWebelement(amazon.getProduct_page().getAdd_ToCart());

		clickonWebelement(amazon.getProduct_page().getCart());
		cart_price = amazon.getCart().getProduct_price();
		amazon_price();
	}

	@AfterClass
	private void verification() {
		if (Flipkart_cartPrice > Amazon_cartPrice) {

			System.out.println("Cheaper price is given by Amazon  ");
		} else {
			System.out.println("Cheaper price is given by Flipkart");
		}

	}

	@AfterSuite
	private void tear_down() {
		quit();
	}

}
