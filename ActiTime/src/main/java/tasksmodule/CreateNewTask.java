package tasksmodule;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.genericlib.BaseClass;
import com.actitime.genericlib.WebdriverCommonLib;
import com.actitime.objectrepositorylib.CreateNewTasksPage;
import com.actitime.objectrepositorylib.HomePage;
import com.actitime.objectrepositorylib.OpenTasksPage;

@Listeners(extentReports.SeleniumListners.class)
public class CreateNewTask extends BaseClass{

	@Test(priority=1)
	public static void createNewTask(){
		
		String taskName = "task"+ran.nextInt();
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.tasksLink();
		
		OpenTasksPage openTasksPage = PageFactory.initElements(driver, OpenTasksPage.class);
		openTasksPage.createNewTask();
		
		CreateNewTasksPage createNewTaskPage = PageFactory.initElements(driver, CreateNewTasksPage.class);
		createNewTaskPage.createNewTask("suri"+ran.nextInt(), "kumar"+ran.nextInt(), taskName);
		
		boolean result = WebdriverCommonLib.verifyLinkIsDisplayed(taskName);
		
		
		Assert.assertTrue(result);
		
	}
	
}
