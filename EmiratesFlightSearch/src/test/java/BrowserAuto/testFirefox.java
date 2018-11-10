package BrowserAuto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class testFirefox {
static WebDriver driver;
	//public static void main(String[] args) {
      @BeforeClass
       void  setUp(){
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\mi9180\\Downloads\\geckodriver-v0.23.0-win32\\geckodriver.exe");
    	 // System.setProperty("webdriver.chrome.driver", "C:/Automation/chromedriver.exe");
    	  WebDriverManager.chromedriver().setup();
    	 // WebDriverManager.firefoxdriver().setup();
		//driver= new FirefoxDriver();
    	  driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		

	}
      @Test
      void testUrl()  {
    	  driver.get("https://www.emirates.com/ae/english/");
    	  JavascriptExecutor js=(JavascriptExecutor)driver;
    	  WebElement Element = driver.findElement(By.linkText("Hotels"));
    	  js.executeScript("arguments[0].scrollIntoView();", Element);
    	  //Thread.sleep(3000);
    	  driver.findElement(By.name("clear Departure airport")).click();
    	 // Thread.sleep(3000);
    	  driver.findElement(By.name("Departure airport")).sendKeys("DXB");
    	 // Thread.sleep(3000);
    	  driver.findElement(By.name("Arrival airport")).sendKeys("London (LHR)");
    	 // driver.findElement(By.xpath("//div[@aria-label='London, United Kingdom London Heathrow Airport LHR Operated by Emirates']")).click();
    	 // Thread.sleep(2000);
    	//  driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB);
    	//  driver.findElement(By.cssSelector("body")).sendKeys(Keys.RETURN);
    	  driver.findElement(By.linkText("Continue")).click();
    	  driver.findElement(By.xpath("//label[@class='textfield__label']")).click();
    	  SimpleDateFormat formattedDate = new SimpleDateFormat("dd  MMM yy");            
  		Calendar c = Calendar.getInstance();        
  		//c.add(Calendar.DATE, 2);  // number of days to add      
  		//String deptDate = (String)(formattedDate.format(c.getTime()));
  		//deptDate="15  Nov 18";
  		//System.out.println("today date is " + deptDate);
  		c.add(Calendar.DATE, 8);
  		String deptDate = (String)(formattedDate.format(c.getTime()));
  		c.add(Calendar.DATE, 3);
  		String arrDate = (String)(formattedDate.format(c.getTime()));
  		//arrDate="16  Nov 18";
    	  driver.findElement(By.xpath("//a[@aria-label='"+deptDate+"']")).click();
    	  driver.findElement(By.xpath("//span[@class='label-text--default label-text--returning']")).click();
    	 // driver.findElement(By.xpath("//a[@aria-label='07  Nov 18']")).click();
    	  driver.findElement(By.xpath("//a[@aria-label='"+arrDate+"']")).click();
    	  //Thread.sleep(1000);
    	  driver.findElement(By.xpath("//button[@type='submit']")).click();
    	  //Thread.sleep(5000);
    	 // driver.findElement(By.id("search-flight-date-picker--depart")).click();
    	 // driver.findElement(By.xpath("//input[@id='search-flight-date-picker--depart']")).click();
    	 // Thread.sleep(10000);
    	  WebDriverWait wait=new WebDriverWait(driver, 30);
    	  Element=driver.findElement(By.xpath("//*[@id='ctl00_c_pH_heading1']"));
    	  wait.until(ExpectedConditions.elementToBeClickable(Element));
    	 // String warning=driver.findElement(By.xpath("//*[@id='ctl00_c_errorPnl']")).getText();
    	  List lowPrice=driver.findElements(By.id("ctl00_c_ctlLowPrice_dvLowestPriceDisplay"));
    	  if(lowPrice.size()==0){
    	  List warning=driver.findElements(By.xpath("//*[@id='ctl00_c_errorPnl']"));
    	  System.out.println("listsize:"+warning.size());
    	 // System.out.println("Warning: "+warning);
    	//  if(warning.contains("Sorry, no flights or fares are available for your selected date combination. Please select a fare on a different date combination from the options provided.")){
    		 if(warning.size()!=0){
    	  driver.findElement(By.id("modifySearchButton")).click(); 
    		  //Thread.sleep(2000);
    		  //driver.findElement(By.id("txtDepartDate")).click();
    		 WebElement element= driver.findElement(By.id("txtDepartDate"));
    		// WebElement element= driver.findElement(By.id("ctl00_c_ctlFltSearch_dvDepartDate"));
    		 // driver.findElement(By.xpath("//a[@aria-label='"+arrDate+"']")).click();
    		 // driver.findElement(By.id("txtDepartDate")).sendKeys("12 Nov 18");
    		 // driver.findElement(By.id("txtarrivaldate")).click();
    		 // driver.findElement(By.xpath("//a[@aria-label='"+arrDate+"']")).click();
    		//  driver.findElement(By.id("txtarrivaldate")).sendKeys("14 Nov 18");
    		  String dt="14 Nov 18";
    		 // js.executeScript("arguments[0].setAttribute('onfocus','if (EKCalendar) { EKCalendar.display(document.forms[0].txtDepartDate, new Date(2018, 10, 9), new Date(2019, 9, 2), document.forms[0].txtarrivaldate, 0); }');",element);
    		// js.executeScript("arguments[0].setAttribute('value','"+dt+"');",element);
    		  js.executeScript("document.getElementById('txtDepartDate').value='14 Nov 18'");
    		// element= driver.findElement(By.id("txtarrivaldate"));
    		// dt="16 Nov 18";
    		// js.executeScript("arguments[0].setAttribute('value','"+dt+"');",element);
    		  js.executeScript("document.getElementById('txtarrivaldate').value='16 Nov 18'");
    		 // Thread.sleep(2000);
    		 // element=driver.findElement(By.xpath("//a[@id='ctrlBrandedSearchClick']"));
    		//  wait.until(ExpectedConditions.elementToBeClickable(element));
    		 driver.findElement(By.xpath("//a[@id='ctl00_c_ctlFltSearch_ctrlSearchClick']")).click(); 
    		 lowPrice=driver.findElements(By.id("ctl00_c_ctlLowPrice_dvLowestPriceDisplay"));
    		 if(lowPrice.size()==0){
    		 driver.findElement(By.xpath("//a[@id='ctl00_c_btnContinue']")).click(); 
    		 Element=driver.findElement(By.xpath("//*[@id='ctl00_c_pH_heading1']"));
    		 wait.until(ExpectedConditions.elementToBeClickable(Element));
    		 String lowestPrice=driver.findElement(By.xpath("//span[@class='summary-curr-only']")).getText();
    		 System.out.println("Lowest Price Displayed is: "+lowestPrice);
    		 }else {
    			 String lowestPrice=driver.findElement(By.xpath("//span[@class='summary-curr-only']")).getText();
        		 System.out.println("Lowest Price Displayed is: "+lowestPrice);
    		 }
    		 
    	  }
    	  } else {
    		  String lowestPrice=driver.findElement(By.xpath("//span[@class='summary-curr-only']")).getText();
     		 System.out.println("Lowest Price Displayed is: "+lowestPrice);
    	  }
      }
      @AfterClass
      void tearDown() {
    	  driver.quit();
      }
      

}
