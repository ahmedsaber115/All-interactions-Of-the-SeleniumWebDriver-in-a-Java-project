package findElements;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementinTable {
	ChromeDriver drive ;

	@BeforeTest
	public void openUrl () 
	{
		drive =new ChromeDriver();
		drive.navigate().to("https://the-internet.herokuapp.com/tables");
	}
	@Test
	public void elementTable() 
	{
		WebElement table = drive . findElement(By.id("table1")) ;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.get(2).getText());
	}
	@AfterTest
	public void close() 
	{
		drive.quit();
	}
}
