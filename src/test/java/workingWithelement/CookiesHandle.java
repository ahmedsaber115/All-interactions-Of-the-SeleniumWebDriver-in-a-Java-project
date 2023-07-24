package workingWithelement;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CookiesHandle {
	ChromeDriver drive ;

	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("http://magento-demo.lexiconn.com/");
	}
	@Test
	public void cookieshandle() 
	{
		WebElement langlist = drive.findElement(By.id("select-language"));
		Select lang =new Select(langlist);
		Assert.assertEquals("English", lang.getFirstSelectedOption().getText());

		//sure that store cookies is null
		Cookie cookie1 = drive.manage().getCookieNamed("store"); 
		Assert.assertEquals(null, cookie1);

		lang.selectByVisibleText("German");

		// sure cookies is stored
		cookie1 = drive.manage().getCookieNamed("store");
		Assert.assertEquals("german", cookie1.getValue());

		// get all cookies
		Set<Cookie> allcookies =drive.manage().getCookies();
		Iterator<Cookie> itr = allcookies.iterator();
		System.out.println(allcookies.size());
		while (itr.hasNext()) 
		{
			Cookie cookie = itr.next();
			System.out.println(cookie.getDomain());
		}


	}

}
