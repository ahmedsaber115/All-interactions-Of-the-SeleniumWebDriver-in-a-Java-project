package workingWithelement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownList {
	ChromeDriver drive ;
	
	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("https://the-internet.herokuapp.com/dropdown");
	}
	 
	@Test
	public void droplist() 
	{
		WebElement list = drive.findElement(By.id("dropdown"));
		Select droplist = new Select(list);
		Assert.assertFalse(droplist.isMultiple());
		Assert.assertEquals(3, droplist.getOptions().size());
		droplist.selectByValue("1");
	}

}
