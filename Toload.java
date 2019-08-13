package mahesh1.Saveyouself;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.WebDriver;
//--
import org.openqa.selenium.WebElement;
//--
import org.openqa.selenium.firefox.FirefoxDriver;
//--
import org.testng.Assert;
//--
import org.testng.annotations.AfterClass;
//--
import org.testng.annotations.BeforeClass;
//--
import org.testng.annotations.Test;

import Utilies.StoreValuefromExcel;



public class Toload {
	
	WebDriver driver;
	utility s =new utility();
	Engine torun=new Engine();
	@Test
	public void test() {
		 
		 
		Map s1;
		Map <Integer,StoreValuefromExcel>Excelvalues= new HashMap<Integer,StoreValuefromExcel>();
		
		 
		 String s2,sheetname;
		 //sheetname="SDSU";
		 //sheetname="UCDAVIS";
		 //sheetname="BookMyShow";
		 sheetname="BookMyShow (2)";
		 String pathName=(System.getProperty("user.dir"));
		 String fileName="Book3.xlsx";
		
		 pathName=pathName+"\\"+fileName;
		 
		 Excelvalues= s.ExcelRead(pathName, sheetname);
		 
		 
		 torun.todo(Excelvalues);
		 
	}
    

}
