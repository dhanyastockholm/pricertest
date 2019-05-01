package com.java.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebTestBase {
public static WebDriver driver;
	public static void browserOpen(String name)
	{
		switch(name.toLowerCase())
		{
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "./src/test/java/com/java/BrowserDrivers/chromedriver.exe");
				driver=new ChromeDriver();
				
			break;
			
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "./src/test/java/com/java/BrowserDrivers/geckodriver");
				driver=new FirefoxDriver();
				
			break;
			
			case "ie":
				System.setProperty("webdriver.ie.driver", "./src/test/java/com/java/BrowserDrivers/iedriver.exe");
				driver=new ChromeDriver();
				
			break;
			
			case "opera":
				System.setProperty("webdriver.opera.driver", "./src/test/java/com/java/BrowserDrivers/operadriver.exe");
				driver=new ChromeDriver();
	
			break;
		}
		driver.manage().window().maximize();
	}
	
	public static void appLaunch(String url)
	{
		driver.get(url);
	}
	
	public static void browserClose()
	{
		driver.quit();
	}
}
