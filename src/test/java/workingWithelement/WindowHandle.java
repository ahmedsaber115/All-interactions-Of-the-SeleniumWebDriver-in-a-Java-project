package workingWithelement;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandle {
	ChromeDriver drive ;

	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
	}
	@Test(enabled = false)
	public void windowhandle () 
	{
		String currentwindow =drive.getWindowHandle();

		WebElement visitbtn = drive.findElement(By.id("visitbutton"));
		visitbtn.click();

		for(String newwindow : drive.getWindowHandles()) 
		{
			String windowtitle = drive.switchTo().window(newwindow).getTitle();

			if(windowtitle.equals("Visit Us")) 
			{
				assertEquals("Visit Us", drive.getTitle());
				drive.close();
				break;
			}

		}
		drive.switchTo().window(currentwindow);

	}

	// other method if we have name
	@Test
	public void windowbyname()
	{
		String currentwindow =drive.getWindowHandle();

		WebElement helpbtn = drive.findElement(By.id("helpbutton"));
		helpbtn.click();
		drive.switchTo().window("HelpWindow");
		drive.getTitle();
		assertEquals("Help", drive.getTitle());
		drive.close();
		drive.switchTo().window(currentwindow);

	}

}

