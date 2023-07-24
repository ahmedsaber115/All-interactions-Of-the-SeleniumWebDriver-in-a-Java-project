package workingWithelement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenue {
	ChromeDriver drive ;

	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");
	}
	@Test
	public void menue () throws InterruptedException
	{

		WebElement btnclick = drive.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
		WebElement menue = drive.findElement(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-edit"));
		Actions builder =new Actions(drive);
		builder.contextClick(btnclick).moveToElement(menue).click().perform();;
		Thread.sleep(3000);
		Alert alertmessage =drive.switchTo().alert();
		alertmessage.dismiss();

	}
}
