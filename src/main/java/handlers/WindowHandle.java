package handlers;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.get("http://toolsqa.com/automation-practice-switch-windows/");

		// on Button1 click
		driver.findElement(By.id("button1")).click();

		// Declare Window handeler
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> IT = handler.iterator();

		// Iterate the unique window ids & store it in a string
		String parentwindow = IT.next();
		System.out.println("ID of Parent Window:  " + parentwindow);
		String childwindow = IT.next();
		System.out.println("ID of Child Windoe:  " + childwindow);

		// Perform action on child window
		driver.switchTo().window(childwindow);
		System.out.println("Title of the Child Page is :" + driver.getTitle());
		System.out.println("URL of Child Page is " + driver.getCurrentUrl());
		driver.manage().window().maximize();
		driver.close();

		// Switch to parent window
		driver.switchTo().window(parentwindow);
		System.out.println("Title of Home Window is " + driver.getTitle());
		System.out.println("URL of Parent Window is " + driver.getCurrentUrl());

		// On Button 2 Click
		driver.findElement(By.xpath("//button[contains(text(),'New Browser Tab')]")).click();
		;
		Set<String> handler1 = driver.getWindowHandles();
		Iterator<String> it1 = handler1.iterator();

		String parentwindow1 = it1.next();
		String childwindow1 = it1.next();

		// Swith to child window
		driver.switchTo().window(childwindow1);
		System.out.println("Title of the 2nd page is : " + driver.getTitle());
		driver.close();

		// Switch to parent window
		driver.switchTo().window(parentwindow);
		System.out.println("Tiltle of the home page is : " + driver.getTitle());

		// driver.switchTo().window(parentwindow);
		// driver.close();

	}

}
