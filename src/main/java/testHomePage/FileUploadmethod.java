package testHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadmethod {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		Thread.sleep(5000);

		driver.findElement(By.linkText("Got it!")).click();
		System.out.println("Yes");
		Thread.sleep(5000);

		driver.findElement(By.name("files[]")).sendKeys("C:\\Users\\HP\\Desktop\\info.txt");
		// driver.findElement(By.name("files[]")).sendKeys("C:\\Users\\HP\\workspace\\AmazonTest\\src\\main\\java\\testHomePage\\info.txt");

		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}

}
