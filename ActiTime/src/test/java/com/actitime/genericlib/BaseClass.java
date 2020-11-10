package com.actitime.genericlib;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.actitime.objectrepositorylib.HomePage;
import com.actitime.objectrepositorylib.LoginPage;

public class BaseClass {

	public static WebDriver driver;
	public static Random ran;
	public static String commonDataPropertiesFile = "./src/main/resources/commonData.properties";
	public static String userName;
	public static String password;

	@BeforeSuite
	public static void beforeSuireConfigure() throws Throwable {
		userName = CommonUtils.getPropertiesFileData(commonDataPropertiesFile, "userName");
		password = CommonUtils.getPropertiesFileData(commonDataPropertiesFile, "password");
		ran = new Random();
	}

	@BeforeClass
	public static void beforeClassConfigure() throws Throwable {

		String browser = CommonUtils.getPropertiesFileData(commonDataPropertiesFile, "browser");
		String url = CommonUtils.getPropertiesFileData(commonDataPropertiesFile, "url");

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			driver = new ChromeDriver();
		} else

		if (browser.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
			driver = new FirefoxDriver();
		} else

		if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}

	@BeforeMethod
	public static void loginApp() {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginPage(userName, password);

	}

	@AfterMethod
	public static void logoutApp() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.logout();
	}

	@AfterClass
	public static void afterClassConfigure() {

		try {
			driver.quit();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
