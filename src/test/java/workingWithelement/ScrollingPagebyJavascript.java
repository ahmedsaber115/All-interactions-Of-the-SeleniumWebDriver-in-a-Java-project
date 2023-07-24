package workingWithelement;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollingPagebyJavascript {
	ChromeDriver drive ;

	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("http://www.amazon.com");
	}

	@Test
	public void scrolling () 
	{
		JavascriptExecutor js = drive ;
		js.executeScript("scrollBy(0,3000)");
	}


}
