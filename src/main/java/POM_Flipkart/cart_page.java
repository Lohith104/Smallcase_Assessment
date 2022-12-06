package POM_Flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cart_page {
	public  WebDriver driver;
	
	@FindBy(xpath="(//input[@type='text']/parent::div/following-sibling::button)[2]")
	private WebElement Quantity_increase;
	
	@FindBy(xpath="//div[@class='_3LxTgx']/div[@class='Ob17DV']")
	private WebElement Quantity_price;
	
	@FindBy(xpath = "//div[@class='Ob17DV _3X7Jj1']//span[1]")
	private WebElement cart_price;

	public WebElement getCart_price() {
		return cart_price;
	}

	public WebElement getQuantity_price() {
		return Quantity_price;
	}

	public cart_page(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getQuantity_increase() {
		return Quantity_increase;
	}

}
