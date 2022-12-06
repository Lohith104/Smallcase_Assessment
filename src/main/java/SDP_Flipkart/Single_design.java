package SDP_Flipkart;

import org.openqa.selenium.WebDriver;

import POM_Flipkart.Home_page;
import POM_Flipkart.Product_categories;
import POM_Flipkart.Product_page;
import POM_Flipkart.cart_page;

public class Single_design {
	
	public WebDriver driver;
	
	private Home_page hp;
	private Product_categories category;
	private Product_page prod_page;
	private cart_page cart;

	public cart_page getCart() {
		cart=new cart_page(driver);
		return cart;
	}

	public Product_page getProd_page() {
		prod_page=new Product_page(driver);
		return prod_page;
	}

	public Product_categories getCategory() {
	category=new Product_categories(driver);
		return category;
	}

	public Single_design(WebDriver driver1) {
		this.driver=driver1;
	}

	public Home_page getHp() {
		hp=new Home_page(driver);
		return hp;
	}

}
