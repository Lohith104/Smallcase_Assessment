package POM_amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
	public static WebDriver driver;
	
	@FindBy(xpath="(//span[@id='sc-subtotal-amount-activecart']//span)[1]")
	private WebElement product_price;

	public Cart(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getProduct_price() {
		return product_price;
	}

}
