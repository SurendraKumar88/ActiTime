package com.actitime.genericlib;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import extentReports.PrintUtil;

public class WebdriverCommonLib extends BaseClass {

	public static void waitForElement(WebElement element) {
		int wait = 0;
		while (wait < 10) {
			try {
				if (element.isDisplayed()) {
					break;
				}

			} catch (Throwable t) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}
				wait++;
			}
		}
	}

	public static void sendKeys(WebElement element, String enterData) {

		waitForElement(element);
		element.clear();
		element.sendKeys(enterData);
		printMessage("Successfully "+enterData+" sent to TextBox");

	}

	public static void click(WebElement element) {

		waitForElement(element);
		element.click();
		printMessage("Successfully Clicked");

	}

	public static void selectByVisibleTest(WebElement element, String data) {
		waitForElement(element);
		Select sel = new Select(element);
		sel.selectByVisibleText(data);
		printMessage("Successfully "+data+" selected from drop down");
		
	}

	public static void selectByValuebasedOnAttribute(WebElement element, String attribute) {
		waitForElement(element);
		Select sel = new Select(element);
		sel.selectByValue(attribute);
	}

	public static void mouseMovement(WebElement element) {
		Actions act = new Actions(driver);
		waitForElement(element);
		act.moveToElement(element).perform();
	}

	public static void printMessage(String message) {
		System.out.println(message);
		Reporter.log(message);
		PrintUtil.logger.info(message);
	}

	public static void switchToNewWindow(String parentHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (int i = 0; i < 20; i++) {

			if (allWindowHandles.size() < 2) {
				allWindowHandles = driver.getWindowHandles();
			} else {
				break;
			}
		}

		for (String childHandle : allWindowHandles) {
			if (!childHandle.equalsIgnoreCase(parentHandle)) {
				driver.switchTo().window(childHandle);
				driver.manage().window().maximize();
				printMessage("New Child Windo Title" + driver.getTitle());
				printMessage("Switched to new child window");
			}
		}
	}

	/**
	 * switch to parentWindow
	 * 
	 * @param windoIndex
	 */
	public static void switchToParentWindow(int windoIndex) {
		driver.switchTo().window(driver.getWindowHandles().toArray()[windoIndex].toString());
	}

	public static void handleAlert() {

		try {
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {

		}

	}

	public static void fileUploadUsingRobotClass(String filePath) throws Throwable {
		StringSelection path = new StringSelection(filePath);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Clipboard mouse = tool.getSystemClipboard();
		mouse.setContents(path, null);

		Robot r = new Robot();
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static boolean verifyLinkIsDisplayed(String link) {
		
		WebElement element=null;
		try{
			element = driver.findElement(By.linkText(link));
		}catch(Exception e){
			
		}
		
		waitForElement(element);
		boolean result = element.isDisplayed();

		return result;
	}

	public static boolean verifyXpathIsDisplayed(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		waitForElement(element);
		boolean result = element.isDisplayed();

		return result;
	}
}
