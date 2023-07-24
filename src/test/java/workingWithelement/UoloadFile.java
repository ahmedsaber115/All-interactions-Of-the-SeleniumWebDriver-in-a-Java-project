package workingWithelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class UoloadFile {
	ChromeDriver drive ;
	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("https://the-internet.herokuapp.com/upload");
	}
	@Test
	public void uploadfile () 
	{
		String picname = "testpic.jpg";
		String picpath = System.getProperty("user.dir")+"/upload/"+picname;
		WebElement choosefile =drive.findElement(By.id("file-upload"));
		WebElement uploadfilebtn =drive.findElement(By.id("file-submit"));
		choosefile.sendKeys(picpath);
		uploadfilebtn.click();
		WebElement uploadedfile =drive.findElement(By.id("uploaded-files"));
		Assert.assertEquals(picname,uploadedfile.getText() );

	}
}
