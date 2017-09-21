package com.guru.Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserConfig {
	
	
	public static WebDriver driver;
	
	
	public static void launchBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", Utill.Path_Chrome);
		driver=new ChromeDriver();
		
	}

}
