package POM_Flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_categories {

		public WebDriver driver;
		
		
		@FindBy(xpath="/html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div/div")
		public WebElement First_product;
		
		@FindBy(xpath = "//div[contains(text(),'REDMI 11 Prime')]/parent::div")
		public WebElement Phone_redmi;

		public WebElement getPhone_redmi() {
			return Phone_redmi;
		}

		public Product_categories(WebDriver driver2) {
			this.driver=driver2;
			PageFactory.initElements(driver, this);
		}

		public WebElement getFirst_product() {
			return First_product;
		}

}
