package handlers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandelingAlertAPI {

	public static void main(String[] args) throws InterruptedException {
		// how to handle alert
		// 1.Using Alert API in Selinium
		// Accept,dismiss,gettext

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();

		// To switch the control to handle alert
		Alert alert = driver.switchTo().alert();

		// To print the message on alert window
		System.out.println("Alert Message :" + alert.getText());

		// To validate the alert message
		if (alert.getText().equals("Please enter a valid user name"))
			System.out.println("Correct error message");
		else
			System.out.println("Incorrect error message");

		Thread.sleep(3000);
		// Ok button
		// alert.accept();

		// Cancel button
		alert.dismiss();
		Thread.sleep(5000);
		driver.close();

	}

}
