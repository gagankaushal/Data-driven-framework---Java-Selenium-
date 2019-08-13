package mahesh1.Saveyouself;

import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import Utilies.StoreValuefromExcel;

public class Engine {
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
