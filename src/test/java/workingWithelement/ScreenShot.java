package workingWithelement;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShot {
	ChromeDriver drive ;

	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("https://www.amazon.eg/s?k=amazon+egypt&language=ar_AE&adgrpid=136548035725&hvadid=636086272285&hvdev=c&hvlocphy=9112343&hvnetw=g&hvqmt=e&hvrand=16500819460333128043&hvtargid=kwd-298964289059&hydadcr=22118_2261800&tag=txtgostddear-21&ref=pd_sl_943g3skdjb_e");
	}
	@Test
	public void screenshotpng ()
	{
		WebElement searchbar = drive.findElement(By.id("twotabsearchtextbox44"));
		searchbar.clear();
		searchbar.sendKeys("selenium");
		searchbar.submit();
	}
	@AfterMethod
	public void takescreenshot (ITestResult result) throws IOException 
	{
		if (ITestResult.FAILURE==result.getStatus()) 
		{
			TakesScreenshot picture =drive;
			File source = picture.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshotfile/" + result.getName() + ".png"));
		}
	}
}


