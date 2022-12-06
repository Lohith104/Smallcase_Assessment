package com.scenario1_stepdef;

import org.openqa.selenium.WebDriver;

import com.configuration.Configurationhelper;
import com.scenario1_runner.Flipkart_runner;

import Base_class.Selenium_methods;
import SDP_Flipkart.Single_design;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Flipkart_stepdef extends Selenium_methods {

	public static WebDriver driver = Flipkart_runner.driver;
	public static Single_design sdp = new Single_design(driver);

	public static String product_page;

	@Given("^user Launch The URL Of Flipkart$")
	public void user_Launch_The_URL_Of_Flipkart() throws Throwable {

		try {
			getUrl(Configurationhelper.getInstance().getFlipkartURL());
			clickonWebelement(sdp.getHp().getClose_login());

		} catch (Exception e) {
			throw new Exception("URL not found");
		}
	}

	@When("^user Search Of TV Product$")
	public void user_Search_Of_TV_Product() throws Throwable {

		try {
			String search_box = Configurationhelper.getInstance().getSearch_box();
			inputValuestoWebelement(sdp.getHp().getSearch_box(), search_box);
			clickonWebelement(sdp.getHp().getSearch());

		} catch (Exception e) {
			throw new Exception("text not entered");
		}
	}

	@When("^user Click On The First Product$")
	public void user_Click_On_The_First_Product() throws Throwable {
		try {
			product_page = driver.getWindowHandle();
			page_title();
			clickonWebelement(sdp.getCategory().getFirst_product());

		} catch (Exception e) {
			System.out.println("Product not clicked");
		}
	}

	@When("^user Print The Product price$")
	public void user_Print_The_Product_price() throws Throwable {

		System.out.print("Product price is  ");
		element_text(sdp.getProd_page().getProduct_price());

	}

	@When("^user Add The Product To Cart$")
	public void user_Add_The_Product_To_Cart() throws Throwable {
		try {
			windowsHandling(product_page);
			clickonWebelement(sdp.getProd_page().getAdd_tocart());

		} catch (Exception e) {
			throw new Exception("Add to cart button not clickable");
		}
	}

	@When("^user Go To Cart Page And Increse The Quantity By One$")
	public void user_Go_To_Cart_Page_And_Increse_The_Quantity_By_One() throws Throwable {

		Thread.sleep(3000);

		scrollUsingCoOrdinates("window.scrollBy(0,400)");
		System.out.println("Product price after Increasing the quantity  ");
		String quantity_product = Configurationhelper.getInstance().getprod_quantity();
		int quantity = Integer.parseInt(quantity_product);
		for (int i = 0; i < quantity; i++) {
			clickonWebelement(sdp.getCart().getQuantity_increase());
			Thread.sleep(2000);

		}
	}

	@Then("^user Print The Price After Increasing The Quantity$")
	public void user_Print_The_Price_After_Increasing_The_Quantity() throws Throwable {
		String file_name = Configurationhelper.getInstance().getscreenshot_filename();
		element_text(sdp.getCart().getQuantity_price());
		takeScreenShot(file_name);
	}

}
