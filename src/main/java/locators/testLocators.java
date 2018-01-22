package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testLocators {

	public static void main(String[] args) {
		// By ID--I

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\HP\\Downloads\\chromedriver.exe"); WebDriver driver=new
		 * ChromeDriver();
		 * 
		 * driver.get(
		 * "https://login.yahoo.com/?.src=ym&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2F"
		 * ); //Launching the url WebElement
		 * email=driver.findElement(By.id("login-username"));
		 * email.sendKeys("Kunjal@yahoo.com");
		 * 
		 * WebElement nxtButton= driver.findElement(By.id("login-signin"));
		 * nxtButton.click();
		 */

		// By Name----II

		/*
		 * WebDriver driver= new ChromeDriver();
		 * 
		 * driver.get((
		 * "https://login.yahoo.com/?.src=ym&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2F"
		 * ));
		 * 
		 * WebElement email= driver.findElement(By.name("username"));
		 * email.sendKeys("Kunjalgangani");
		 * 
		 * WebElement nxtbutton= driver.findElement(By.name("signin"));
		 * nxtbutton.click();
		 */

		// By Xpath---III

		/*
		 * WebDriver driver= new ChromeDriver(); driver.get(
		 * "https://login.yahoo.com/?.src=ym&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2F"
		 * );
		 * 
		 * WebElement email=
		 * driver.findElement(By.xpath("//input[@id='login-username']"));
		 * email.sendKeys("kunjalgangani");
		 * 
		 * WebElement nxt=
		 * driver.findElement(By.xpath("//input[@id='login-signin']"));
		 * nxt.click();
		 */

		// By CssLocators--- II,III

		WebDriver driver = new ChromeDriver();
		driver.get("https://login.yahoo.com/?.src=ym&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2F");
		WebElement email = driver.findElement(By.cssSelector("#login-username"));
		email.sendKeys("kunjalgangani");
		WebElement button = driver.findElement(By.cssSelector("#login-signin"));
		button.click();

		// Link Text--- either use Xpath or LinkText
		// driver.findElement(By.linkText("Help")).click();

		// Partial Link Text not recommended
		driver.findElement(By.partialLinkText("Trouble signing")).click();

		// Class name : Not recommended because it is not recommended ---IV

		driver.findElement(By.className("phone-no ")).sendKeys("kunjalgangani");
		// Tag name

		driver.close();
		driver.quit();// To close the browser

	}

}
