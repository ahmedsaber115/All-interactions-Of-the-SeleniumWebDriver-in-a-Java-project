package findElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindbyelementS {
	ChromeDriver drive ;

	@BeforeTest
	public void openUrl () 
	{
		drive =new ChromeDriver();
		drive.navigate().to("https://the-internet.herokuapp.com/");
	}

	@Test

	public void elements ()
	{
		List<WebElement> sitelinks = drive.findElements(By.tagName("a"));

		for (WebElement links : sitelinks) {
			System.out.println(links.getAttribute("href"));
		}

	}
	@AfterTest
	public void close() 
	{
		drive.quit();
	}

}
