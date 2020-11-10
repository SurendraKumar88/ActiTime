package extentReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.actitime.genericlib.BaseClass;
import com.relevantcodes.extentreports.LogStatus;


public class SeleniumListners extends BaseClass implements ITestListener {

	 private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	    }
	
	
	public void onTestStart(ITestResult result) {
		ExtentTestManager.startTest(getTestMethodName(result), "");
		
	}

	
	public void onTestSuccess(ITestResult result) {
		PrintUtil.testCasePassedWithScreenshot(driver, "Test Case Passed");
		
	}

	
	public void onTestFailure(ITestResult result) {
		PrintUtil.testCaseFailedWithScreenshot("Test Case Failed", driver);
	}

	
	public void onTestSkipped(ITestResult result) {
		 System.out.println("I am in onTestSkipped method "+  getTestMethodName(result) + " skipped");
		 ExtentTestManager.startTest(getTestMethodName(result), "");
	     ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	public void onFinish(ITestContext context) {
		 System.out.println("I am in onFinish method " + context.getName());
	        ExtentTestManager.endTest();
	        ExtentManager.getInstance().flush();
	        
	}


}
