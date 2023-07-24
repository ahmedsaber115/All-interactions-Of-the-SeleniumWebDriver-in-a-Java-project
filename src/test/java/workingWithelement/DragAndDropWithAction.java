package workingWithelement;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropWithAction {
	ChromeDriver drive ;

	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");
	}
	@Test
	public void dradanddrop() 
	{
		WebElement element1 = drive.findElement(By.id("draggable"));
		WebElement element2 = drive.findElement(By.id("droppable"));
		Actions builder = new Actions(drive);
		builder.dragAndDrop(element1, element2).perform();;
		assertEquals("Dropped!!", element2.getText());
	}

}
