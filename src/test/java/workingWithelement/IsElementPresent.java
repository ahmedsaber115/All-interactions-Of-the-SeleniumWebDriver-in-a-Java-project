package workingWithelement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IsElementPresent {
	ChromeDriver drive ;

	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("https://the-internet.herokuapp.com/checkboxes");
	}


	private boolean isElementPrecense (By by) {
		try {
			drive.findElement(by);
			return true ;

		} catch (NoSuchElementException e) {
			return false ;
		}
	}

	@Test
	public void elemnt () 
	{
		if (isElementPrecense(By.xpath("//*[@id=\"checkboxes\"]/input[1]"))) {
			WebElement box1 = drive.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
			if (!box1.isSelected()) {
				box1.click();
			}

		} else {
			Assert.fail("box 1 no exist");
		}
	}

}
