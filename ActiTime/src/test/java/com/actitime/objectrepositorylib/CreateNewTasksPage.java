package com.actitime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.genericlib.WebdriverCommonLib;

public class CreateNewTasksPage {

	@FindBy(name="customerId") WebElement customerDropDown;
	@FindBy(name="customerName") WebElement enterCustomerNameTextbox;
	@FindBy(name="projectName") WebElement enterProjectNameTextbox;
	@FindBy(css="input[id='task[0].name']") WebElement taskNameTextbox;
	@FindBy(css="input[value='Create Tasks']") WebElement createTaskButton;
	
	public void createNewTask(String customerName, String projectName, String taskName){
		
		WebdriverCommonLib.selectByVisibleTest(customerDropDown, "-- new customer --");
		
		WebdriverCommonLib.sendKeys(enterCustomerNameTextbox, customerName);
		
		WebdriverCommonLib.sendKeys(enterProjectNameTextbox, projectName);
		
		WebdriverCommonLib.sendKeys(taskNameTextbox, taskName);
		
		WebdriverCommonLib.click(createTaskButton);
	}
}
