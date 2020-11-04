package com.actitime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.genericlib.WebdriverCommonLib;

public class LoginPage {

	@FindBy(id = "username")
	WebElement userNameTbx;
	@FindBy(name = "pwd")
	WebElement passwordTbx;
	@FindBy(id = "loginButton")
	WebElement loginButton;

	public void loginPage(String userName, String password) {
		WebdriverCommonLib.sendKeys(userNameTbx, userName);
		WebdriverCommonLib.sendKeys(passwordTbx, password);
		WebdriverCommonLib.click(loginButton);
	}
}
