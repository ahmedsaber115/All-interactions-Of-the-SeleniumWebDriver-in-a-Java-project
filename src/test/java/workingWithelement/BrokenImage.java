package workingWithelement;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenImage {
	ChromeDriver drive ;
	int invalidimagecount ;

	@BeforeTest
	public void openURL () 
	{
		drive=new ChromeDriver() ;
		drive.navigate().to("https://the-internet.herokuapp.com/broken_images");
	}
	@Test
	public void testbrokenimage () 
	{
		invalidimagecount = 0 ;
		List<WebElement> imagelist =drive.findElements(By.tagName("img"));
		for (WebElement imagestate: imagelist) {
			if (imagestate != null)
			{
				verfybrokenimage(imagestate);
			}
		}

		System.out.println("totla invalid image =" + invalidimagecount);
	}
	public void verfybrokenimage (WebElement image )
	{
		org.apache.http.client.HttpClient client = HttpClientBuilder.create().build();
		HttpGet request =new HttpGet(image.getAttribute("src"));
		try {
			HttpResponse responce = client.execute(request);
			if (responce.getStatusLine().getStatusCode() != 200) {
				invalidimagecount++;
			}


		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



	}
}
