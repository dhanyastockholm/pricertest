package com.java.Util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Setup {
	protected static WebDriver driver;

	@BeforeMethod
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/com/java/BrowserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://sukram-89.github.io/store/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public static void tearDown() {
		driver.quit();
	}
}
