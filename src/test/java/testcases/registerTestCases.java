package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.HomePageObjects;
import pageObjectModel.ResgisterPageObjects;
import resources.baseClass;
import resources.commonMethods;
import resources.testData;

public class registerTestCases extends baseClass {

	//no mail method as we are using TestNg
	
	@Test(priority=1)
	public void verifyRegistrrationWithValideData() throws IOException {
		
		// object is not required because main method is not there and when one method is called from other method object is not required. 
////initilizeDriver();
		
		//driver is accessable because WebDriver Driver is declared by global variable "public" in baseClass.
		//Scope is available  , so we will add driver in bracket of 'new HomePageObjects()'
////driver.get("https://naveenautomationlabs.com/opencart/");
		
		// will not call xpath like this , only .click should be there.
		//driver.findElement(By.xparth("//span[text()='My Account']")).click();
		//driver.findElement(By.xparth("//a[text()='Register']")).click();
		
		// (By.xparth("//span[text()='My Account']")) , we have saved this part in HomePageObjects
		// (By.xparth("//a[text()='Register']")) , we have saved this part in HomePageObjects
		
		//driver.findElement , instead of using this we will use getter and setter method in HomePageObjects
		
		//as our method is in HomePageObjects , so we have created object and called both the methods 
		HomePageObjects hpo=new HomePageObjects(driver);
		
		 
		/*  // Thread.sleep(4000);  ---
                                   \
             WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
              wait.until(ExpectedConditions.visibilityOf(hpo.clickOnMyAccount1()));
                                    | 
                                    | // Below we have created the common method for above wait 
        */
		  commonMethods.handleExplictWait(driver, 3, hpo.clickOnMyAccount1());
		
        
                                    
		hpo.clickOnMyAccount1().click();
		hpo.clickOnRegister().click();
		
		ResgisterPageObjects hpos = new ResgisterPageObjects(driver);
		
		hpos.sendKeysOnFirstName().sendKeys(testData.firstname);
		hpos.sendKeysOnLastName().sendKeys(testData.lastname);
		hpos.sendKeysOnEMail().sendKeys(emailId);
		hpos.sendKeysOnTelephone().sendKeys(testData.telephome);
		hpos.sendKeysOnPassword().sendKeys(testData.password);
		hpos.sendKeysOnPasswordConfirm().sendKeys(testData.Confirmpassword);
		hpos.clickOnAgree().click();
		hpos.clickOnContinue().click();
		
		
		String expected=testData.regisgterationSuccessExpected; //requirement document 
 		String actual= hpos.getRegisterationSuccesfullText().getText(); //after running the scripts 
		
		/*SoftAssert sa=new SoftAssert();
		sa.assertEquals(actual,expected,"Your textis not matching");
		                                   //optional, this msg will show only when this gets failed .
		sa.assertAll();*/
		
		commonMethods.handleAssertion(actual, expected);
		
	}                                    

	
@Test(enabled=false) // SoftAssert lefttt
public void verifyRegistrrationWithInvalideData() throws IOException {
		
		 
	//	initilizeDriver();	 
	//	driver.get("https://naveenautomationlabs.com/opencart/");
		
		 
	     HomePageObjects hpo=new HomePageObjects(driver);
	     
		 
	 	// Thread.sleep(4000);  ---
	                        
	 	   //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
	       // wait.until(ExpectedConditions.visibilityOf(hpo.clickOnMyAccount1()));
	     
	     commonMethods.handleExplictWait(driver, 4, hpo.clickOnMyAccount1());  
	                               
	                               
	     
	     hpo.clickOnMyAccount1().click();
	     hpo.clickOnRegister().click();
		
		ResgisterPageObjects hpos = new ResgisterPageObjects(driver);
		
		hpos.sendKeysOnFirstName().sendKeys(testData.firstname);
		hpos.sendKeysOnLastName().sendKeys("TurKar");
		hpos.sendKeysOnEMail().sendKeys(testData.email);
		hpos.sendKeysOnTelephone().sendKeys(testData.telephome);
		hpos.sendKeysOnPassword().sendKeys(testData.password);
		hpos.sendKeysOnPasswordConfirm().sendKeys(testData.Confirmpassword);
		hpos.clickOnAgree().click();
		hpos.clickOnContinue().click();
	}

@Test(priority=2)
public void verifyRegistrrationWithBlankData() throws IOException, InterruptedException {
	
	 
	//initilizeDriver();
	//driver.get("https://naveenautomationlabs.com/opencart/");
	
	 
	 HomePageObjects hpo=new HomePageObjects(driver);
	 
	 
	// Thread.sleep(4000);
	 
	  // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
     //  wait.until(ExpectedConditions.visibilityOf(hpo.clickOnMyAccount1()));	 	
	 
	 commonMethods.handleExplictWait(driver, 3, hpo.clickOnMyAccount1());
       
	 
	 hpo.clickOnMyAccount1().click();
	 hpo.clickOnRegister().click();
	
	 
	 
	ResgisterPageObjects hpos = new ResgisterPageObjects(driver);
	
	hpos.clickOnContinue().click();
	
	
	
	SoftAssert sa=new SoftAssert(); 
	 
	 
		String fnExpected= testData.FirstNameErrorExpected; 
		String fnActual=hpos.FirstNameError().getText(); 
		 
		String lsExpected=testData.LastNameErrorExpected; 
		String lsActual=hpos.LastNameError().getText(); 
		
		String emailExpected=testData.EmailErrorExpected; 
		String emailActual=hpos.EMailError().getText(); 
		 
		String teliExpected=testData.TeliErrorExpected; 
		String teliActual=hpos.TelephoneError().getText(); 
		
		String passExpected=testData.PasswordErrorExpected; 
		String passActual=hpos.PasswordError().getText(); 
		
		
		 
		sa.assertEquals(fnActual,fnExpected); 
		sa.assertEquals(lsActual,lsExpected); 
		sa.assertEquals(emailActual, emailExpected);
		sa.assertEquals(teliActual, teliExpected); 
		sa.assertEquals(passActual, passExpected); 
		
		
		sa.assertAll(); 
	
	
	
	
}
}
