package testFindElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/");

		// **To get text of the link with the help of text() function
		String linktext;
		linktext = driver.findElement(By.xpath("//a[contains(text(),'Features')]")).getText();
		// Partial text can also be selected.
		// a[contains(text(),'Feat')]
		// a[text()='Features']

		// **To get text of an image with the help of contains() function
		Boolean display = driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]")).isDisplayed();
		// img[(@class='img-responsive')]
		System.out.println("Given Image is present: " + display);
		System.out.println("Text on the given xpath is : " + linktext);

		driver.findElement(By.name("username")).sendKeys("naveenk");
		// input[@name='username']
		// input[@name='username' and @type='text']

		driver.findElement(By.name("password")).sendKeys("test@123");
		// input[@name='password' and @type='password']

		// ** login button
		WebElement loginbutton = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginbutton);
		// input[@type='submit']
		// input[@type='submit' and @value='Login']

		Thread.sleep(5000);
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[@title='Contacts' and contains(text(),'Contacts')]")).click();
		// a[@title='Contacts' and text()='Contacts']
		Thread.sleep(5000);

		// ** To click the particular CheckBox.
		// driver.findElement(By.xpath("//input[@type='checkbox' and
		// @name='contact_id' and @value='51446642']")).click();
		// Thread.sleep(5000);

		// ** To click the alternative CheckBox
		// List<WebElement> list =
		// driver.findElements(By.xpath("//input[@type='checkbox' and
		// @name='contact_id']"));
		// System.out.println("Size of elements: " + list.size());

		// Thread.sleep(5000);
		// for (int i = 1; i < list.size(); i = i + 2) {
		// list.get(i).click();
		// }

		// ** To click the respective CheckBox containing text="ASelinium" only.
		driver.findElement(By
				.xpath("//a[@context='contact' and contains(text(),'Alexender Alexender')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@type='checkbox' and @name='contact_id']"))
				.click();

		// ** To click the respective CheckBox containing text="HCL" && Phone
		// number "466776543"

		// driver.findElement(By.xpath("//span[@context='phone' and
		// contains(text(),'466776543')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//a[@context='company'
		// and
		// contains(text(),'HCL')]//parent:://preceding-sibling:://preceding-sibling:://input[@type='checkbox'
		// and @name='contact_id']")).click();;

	}

}
