package workingWithelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickWithAction {
	ChromeDriver drive ;

	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
	}
	@Test
	public void doubleclick ()
	{
		WebElement message = drive.findElement(By.id("message"));
		Actions builder =new Actions(drive);
		builder.doubleClick(message).perform();;
	}



}
