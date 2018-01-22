package testHomePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicWebDriverMethod {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); // Delete all cookies
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS); 

		driver.get("https://www.facebook.com/");
		driver.navigate().refresh(); // to refresh the page.

		driver.close();
		driver.quit();// to close the webdriver

	}

}
