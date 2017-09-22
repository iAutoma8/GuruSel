package com.guru.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.guru.Config.BrowserConfig;
import com.guru.Config.ExcelUtill;
import com.guru.Config.Utill;
import static com.guru.Config.BrowserConfig.driver;

public class LoginPage {

	public static String expecteTitle = "Guru99 Bank Manager HomePage";

	public static String TxtBox_UserName = "//input[@name='uid']";
	public static String TxtBox_Password = "//input[@name='password']";
	public static String Btn_Login = "//input[@name='btnLogin']";

	public static String Link_Logout = "//a[contains(text(),'Log out')]";

	public static void launchSite() {
		driver.get(Utill.Login_URL);
	}

	public static void Login() {

		driver.findElement(By.xpath(TxtBox_UserName)).sendKeys(Utill.UserName);
		driver.findElement(By.xpath(TxtBox_Password)).sendKeys(Utill.Password);
		driver.findElement(By.xpath(Btn_Login)).click();
		String title = driver.getTitle();
		if (title.equalsIgnoreCase(expecteTitle)) {
			System.out.println("Logged in");
		} else {
			System.out.println("Not Logged in");
		}

	}
	
	
	public static void to_be_removed()
	{
		System.out.println("Remove");
	}

	public static void userLoginTest(String user, String pass) throws Exception {
		int i=0;

		driver.findElement(By.xpath(TxtBox_UserName)).sendKeys(user);
		driver.findElement(By.xpath(TxtBox_Password)).sendKeys(pass);
		driver.findElement(By.xpath(Btn_Login)).click();
		
		
		try
		{
			Alert alt= driver.switchTo().alert();
			String invalidAlertText=alt.getText();
			alt.accept();
			
			if(invalidAlertText.equalsIgnoreCase(Utill.Expected_Login_Error))
			{
				System.out.println("FAIL: Invalid User : " +user);
				ExcelUtill.setCallData("Data", i, Utill.Col_dataResult, "FAIL");
			}
			else
			{
				System.out.println("Alert:"  +invalidAlertText);
			}
			
		}catch(NoAlertPresentException e)
		{
			if(driver.findElement(By.xpath(Link_Logout)).isDisplayed())
			{
				System.out.println("PASS:  Valid User: " + user);
				ExcelUtill.setCallData("Data", i, Utill.Col_dataResult, "PASS");
			}
         	driver.findElement(By.xpath(Link_Logout)).click();
			Thread.sleep(5000);
			Alert alt = driver.switchTo().alert();
			alt.accept();
			
		}

	}

}
