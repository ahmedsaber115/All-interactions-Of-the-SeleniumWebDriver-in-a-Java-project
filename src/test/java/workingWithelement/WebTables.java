package workingWithelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTables {
	ChromeDriver drive ;
	@BeforeTest
	public void openUrl () 
	{
		drive =new ChromeDriver();
		drive.navigate().to("https://the-internet.herokuapp.com/tables");
	}
	@Test
	public void webtables () 
	{
		WebElement table1 = drive.findElement(By.id("table1")) ;	
		List<WebElement> rows = table1.findElements(By.tagName("tr"));
		for (WebElement row : rows) 
		{
			List<WebElement>col =row.findElements(By.tagName("td"));
			for (WebElement coulmn : col)
			{
				System.out.println(coulmn.getText());
			}
		}


	}

}

