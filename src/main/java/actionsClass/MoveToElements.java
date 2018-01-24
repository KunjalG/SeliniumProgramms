package actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElements {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(5000);

		// login
		WebElement loginbutton = driver.findElement(By.xpath("//input[@type='submit']"));
		loginbutton.click();

		Thread.sleep(5000);
		// to switch to frame for using drowpdownlist
		driver.switchTo().frame("mainpanel");
		// driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();

		// defining all the webelements where the cursor need to be moved
		WebElement contacts = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		WebElement deals = driver.findElement(By.xpath("//a[contains(text(),'Deals')]"));
		WebElement tasks = driver.findElement(By.xpath("//a[contains(text(),'Tasks')]"));
		WebElement cases = driver.findElement(By.xpath("//a[contains(text(),'Cases')]"));

		Actions action = new Actions(driver);
		// To move to dropdown menu on different webelements
		action.moveToElement(contacts).build().perform();
		action.moveToElement(deals).build().perform();
		action.moveToElement(tasks).build().perform();
		action.moveToElement(cases).build().perform();

		// to wait for sec to get submenu visible before click event
		Thread.sleep(2000);

		// To click on particular Submenu
		action.moveToElement(contacts).build().perform();
		WebElement newcontact = driver.findElement(By.xpath("//a[contains(text(),'New Contact')]"));
		newcontact.click();

	}

}
