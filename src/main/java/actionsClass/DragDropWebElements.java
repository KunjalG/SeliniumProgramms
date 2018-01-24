package actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropWebElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		
		WebElement Source= driver.findElement(By.id("draggable"));
		WebElement Destination= driver.findElement(By.id("droppable"));
		
		Actions action= new Actions(driver);
		action.clickAndHold(Source)    //from source
		.moveToElement(Destination)    //to destination
		.release()
		.build()
		.perform();
		
		
		

	}

}
