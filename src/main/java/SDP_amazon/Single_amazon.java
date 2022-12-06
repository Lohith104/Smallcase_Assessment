package SDP_amazon;

import org.openqa.selenium.WebDriver;

import POM_amazon.Cart;
import POM_amazon.Home_page;
import POM_amazon.Product_page;
import POM_amazon.product_categories;

public class Single_amazon{
	public WebDriver driver;
	
	private Home_page homepage ;
	private product_categories category_page;
	private Product_page product_page;
	private Cart cart;

	

	

	public Cart getCart() {
		cart=new Cart(driver);
		return cart;
	}

	public Product_page getProduct_page() {
		product_page=new Product_page(driver);
		return product_page;
	}

	public product_categories getCategory_page() {
		category_page=new product_categories(driver);
		return category_page;
	}

	public Single_amazon(WebDriver driver2) {
		this.driver=driver2;
	}

	public Home_page getHomepage() {
		homepage=new Home_page(driver);
		return homepage;
	}
	

	

}
