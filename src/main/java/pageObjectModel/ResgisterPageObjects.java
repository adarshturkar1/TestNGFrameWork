package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResgisterPageObjects {

	 public WebDriver driver;
	 
		private By FirstName = By.xpath("//input[@name='firstname']");
		private By LastName = By.xpath("//input[@name='lastname']");
		private By EMail = By.xpath("//input[@name='email']");
		private By Telephone = By.xpath("//input[@name='telephone']");
		private By Password = By.xpath("//input[@name='password']");
		private By PasswordConfirm = By.xpath("//input[@name='confirm']");
		private By Agree = By.xpath("//input[@name='agree']");
		private By Continue = By.xpath("//input[@value='Continue']");
		
		private By registerationSucesfull= By.xpath("//h1[text()='Your Account Has Been Created!']"); 
		
		
		private By FirstNameError = By.xpath("//div[text()='First Name must be between 1 and 32 characters!'] ");
		private By LastNameError = By.xpath("//div[text()='Last Name must be between 1 and 32 characters!'] ");
		private By EMailError = By.xpath("//div[text()='E-Mail Address does not appear to be valid!'] ");
		private By TelephoneError = By.xpath("//div[text()='Telephone must be between 3 and 32 characters!'] ");
		private By PasswordError = By.xpath("//div[text()='Password must be between 4 and 20 characters!'] ");
		 
		
		
		
		
		
		
		public ResgisterPageObjects(WebDriver driver2) {
			// TODO Auto-generated constructor stub
			
			this.driver=driver2;
		}


		public WebElement sendKeysOnFirstName() {
	       
			return driver.findElement(FirstName);	
		}
	
		
		public WebElement sendKeysOnLastName() {
			
			return driver.findElement(LastName);
		}
	
		
		public WebElement sendKeysOnEMail() {
	       
			return driver.findElement(EMail);	
		}
	
		
		public WebElement sendKeysOnTelephone() {
			
			return driver.findElement(Telephone);
		}
	
		
		public WebElement sendKeysOnPassword() {
	       
			return driver.findElement(Password);	
		}
	
		
		public WebElement sendKeysOnPasswordConfirm() {
			
			return driver.findElement(PasswordConfirm);
		}
		
        public WebElement clickOnAgree() {
			
			return driver.findElement(Agree);
		}
		
		public WebElement clickOnContinue() {
			
			return driver.findElement(Continue);
		}
		
		
		
		
		
		


		public WebElement FirstNameError() {
	       
			return driver.findElement(FirstNameError);	
		}
	
		
		public WebElement LastNameError() {
			
			return driver.findElement(LastNameError);
		}
	
		
		public WebElement EMailError() {
	       
			return driver.findElement(EMailError);	
		}
	
		
		public WebElement TelephoneError() {
			
			return driver.findElement(TelephoneError);
		}
	
		
		public WebElement PasswordError() {
	       
			return driver.findElement(PasswordError);	
		}
	
		
		
		
		
		
		
		public WebElement getRegisterationSuccesfullText() { 
	 		return driver.findElement(registerationSucesfull); 	
	 	} 
		
	
		
}
