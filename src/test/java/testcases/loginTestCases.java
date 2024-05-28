package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.HomePageObjects;
import pageObjectModel.LoginPageObject;
import resources.baseClass;
import resources.commonMethods;
import resources.testData;

public class loginTestCases extends baseClass{

	@Test
	public void verifyLoginWithValidData() throws IOException {
		
	//	initilizeDriver();
		 
	//	driver.get("https://naveenautomationlabs.com/opencart/");
		
		 HomePageObjects hpo=new HomePageObjects(driver);
		 
		 
			// Thread.sleep(4000);
		 
			  // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		       //wait.until(ExpectedConditions.visibilityOf(hpo.clickOnMyAccount1()));
		 
		 commonMethods.handleExplictWait(driver, 3, hpo.clickOnMyAccount1());
		 
		 
		 hpo.clickOnMyAccount1().click();
		 hpo.clickOnlogin().click();
		
		 
		LoginPageObject lpo=new LoginPageObject(driver);
		lpo.sendKeysOnEMailAddress().sendKeys(testData.email);
		lpo.sendKeysOnPassword().sendKeys(testData.password);
		lpo.ClickOnLogin().click();
		
		

		String expected=testData.loginExpectedText; //requirement document 
 		String actual= lpo.getLoginSucesfull().getText(); //after running the scripts 
		
		/*SoftAssert sa=new SoftAssert();
		sa.assertEquals(actual,expected,"Your textis not matching");
		                                   //optional, this msg will show only when this gets failed .
		sa.assertAll();*/
 		
 		commonMethods.handleAssertion(actual, expected);
		
	}
	
	
	

	@Test
	public void verifyLoginWithInValidData() throws IOException {
		
	//	initilizeDriver();
		 
	//	driver.get("https://naveenautomationlabs.com/opencart/");
		
		 HomePageObjects hpo=new HomePageObjects(driver);
		 
		 
			// Thread.sleep(4000);
		 
			   //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		      // wait.until(ExpectedConditions.visibilityOf(hpo.clickOnMyAccount1()));
		 
		 commonMethods.handleExplictWait(driver, 3, hpo.clickOnMyAccount1());
		 
		 
		 hpo.clickOnMyAccount1().click();
		 hpo.clickOnlogin().click();
		
		 
		LoginPageObject lpo=new LoginPageObject(driver);
		lpo.sendKeysOnEMailAddress().sendKeys("");
		lpo.sendKeysOnPassword().sendKeys(testData.password);
		lpo.ClickOnLogin().click();
		
		

		String expected= testData.invalidLoginExpectedText; //requirement document 
 		String actual= lpo.getLoginFailedText().getText(); //after running the scripts  
  
  		 
 		/*SoftAssert sa=new SoftAssert(); 
 		sa.assertEquals(actual, expected,"please enter proper credinetails"); 
		                                   //optional, this msg will show only when this gets failed .
		sa.assertAll();*/
		
		commonMethods.handleAssertion(actual, expected);
		
	}
	
	
}
