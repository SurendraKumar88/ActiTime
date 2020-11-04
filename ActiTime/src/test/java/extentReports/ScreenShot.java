package extentReports;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenShot {

	private static Logger logger = Logger.getLogger(ScreenShot.class);

	/**
	 * Adding Accept alert if present since this throws program execution in
	 * infinie loop if not handled
	 * 
	 * @param webdriver
	 * @return
	 */
	public static String takeScreenshot(WebDriver webdriver) {
		acceptAlert(webdriver);
		logger.info("Take Screenshot ..");
		String data_uri = null;
		try {
			Thread.sleep(2000);
			data_uri = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BASE64);
			data_uri = "data:image/gif;base64," + data_uri;
		} catch (Exception e) {
			logger.info("Exception while taking the Screenshot: " + e.getMessage());
		}
		return data_uri;
	}

	public static boolean acceptAlert(WebDriver webdriver) {
		String alertText = "NO TEXT";
		try {
			WebDriverWait wait = new WebDriverWait(webdriver, 0);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = webdriver.switchTo().alert();
			alertText = alert.getText();
			logger.info("Screenshot Precheck for Alert - Getting UnExpected Alert in the screen : " + alertText);
			alert.accept();
			return true;
		} catch (NoAlertPresentException ex) {
			return true;
		} catch (TimeoutException e) {
			return true;
		} catch (Exception e) {
			return true;
		}
	}
}
