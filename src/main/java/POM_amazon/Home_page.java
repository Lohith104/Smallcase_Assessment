package POM_amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	public static WebDriver driver;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement input_textbox;

	@FindBy(id = "nav-search-submit-button")
	private WebElement search;

	public Home_page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getInput_textbox() {
		return input_textbox;
	}

}
