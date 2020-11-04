package com.actitime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.genericlib.WebdriverCommonLib;

public class HomePage {

	@FindBy(id = "logoutLink")
	WebElement logoutLink;

	@FindBy(xpath = "//div[text()='Tasks']")
	WebElement taskLink;
	@FindBy(xpath = "//div[text()='Users']")
	WebElement usersLink;

	public void logout() {
		WebdriverCommonLib.click(logoutLink);
	}
	
	public void tasksLink() {
		WebdriverCommonLib.click(taskLink);
	}
}
