package workingWithelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextboxandButton {
	ChromeDriver drive ;
	@BeforeTest
	public void openUrl () 
	{
		drive =new ChromeDriver();
		drive.navigate().to("https://the-internet.herokuapp.com/login");
	}
	@Test
	public void loginscreen () 
	{
		WebElement username = drive.findElement(By.id("username"));
		WebElement passsword = drive.findElement(By.id("password"));
		WebElement btnlogin = drive.findElement(By.className("radius"));
		
		username.clear();
		username.sendKeys("tomsmith");
		passsword.clear();
		passsword.sendKeys("SuperSecretPassword!");
		btnlogin.click();
		WebElement checkloggin = drive.findElement(By.id("flash"));
		Assert.assertTrue(checkloggin.getText().contains("You logged into a secure area!"));
		System.out.println("You are in secure loggin area");
		
	
	}
	@AfterTest
	public void close() 
	{
		drive.quit();
	}

}
