package TasksModule;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.genericlib.BaseClass;
import com.actitime.genericlib.WebdriverCommonLib;
import com.actitime.objectrepositorylib.CreateNewTasksPage;
import com.actitime.objectrepositorylib.HomePage;
import com.actitime.objectrepositorylib.OpenTasksPage;

@Listeners(extentReports.SeleniumListners.class)
public class Tasks extends BaseClass {

	@Test
	public static void createTask() {

		String customerName = "Surendra";
		String projectName = "Verizon";
		String taskName = "Create prod" + ran.nextInt();

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.tasksLink();

		OpenTasksPage openTask = PageFactory.initElements(driver, OpenTasksPage.class);
		openTask.createNewTask();

		CreateNewTasksPage createNewTask = PageFactory.initElements(driver, CreateNewTasksPage.class);
		createNewTask.createNewTask(customerName + ran.nextInt(), projectName, taskName);

		boolean result = false;
		result = WebdriverCommonLib.verifyLinkIsDisplayed(taskName);

		Assert.assertTrue(result);

	}

	@Test
	public static void getTheListOfTasks() throws Throwable {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.tasksLink();

		OpenTasksPage openTask = new OpenTasksPage();
		openTask.getTheListOfTasks();

	}
}
