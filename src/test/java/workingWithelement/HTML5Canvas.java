package workingWithelement;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HTML5Canvas {
	ChromeDriver drive ;

	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("http://cookbook.seleniumacademy.com/html5canvasdraw.html");
	}
	@Test
	public void canvas() throws InterruptedException, IOException 
	{
		WebElement droplist = drive.findElement(By.id("dtool"));
		Select select =new Select(droplist);
		select.selectByVisibleText("Pencil");
		WebElement canvas =drive.findElement(By.id("imageTemp"));
		Actions builder =new Actions(drive);
		builder.clickAndHold(canvas).moveByOffset(10, 50).moveByOffset(50, 10).release().perform();;
		Thread.sleep(4000);
		
	//	TakesScreenshot drive;
		File source = canvas.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshotfile/canvas.png"));
	}
}
