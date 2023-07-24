package findElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindByID {
	ChromeDriver drive ;
	
	@BeforeTest
	public void openUrl () 
	{
		drive =new ChromeDriver();
		drive.navigate().to("https://id.heroku.com/login");
	}

	@Test
	public void findbyID() 
	{
		WebElement Username =drive. findElement(By.id("email"));
		WebElement Password =drive. findElement(By.id("password"));
		System.out.println(Username.getTagName());
		System.out.println(Password.getTagName());
	}
	@AfterTest
	public void close() 
	{
		drive.quit();
	}
}
