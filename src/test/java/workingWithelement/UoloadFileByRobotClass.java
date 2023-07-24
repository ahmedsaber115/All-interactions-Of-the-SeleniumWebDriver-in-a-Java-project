package workingWithelement;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UoloadFileByRobotClass {

	ChromeDriver drive ;
	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("https://www.w3schools.com/howto/howto_html_file_upload_button.asp");
	}
	@Test
	public void uploadfiles () throws AWTException , InterruptedException
	{
		String picname = "testpic.jpg";
		String picpath = System.getProperty("user.dir")+"\\upload\\"+picname;
		WebElement choosefile = drive.findElement(By.id("myFile"));
		choosefile.click();

		Robot robot = new Robot();
		// ctrl+ c ,copyfile
		StringSelection selection=new StringSelection(picpath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);

		//ctrl + v
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		WebElement uploadfilebtn =drive.findElement(By.id("file-submit"));
		uploadfilebtn.click();
		WebElement uploadedfile =drive.findElement(By.id("uploaded-files"));
		Assert.assertEquals(picname,uploadedfile.getText() );

	}
}

