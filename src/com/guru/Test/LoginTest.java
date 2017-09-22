package com.guru.Test;

import org.openqa.selenium.WebDriver;

import com.guru.Config.BrowserConfig;
import com.guru.Config.ExcelUtill;
import com.guru.Config.Utill;
import com.guru.Pages.LoginPage;

public class LoginTest extends BrowserConfig {

	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		BrowserConfig.launchBrowser();
		LoginPage.launchSite();
		// LoginPage.Login();
		
		ExcelUtill.setExcel(Utill.path_TestData);

		for (int i = 1; i < ExcelUtill.getRowNum("Data"); i++) {

			String user=ExcelUtill.getCellData(i, 0, "Data");
			String pass=ExcelUtill.getCellData(i, 1, "Data");
			LoginPage.userLoginTest(user, pass);

		}
	}

}
