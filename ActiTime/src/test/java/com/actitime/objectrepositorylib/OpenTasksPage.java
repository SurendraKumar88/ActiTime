package com.actitime.objectrepositorylib;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.actitime.genericlib.BaseClass;
import com.actitime.genericlib.WebdriverCommonLib;

public class OpenTasksPage extends BaseClass {

	@FindBy(xpath = "//span[text()='Create Tasks']")
	WebElement createTaskButton;
	
	

	public void createNewTask() {
		WebdriverCommonLib.click(createTaskButton);
	}

	public List<String> getTheListOfTasks() {

		List<String> taskList = new ArrayList<String>();
		int column = 0;
		
		
		
		List<WebElement> tasks = driver
				.findElements(By.xpath("//table[@class='listTable withRoundCorners']/tbody/tr/th/a"));
		for (int i = 0; i < tasks.size(); i++) {
			String data = tasks.get(i).getText();

			if (data.equals("Task")) {
				column = i+1;
				break;
			}
		}

		List<WebElement> taskRow = driver.findElements(By
				.xpath("//table[@class='listTable withRoundCorners']/tbody/tr[*]/td[" + column + "]/descendant::a[2]"));

		WebdriverCommonLib.printMessage("List of Tasks");
		for (int i = 0; i < taskRow.size(); i++) {
			String data = taskRow.get(i).getText();
			WebdriverCommonLib.printMessage(data);
			taskList.add(data);
		}

		return taskList;
	}

}
