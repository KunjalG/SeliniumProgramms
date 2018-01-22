package testHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class URLTest {

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver","C://Users//HP//Documents//chromedriver.exe");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/"); // Launching the url

		String getTitle = driver.getTitle(); // Fetching the title

		// Printing the title on the screen
		System.out.println("The title of the page is : " + getTitle);
		// Validation point.
		if (getTitle.equalsIgnoreCase(
				"AMAZON.com: oNLINE SHOPPING FOR ELECTRONICS, Apparel, Computers, Books, DVDs & more")) {
			System.out.println("Correct Title");
		} else
			System.out.println("Incorrect Title");
		// For printing the URL on the system

		System.out.println("The current URL is : " + driver.getCurrentUrl());

		// For printing the current Page Source

		// System.out.println(" The page source of current web page is : " +
		// driver.getPageSource());

		// Validating current URL

		String CurrentURL = driver.getCurrentUrl();

		if (CurrentURL.contains("amazon")) {
			System.out.println(" Current URL contains the specified string");
		} else
			System.out.println("Current URL does not redirecting the specified string.");

		driver.close();
		driver.quit();// To close the browser

	}

}
