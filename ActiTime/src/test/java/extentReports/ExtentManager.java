package extentReports;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports instance;

	public static synchronized ExtentReports getInstance() {
		if (instance == null) {
			System.out.println(System.getProperty("user.dir"));
			instance = new com.relevantcodes.extentreports.ExtentReports("./target/surefire-reports/ExtentReports.html",
					true);
			instance.loadConfig(new File("./src/main/java/extentReports/extent-config.xml"));
		}

		return instance;
	}

}