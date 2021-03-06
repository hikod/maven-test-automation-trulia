package com.trulia.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.trulia.utilities.ConfigurationReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	private static WebDriver driver;
	//singleton pattern -> only one object of  Driver in our project
		public static WebDriver getDriver() {
			if (driver == null) {
				switch (ConfigurationReader.getProperty("browser")) {
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				default:
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
			}
			return driver;

		}

		public static void closeDriver() {
			if (driver != null) {
				driver.quit();
				driver = null;
			}
		}
	}