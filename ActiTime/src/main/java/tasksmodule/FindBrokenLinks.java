package tasksmodule;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLinks {

	public static void main(String[] args) {

		String homePageUrl = "https://amazon.com";
		HttpURLConnection huc = null;
		int respCode = 200;
		String url = null;

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(homePageUrl);

		List<WebElement> link = driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = link.iterator();

		while (it.hasNext()) {
			url = it.next().getAttribute("href");
			System.out.println(url);

			if (url == null || url.isEmpty()) {
				System.out.println("URL not configured or it's empty");
				continue;
			}

			if (!url.startsWith(homePageUrl)) {
				System.out.println("URL belongs to another domain pls skip it");
				continue;
			}

			try {
				huc = (HttpURLConnection) new URL(url).openConnection();

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}

			} catch (Exception e) {
				e.getMessage();
			}

		}

	}

}
