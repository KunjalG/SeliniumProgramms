package testHomePage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LangLinkTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.get("https://www.google.co.in/");

		List<WebElement> Linklist = driver.findElements(By.xpath("//div[@id='_eEe']//a"));
		System.out.println(Linklist.size());

		// Declare String array
		String[] linkText = new String[Linklist.size()];

		// Iterate for each WebElement of Linklist & store in string array
		int i = 0;
		for (WebElement elements : Linklist) {
			linkText[i] = elements.getText();
			i++;
		}

		// Iterate for each value of String array and search particular String
		// on webpage

		for (String t : linkText) {
			driver.findElement(By.linkText(t)).click();
			Thread.sleep(2000);
			driver.navigate().back();

		}

		driver.close();
		driver.quit();

		// for( int i=0;i<Linklist.size();i++)
		// {
		//
		// WebElement link=(Linklist.get(i));
		// System.out.println(link.getText());
		// linkClick(driver,link,30);
		// WebElement engLink= driver.findElement(By.linkText("English"));
		// linkClick(driver,engLink,30);
		//

	}

	public static void linkClick(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		driver.findElement(By.linkText("English")).click();

	}
}
