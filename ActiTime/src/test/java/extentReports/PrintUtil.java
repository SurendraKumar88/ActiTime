package extentReports;

import static org.testng.Assert.assertTrue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.actitime.genericlib.WebdriverCommonLib;
import com.relevantcodes.extentreports.LogStatus;

public class PrintUtil{

	public static Logger logger = Logger.getLogger(PrintUtil.class);
	
	

	
	

	public static void testCasePassedWithScreenshot(WebDriver webdriver,String msg) {
		
		if(null != ExtentTestManager.getTest()){
			ExtentTestManager.getTest().log(LogStatus.INFO, "TS_PASS",font_green(msg) + ExtentTestManager.getTest().addBase64ScreenShot(ScreenShot.takeScreenshot(webdriver)));
		}
		
		WebdriverCommonLib.printMessage(msg);
	}

		

	
	


	public static void testCaseFailedWithScreenshot(String msg,WebDriver webdriver) {
	
		if(null != ExtentTestManager.getTest()){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "TS_FAIL", font_red(msg) + ExtentTestManager.getTest().addBase64ScreenShot(ScreenShot.takeScreenshot(webdriver)));
		}
		
		WebdriverCommonLib.printMessage(msg);
	}
	




	public static String font_green(String msg){
		String return_text = "<font color=\"MediumSeaGreen\">" + msg + "</font>";
		return return_text;
	}
	
	public static String font_red(String msg){
		String return_text = "<font color=\"Tomato\">" + msg + "</font>";
		return return_text;
	}
	
	public static String font_blue(String msg){
		String return_text = "<font color=\"Black\">" + msg + "</font>";
		return return_text;
	}	
}
