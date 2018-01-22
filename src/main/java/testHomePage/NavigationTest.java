package testHomePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.get("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=E2ZmWuXINcScX_OTk_gF");
		System.out.println("Title of Page is : " + driver.getTitle());

		driver.get("https://www.amazon.com/");
		System.out.println("Title of Page is : " + driver.getTitle());

		// to navigate back n forth
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();

		Thread.sleep(5000);
		driver.close();

	}

}
