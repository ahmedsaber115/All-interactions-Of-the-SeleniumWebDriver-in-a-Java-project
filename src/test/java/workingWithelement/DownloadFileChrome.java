package workingWithelement;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadFileChrome {
ChromeDriver drive ;
public static String downloadpath =System.getProperty("user.dir")+"\\download\\";
	public static ChromeOptions chromeoption() 
	{
		ChromeOptions option = new ChromeOptions();
		HashMap<String, Object> chromeprefs=new HashMap<String,Object>();
		chromeprefs.put("profile.default.content_settings.popups", 0);
		chromeprefs.put("download.default_directory", downloadpath);
		option.setExperimentalOption("prefs", chromeprefs);
		option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		return option;
		
	}
	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver(chromeoption()) ;
		drive.navigate().to("https://the-internet.herokuapp.com/download");
	}
	@Test
	public void filedown() 
	{
		drive.findElement(By.linkText("exl.jpg")).click();
	}
	 
}
 