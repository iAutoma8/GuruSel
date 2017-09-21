package com.guru.Test;

import org.openqa.selenium.WebDriver;

import com.guru.Config.BrowserConfig;
import com.guru.Pages.LoginPage;

public class LoginTest extends BrowserConfig{
	
	public static WebDriver driver;
	public static void main(String[] args) {
		
		
		BrowserConfig.launchBrowser();
		LoginPage.launchSite();
		LoginPage.Login();
		
	}
	
	
	

}
