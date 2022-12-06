package POM_Flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_page {
	
	public  WebDriver driver;
	
	@FindBy(xpath="(//div[@class='_25b18c']//div)[1]")
	private WebElement product_price;
	
	@FindBy(xpath="(//li[@class='col col-6-12']//button)[1]")
	private WebElement Add_tocart;

	public WebElement getAdd_tocart() {
		return Add_tocart;
	}

	public Product_page(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getProduct_price() {
		return product_price;
	}
}
