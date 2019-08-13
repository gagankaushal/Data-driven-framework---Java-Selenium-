package mahesh1.Saveyouself;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.google.common.base.Predicate;


import Utilies.ExcelUtils;
import Utilies.StoreValuefromExcel;
public class utility {

	WebDriver driver;
	String fileName="OpenDefect_RetestPlan - GRS (003)_10 March.xlsx";
	String pathName=(System.getProperty("user.dir"));
	WebElement element;
	List<WebElement> elements;
	List<WebElement> elements2;
	//This class will handle the utility 
	
	public WebDriver openbroswer (String Browser)
	{
		
		 switch(Browser){  
		    case "FIREFOX": 
		    	driver=new FirefoxDriver() ;  
		    	break;
		    case "IE": System.out.println("IE TO Implement"); 
		         break;
		    case "CHROME": 
		    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\gagan.kaushal\\Desktop\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver(); 
		         break;
		    default:System.out.println("Kya hai "); 
		    break;
		    }
		 driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		return driver;}
	
	Map <Integer,StoreValuefromExcel>s= new HashMap<Integer,StoreValuefromExcel>();
	StoreValuefromExcel values;
	String sActionKeyword ,identified_by,target_identify_by,Data,Execution,holdTime;

	// to read excel
	StoreValuefromExcel strorevalue;;
	 public Map<Integer, StoreValuefromExcel> ExcelRead(String path,String sheet_name)
	 {
		 try {
			int lastrow=ExcelUtils.setExcelFile(path, sheet_name);
			System.out.println("last row value"+lastrow);
			for (int iRow=1;iRow<=lastrow;iRow++){
			    //Storing the value of excel cell in sActionKeyword string variable
				
	    		 sActionKeyword = ExcelUtils.getCellData(iRow, 3);
	    		 identified_by=ExcelUtils.getCellData(iRow, 4);
	    		 target_identify_by=ExcelUtils.getCellData(iRow, 5);
	    		 Data=ExcelUtils.getCellData(iRow, 6);
	    		Execution=ExcelUtils.getCellData(iRow, 7);
	    		holdTime=ExcelUtils.getCellData(iRow, 8);
	    		values=new StoreValuefromExcel(sActionKeyword ,identified_by,target_identify_by,Data,Execution,holdTime);
	    		s.put(iRow, values);
	    		
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally
		 {
			 return s ;
		 }
			
			
	 }
	
	 
	 Locator r= new Locator();
	 CheckElement s1= new CheckElement();
	 
	 public void Action(WebDriver driver,String keyword,final String identified_by,final String target_identify_by,String Data,String waitTime)
	 {
		 //navigate
		 switch (keyword)
		 {
		 case "NAVIGATE": 
		    	driver.get(Data);
		    	break;
		 case "CLOSE":
			    driver.close();
			    break;
		 case "QUIT":
			     driver.quit();
			     break;
		 case "CLICK":
			 if (waitTime.equalsIgnoreCase("N"))
			 {
				 element= s1.waitCondion(driver, identified_by, target_identify_by); 
			
			 }
			 else
			 {
				 element= s1.waitCondionhold(driver, identified_by, target_identify_by, waitTime);
			 }
			 element.click();
			   break;
			   
		 case "TEXTBOX":
			 
			 if (waitTime.equalsIgnoreCase("N"))
			 {
				 element= s1.waitCondion(driver, identified_by, target_identify_by); 
			
			 }
			 else
			 {
				 element= s1.waitCondionhold(driver, identified_by, target_identify_by, waitTime);
			 }	
			 	element.sendKeys(Data);
			 	break;
			 	
		 case "DROPDOWN":
			 if (waitTime.equalsIgnoreCase("N"))
			 {
				 element= s1.waitCondion(driver, identified_by, target_identify_by); 
			
			 }
			 else
			 {
				 element= s1.waitCondionhold(driver, identified_by, target_identify_by, waitTime);
			 }
			 		
			 		Select oSelect = new Select(element);
			 		List <WebElement> elementCount = oSelect.getOptions();
			 		System.out.println(elementCount.size());
			 		
			 		int iListSize = elementCount.size();
			 		 
					// Setting up the loop to print all the options
					for(int i =0; i < iListSize ; i++){
						// Storing the value of the option	
						String sValue = oSelect.getOptions().get(i).getText();
						// Printing the stored value
						System.out.println(sValue);
						// Putting a check on each option that if any of the option is equal to 'Africa" then select it 
						if(sValue.equals(Data)){
							oSelect.selectByIndex(i);
							break;
							}
						}

			 	break;   
			 	
		 case "LIST":
			    element=driver.findElement(By.linkText("reservations"));
			    element.click();
			 break;
			 
		 case "PRINT":
			 	String text;
			 	element= s1.waitCondion(driver, identified_by, target_identify_by);
			 	text = element.getText();
			 	System.out.println("Status : "+ text);
			 	break;
			 	
		 case "STOREandVERIFY":
			 	//WebElement[] elementS=new WebElement[23];
			 	List<WebElement> elementS = new ArrayList<>();
			 	//identified_by = "XPATH";
			 	
			 	for (int x=0; x<23; x++)
			 		{
			 			//for array elementS[x] =  driver.findElement(By.className("seatI"));
			 			//elementS.add(driver.findElement(By.className("seatI")));
			 			elementS.add(driver.findElement(r.locate(identified_by, target_identify_by)));
			 		}
			 		
			 	//elementS =  driver.findElement(By.className("seatI"));
			 	//List<WebElement> elementS =  driver.findByElements(By.class("seatI"));
			 	System.out.println("WebElements under observation are : "+ elementS);
			 	
			 	//VERIFY
			 	
			 	int count = 0;
			 	int sizeOfWebElementsList = elementS.size();
			 	for (int x=0; x<sizeOfWebElementsList; x++)
			 		System.out.println(elementS.get(x).getClass());
			 		//if (elementS.get(x).getClass() == "_available") //Change Password
			 			//	{
			 				//		count = count + 1;
			 					
			 			//	}
			 	
			 	if (count !=0)
			 		{
			 			System.out.println("Found an available slot");
			 		}
			 	else
			 		{
			 			System.out.println("Didn't find an available slot");
			 		}
				break;
			 	
		 default:System.out.println("Do not know what to do "); 
		          
		    break;
		 }
	 }
	
}
