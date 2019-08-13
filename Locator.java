package mahesh1.Saveyouself;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locator {
	WebDriver driver;
	String identified_by;
	WebElement element;
	String target_identify_by;
	String k;
	By s;
	
	public WebElement toLocate(WebDriver driver,String identified_by,String target_identify_by)
	{
		switch (identified_by)
		{
		case "ID":
			element=driver.findElement(By.id(target_identify_by));
		}
		return element;
		
	}
	
	public By locate(String identified_by,String target_identify_by)
	{
		switch (identified_by)
		{
		case "ID":
			s=(By.id(target_identify_by));
			break;
		case "XPATH":
			s=(By.xpath(target_identify_by));
			break;
		case "CSS":
			s=By.cssSelector(target_identify_by);
			break;
		case "CLASSNAME":
			s=By.className(target_identify_by);
			break;
		case "LINKTEXT":
			s=By.linkText(target_identify_by);
			break;
		case "NAME":
			s=By.name(target_identify_by);
			break;
		case "PARTIALLINKTEXT":
			s=By.partialLinkText(target_identify_by);
			break;
		case "TAGNAME":
			s=By.tagName(target_identify_by);
		
		default:
			System.out.println("which one you want know ");
		}
		return s;
		
	}

}
