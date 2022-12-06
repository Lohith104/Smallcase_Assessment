package POM_Flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	private WebElement close_login;
	
	@FindBy(name = "q")
	private WebElement search_box;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSearch_box() {
		return search_box;
	}

	public Home_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getClose_login() {
		return close_login;
	}

}
