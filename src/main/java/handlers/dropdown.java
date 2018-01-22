package handlers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TO handle the dropdown menus and to work with it

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		WebElement textDay = driver.findElement(By.id("day"));
		Select select = new Select(textDay);
		select.selectByIndex(5);
		select.selectByVisibleText("10");

		// to print all the values of dropdown box
		List<WebElement> daylist = driver.findElements(By.xpath("//select[@id='day']//option"));
		System.out.println(daylist.size());

		for (int i = 0; i < daylist.size(); i++) {
			System.out.println(daylist.get(i).getText());
			if (daylist.get(i).getText().equals("25")) {
				System.out.println("Selected item is 25th day of the month");
				daylist.get(i).click();
				break;
			}

		}
		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}

}
