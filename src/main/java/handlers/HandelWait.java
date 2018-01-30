package handlers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandelWait {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		// Implicit wait
		// Global wait--applicable for all the elements of webdriver
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/");

		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");

		// login button
		WebElement loginbutton = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginbutton);

		// Explicit wait --Specific to element
		// Used to tell Selenium web driver to wait for certain
		// condition-->Expected condition.
		// Or if the given time is expired then throw an exception that element
		// not found/not visible
		// WebdriverWait && ExpectedConditions

		driver.switchTo().frame("mainpanel");
		// WebDriverWait wait= new WebDriverWait(driver,20);
		// WebElement username;
		// username=
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)))

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement username;
		username = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'User: Naveen K')]")));
		System.out.println(username.getText());

		// 1. An element is visible and enabled:
		// ExpectedConditions.elementToBeClickable(locator)
		// 2. An element is selected :
		// ExpectedConditions.elementToBeSelected(locator)
		// 3.A presence of an element :
		// ExpectedConditions.presenceOfElementLocated(locator)
		// 4. Specific text present in an element:
		// ExpectedConditions.textToBePresentInElement(By locator,String text)

		// To search the particular element by using sendKeyValue method
		WebElement search = driver.findElement(By.name("search"));
		sendKeyValues(driver, search, 20, "Test");

		// To click on particular element by using clickOn method
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		clickOn(driver, logout, 10);

	}
	// ****
	// Custom click on method : Click on element on the basis of some
	// ExpectedCondition to avoid StalelementReferenceException.

	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

	// *****
	// Custom sendKeyValue Method: Enter value in element on the basis of some
	// ExpectedConditions to avoid StaleElementReferenceException

	public static void sendKeyValues(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(value);
	}

}
