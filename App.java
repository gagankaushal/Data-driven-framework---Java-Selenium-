package mahesh1.Saveyouself;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;

import Utilies.ExcelUtils;
import Utilies.StoreValuefromExcel;
import org.openqa.selenium.By;
import java.util.HashMap;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       



        class Toload {
        	
        	WebDriver driver;
        	utility s =new utility();
        	Engine torun=new Engine();
        	//@Test
        	public void test() {
        		 
        		 
        		Map s1;
        		Map <Integer,StoreValuefromExcel>Excelvalues= new HashMap<Integer,StoreValuefromExcel>();
        		
        		 
        		 String s2,sheetname;
        		 sheetname="SDSU";
        		 String pathName=(System.getProperty("user.dir"));
        		 String fileName="Book3.xlsx";
        		
        		 pathName=pathName+"\\"+fileName;
        		 
        		 Excelvalues= s.ExcelRead(pathName, sheetname);
        		 
        		 
        		 torun.todo(Excelvalues);
        		 
        	}
            

        }
        class CheckElement {
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
        class Engine {
        	utility s =new utility();
        	WebDriver driver;
        	String a;
        	private String Data,target_identify_by,identified_by,keyword,waitTime;
        	public void todo(Map<Integer, StoreValuefromExcel> ExcelRead)
        	{
        	 Map<Integer, StoreValuefromExcel> Excel=ExcelRead;
        	 Iterator it = Excel.entrySet().iterator();
        	 
        	 while(it.hasNext())
        	 {
        		 Map.Entry pair = (Map.Entry)it.next();
        	        
        	        StoreValuefromExcel Storevaluefromexcel=(StoreValuefromExcel) pair.getValue();
        	        System.out.println(Storevaluefromexcel.Data+" "+Storevaluefromexcel.Executionindicator);
        	        if (Storevaluefromexcel.Executionindicator.equalsIgnoreCase("Y"))
        	        {
        	        	if (Storevaluefromexcel.keyword.equalsIgnoreCase("openbroswer"))
        	        	{
        	        		System.out.println("i have to get here");

        	        		a=(String)Storevaluefromexcel.Data.trim();
        	        		System.out.println(a);
        	        		driver=s.openbroswer(Storevaluefromexcel.Data.trim());
        	        	}
        	        	else 
        	        	{
        	        		Data=Storevaluefromexcel.Data;
        	        		target_identify_by=Storevaluefromexcel.target_identify_by;
        	        		identified_by=Storevaluefromexcel.identified_by;
        	        		keyword=Storevaluefromexcel.keyword;
        	        		waitTime=Storevaluefromexcel.waitTime;
        	        		
        	        		
        	        		s.Action(driver, keyword, identified_by, target_identify_by, Data,waitTime);
        	        		
        	        	}
        	        }
        	        
        	 }
        	}

        }
        class Locator {
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

        class utility {

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
        		 
        		 default:System.out.println("Do not know what to do "); 
        		          
        		    break;
        		 }
        	 }
        	
        }

    }
}

