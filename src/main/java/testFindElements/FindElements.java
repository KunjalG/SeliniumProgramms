package testFindElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://freecrm.com/index.html");

		// To fetch no of links on the web page
		List<WebElement> listelements = driver.findElements(By.tagName("a"));
		System.out.println("Total no of Web Elements = " + listelements.size());

		// To display the text of Link elements
		for (int i = 0; i < listelements.size(); i++) {
			System.out.println(listelements.get(i).getText());
			String linktext = listelements.get(i).getText();
			Thread.sleep(5000);
			if (linktext.equals("Sign Up")) {
				System.out.println("Yes");
				listelements.get(i).click();
				break;
			}
		}

		List<WebElement> TextBoxes = driver.findElements(By.tagName("input"));
		System.out.println("Total no of Text boxes = " + TextBoxes.size());

		driver.close();
		driver.quit();

	}

}
