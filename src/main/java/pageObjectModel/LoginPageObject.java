package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {

	
	 public WebDriver driver;
	 
		private By EMailAddress = By.xpath("//input[@id = 'input-email']");   
		private By Password = By.xpath("//input[@id = 'input-password']");          
		private By Login = By.xpath("//input[@value = 'Login']");  
		
		private By LoginSucesfull= By.xpath("//h2[text()='My Account']"); 
		
		private By loginfailedtext=By.xpath("//div[@class='alert alert-danger alert-dismissible']"); 
	
		public LoginPageObject(WebDriver driver2) {
			// TODO Auto-generated constructor stub
			
			this.driver=driver2;
		}


		public WebElement sendKeysOnEMailAddress() {
	       
			return driver.findElement(EMailAddress);	
		}
	
		
		public WebElement sendKeysOnPassword() {
			
			return driver.findElement(Password);
		}
	
		
		public WebElement ClickOnLogin() {
	       
			return driver.findElement(Login);	
		}
		
		
		public WebElement getLoginSucesfull() { 
	 		return driver.findElement( LoginSucesfull); 
		}
		
		
		public WebElement getLoginFailedText() { 
	 		return driver.findElement(loginfailedtext); 
	 	} 
		
}
