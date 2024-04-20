package com.jenkins.dump2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EDB_Datadriven {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\EDB.properties");
		Properties Pobj = new Properties();
		Pobj.load(fis);
		String Browser = Pobj.getProperty("browser");
		String URL = Pobj.getProperty("url");
		String Staff = Pobj.getProperty("staffid");
		String pwd = Pobj.getProperty("password");

		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser driver is not available");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get(URL);
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		WebElement Staffid = driver.findElement(By.name("staff_id"));
		Staffid.click();
		Staffid.sendKeys(Staff);
		WebElement passworddfield = driver.findElement(By.name("password"));
		passworddfield.click();
		passworddfield.sendKeys(pwd);

		WebElement Login = driver.findElement(By.xpath("//input[@type='submit']"));
		Login.click();

		WebElement SearchCustomer = driver.findElement(By.xpath("//input[@value='View Active Customer']"));
		SearchCustomer.click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_F);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_F);
		String text1 = "Test Titans";
		StringSelection stringSelection1 = new StringSelection(text1);
		Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard1.setContents(stringSelection1, stringSelection1);

		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.findElement(By.name("logout_btn")).click();
		
		
	}
}

//List<WebElement> tabledata = driver.findElements(By.xpath("//tr"));
//
//	for(WebElement data:tabledata) {
//		if(data.getText().contains("Test Titans")) {
//			System.out.println("Test Titans Customer has been added");
//		}
//	}
