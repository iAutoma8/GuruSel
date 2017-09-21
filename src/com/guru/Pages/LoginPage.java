package com.guru.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.guru.Config.BrowserConfig;
import com.guru.Config.Utill;
import static com.guru.Config.BrowserConfig.driver;

public class LoginPage {

	
	
	
	

	public static String expecteTitle = "Guru99 Bank Manager HomePage";
	
	public static String TxtBox_UserName="//input[@name='uid']";
	public static String TxtBox_Password="//input[@name='password']";
	public static String Btn_Login="//input[@name='btnLogin']";
	
	
	
	public static void launchSite()
	{
		driver.get(Utill.Login_URL);
	}

	public static void Login() {
		
		driver.findElement(By.xpath(TxtBox_UserName)).sendKeys(Utill.UserName);
		driver.findElement(By.xpath(TxtBox_Password)).sendKeys(Utill.Password);
		driver.findElement(By.xpath(Btn_Login)).click();
		String title = driver.getTitle();
		if(title.equalsIgnoreCase(expecteTitle))
		{
			System.out.println("Logged in");
		}
		else
		{
			System.out.println("Not Logged in");
		}

	}

}
