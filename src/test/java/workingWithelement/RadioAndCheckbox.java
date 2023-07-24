package workingWithelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioAndCheckbox {
	ChromeDriver drive ;

	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("https://the-internet.herokuapp.com/checkboxes");
	}

	@Test
	public void check()
	{
		WebElement checkbox1 = drive.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		checkbox1.click();

		WebElement checkbox2 = drive.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		if (checkbox2.isSelected())
		{
			checkbox2.click();
		}

	}


}


