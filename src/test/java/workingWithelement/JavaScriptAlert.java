package workingWithelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptAlert {
	ChromeDriver drive ;

	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
	}
	@Test
	public void Alert () throws InterruptedException 
	{
		WebElement alertbtn = drive.findElement(By.id("simple"));
		alertbtn.click();
		org.openqa.selenium.Alert alertmessage = drive.switchTo().alert();
		Assert.assertEquals("Hello! I am an alert box!", alertmessage.getText());
		alertmessage.accept();


	}
}
