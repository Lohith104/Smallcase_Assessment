package POM_amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_page {
	
	public static WebDriver driver;
	
	@FindBy(id="add-to-cart-button")
	private WebElement add_ToCart;
	
	@FindBy(xpath="//span[@id='attach-sidesheet-view-cart-button']/span[1]/input[1]")
	private WebElement cart;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[5]/div[4]/div[4]/div[10]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/span[1]/span[2]")
	private WebElement price;

	public WebElement getPrice() {
		return price;
	}


	public WebElement getCart() {
		return cart;
	}
	

	public Product_page(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getAdd_ToCart() {
		return add_ToCart;
	}
	
	




	

}
