package mahesh1.Saveyouself;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class CheckElement {
	Locator r= new Locator();
	public WebElement waitCondion(WebDriver driver,final String identified_by, final String target_identify_by)
	{
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.withTimeout(5, TimeUnit.MINUTES);
		
		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("Checking for the object!!");
				WebElement element = driver.findElement(r.locate(identified_by, target_identify_by));
				if (element != null) {
					System.out.println("A new dynamic object is found.");
				}
				return element;
			}
		};
		return wait.until(function);
		
	}
	
	public WebElement waitCondionhold(WebDriver driver,final String identified_by, final String target_identify_by, String waittime)
	{
		if (waittime.contains("."))
		{
			int i=waittime.indexOf(".");
			waittime=waittime.substring(0, i);
			System.out.println(waittime);
		}
		final int waitandHold=Integer.parseInt(waittime);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.withTimeout(5, TimeUnit.MINUTES);
		
		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("Checking for the object!!");
				WebElement element = driver.findElement(r.locate(identified_by, target_identify_by));
				if (element != null) {
					System.out.println("A new dynamic object is found.");
					try {
						Thread.sleep(waitandHold);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				return element;
			}
		};
		return wait.until(function);
		
	}
	

}
