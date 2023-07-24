package workingWithelement;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllBroknLINKS {
	ChromeDriver drive ;
	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("https://the-internet.herokuapp.com/");
	}
	@Test
	public void alllinkstest () throws Exception 
	{
		List<WebElement> alllinks = drive.findElements(By.tagName("a"));
		System.out.println(alllinks.size());
		for(int i = 0 ; i<alllinks.size() ; i++) 
		{
			WebElement element = alllinks.get(i);
			String urllinkname = element.getAttribute("href");
		
			verifyalllinks(urllinkname);
		}
		
	}
	public void verifyalllinks(String urllink) throws Exception 
	{
		try {
			URL link = new URL(urllink) ;

			// create connection
			HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
			httpconn.setConnectTimeout(2000);
			httpconn.connect();

			// get response code 
			if(httpconn.getResponseCode()==200) 
			{
				System.out.println(urllink + "-" + httpconn.getResponseMessage());
			}


		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
	}


}
