package Base_class;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_methods {

	public static Properties prop;

	public static WebDriver driver;

	public static WebDriver getBrowser(String drivername) throws Exception {

		try {
			if (drivername.equalsIgnoreCase("ChromeDriver")) {
				ChromeOptions options =new ChromeOptions();
				options.addArguments("start-maximized");

				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(options);
				driver.manage().deleteAllCookies();
			} else if (drivername.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().create();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static void getUrl(String URL) {
		try {
			driver.get(URL);
			driver.manage().deleteAllCookies();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void quit() {
		driver.quit();
	}

	public static void waitforElementVisiblity(WebElement element) {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 40);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static boolean elementIsDisplayed(WebElement element) {
		boolean displayed = false;
		try {
			displayed = element.isDisplayed();
			return displayed;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return displayed;
	}

	public static boolean elementIsEnabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void clickonWebelement(WebElement element) {
		try {
			waitforElementVisiblity(element);
			if (elementIsDisplayed(element)) {
				element.click();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void clickwebelement(WebElement element) {

		element.click();

	}

	public static void inputValuestoWebelement(WebElement element, String value) {
		try {
			waitforElementVisiblity(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				element.sendKeys(value);
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void page_title() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static WebElement element_text(WebElement element) {
		try {
			waitforElementVisiblity(element);
			String text = element.getText();
			System.out.println(text);
		} catch (Exception e) {
			System.out.println("text not found");
		}
		return element;
	}

	public static void windowsHandling(String wId) {
		Set<String> AllId = driver.getWindowHandles();
		for (String id : AllId) {
			{
				if (!(id == wId))
					driver.switchTo().window(id);
			}
		}
	}

	public static void scrollUsingCoOrdinates(String coodinates) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(coodinates);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void explicit_wait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void takeScreenShot(String fileName) throws IOException {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(
					"C:\\Users\\Lohith\\eclipse-workspace\\Smallcase_Assessment\\ScreenShot\\" + fileName + ".png");
			FileUtils.copyFile(src, des);
		} catch (WebDriverException e) {

			e.printStackTrace();
		}
	}

	public static void wait_clickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static String text(WebElement element) {
		String text = element.getText();
		return text;

	}

	public static void newURL(String URL) {
		driver.navigate().to(URL);

	}

}
