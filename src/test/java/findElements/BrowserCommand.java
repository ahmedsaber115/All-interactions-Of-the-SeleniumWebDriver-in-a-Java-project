package findElements;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserCommand {
ChromeDriver drive ;
	
	@BeforeTest
	public void openUrl () 
	{
		drive =new ChromeDriver();
		drive.navigate().to("https://the-internet.herokuapp.com/");
		System.out.println(drive.getCurrentUrl());
	}
	@Test
	public void CommandTest() 
	{
		drive.navigate().to("https://the-internet.herokuapp.com/login");
		System.out.println(drive.getCurrentUrl());
		drive.navigate().back();
		System.out.println(drive.getCurrentUrl());
		drive.navigate().forward();
		System.out.println(drive.getCurrentUrl());
		drive.navigate().refresh();
		System.out.println(drive.getCurrentUrl());
		drive.manage().window().maximize();	
		
	}
	

}
