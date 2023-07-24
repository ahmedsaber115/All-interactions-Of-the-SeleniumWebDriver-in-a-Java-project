package workingWithelement;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadFileFirefox {
	FirefoxDriver drive ;
	public static String downloadpath =System.getProperty("user.dir")+"\\download\\";
	public static FirefoxOptions firefoxoption()
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadpath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "apllication/octet-stream");
		option.addPreference("browser.download.manger.showWhenStarting", false);
		return option;
	}

	@BeforeTest
	public void openURL () 
	{
		drive=new FirefoxDriver(firefoxoption()) ;
		drive.navigate().to("https://the-internet.herokuapp.com/download");
	}
	@Test
	public void firefoxfiledown() 
	{
		drive.findElement(By.linkText("test-file.txt")).click();
	}

}
