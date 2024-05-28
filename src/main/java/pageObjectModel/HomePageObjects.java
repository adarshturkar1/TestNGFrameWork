package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
 
	// null driver don't have any scope, so whichever driver has a scope we will provide that scope to this type of driver 
	 public WebDriver driver; 
	 
	//By can store Xpath
	// need to access this both in TestCases , but due to private it will be not possible
	// so we will use getter and setter method
	// setter method 
	//incapsulation declare private and use public getter and setter 
	private By myAccount = By.xpath("//i[@class='fa fa-user']");
	private By resgister = By.xpath("//a[text()='Register']");
	private By login = By.xpath("//a[text()='Login']");
	
	//getter method
	
	public HomePageObjects(WebDriver driver2) { // this driver2 has scope of 'registerTestCases'
		// TODO Auto-generated constructor stub 
		
		this.driver=driver2; // by this we have given scope of 'driver' to 'driver2'
		
	}

	public WebElement clickOnMyAccount1() {
       
		// void means return noting, so we will create separate driver by declaring " public WebDriver driver;" 
		return driver.findElement(myAccount);
		
		
	}
	
	public WebElement clickOnRegister() {
		
		return driver.findElement(resgister);
		
	}
	
   public WebElement clickOnlogin() {
		
		return driver.findElement(login);
		
	}
	
}
