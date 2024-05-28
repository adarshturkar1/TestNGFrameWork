package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class baseClass {
public static WebDriver driver;           // changed public to static

public static String emailId=generateRandoEmailID(); 

public Properties prop;
	 
	//WebDriver driver=new ChromeDriver(); 
	
	public void initilizeDriver() throws IOException {
	
		// Read the properties file -- 
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		// help to access data from file -- 
		  prop = new Properties();
		
		// loading  fis in prop
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			driver = new ChromeDriver();
	
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		}	
		else if (browserName.equalsIgnoreCase("edge")) {
					
			driver = new EdgeDriver();
		}
		else {
					  
				  System.out.println("Please choose the proper browser");
					  
				  }
		
	}
	
	
	//created a method to generate random email id using System.currentTimeMillis()
	// stored a returned email in variable above
	 public static String generateRandoEmailID() { 
		  
 		 return "test"+System.currentTimeMillis()+"@gmail.com"; 
 		 
 		  } 
		
	 @BeforeMethod
	 public void browserAndurlLaunch() throws IOException {
		
		 initilizeDriver();
		
		driver.get(prop.getProperty("url"));
		
	 }  
	 
	 
	 
	// To take the screenshot and store in one folder- 
	 		public static String screenShot(WebDriver driver, String filename) { 
	 			String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); 
	 			// 20240517100712 
	  
	 			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
	 			String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + dateAndTime + ".png"; 
	 			 
	 			try { 
	 				FileUtils.copyFile(source, new File(destination)); 
	 			} catch (Exception e) { 
	 				e.getMessage(); 
	 			} 
	 			return destination; 
	 		} 
	 		 
	 		 
	 		 
	 		@BeforeSuite 
	 		public void ExtentReport() { 
	 			extentReportManager.setup(); 
	 		} 
	 		 
	 		@AfterSuite 
	 		public void endReport() { 
	 			extentReportManager.endReport(); 
	 		} 
	  
	 	 
	 }
	 
	 
	 

