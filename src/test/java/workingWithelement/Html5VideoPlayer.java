package workingWithelement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Html5VideoPlayer {
FirefoxDriver drive ;
	
	@BeforeTest
	public void openURL () 
	{
		drive=new FirefoxDriver();
		drive.navigate().to("http://cookbook.seleniumacademy.com/html5video.html");
	}
	@Test
	public void html5video() throws InterruptedException
	{
		WebElement videoplayer=drive.findElement(By.id("vplayer"));
		JavascriptExecutor js =drive;
		String source = (String) js.executeScript("return arguments[0].currentSrc", videoplayer);
		long duration =(long) js.executeScript("return arguments[0].duration", videoplayer);
		System.out.println(source + duration);
		js.executeScript("return arguments[0].play();", videoplayer);
		Thread.sleep(6000);
		js.executeScript("retutn arguments[0].pause();", videoplayer);
		Thread.sleep(3000);
		
		
	}

}
