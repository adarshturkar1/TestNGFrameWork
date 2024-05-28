package resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class commonMethods {

	public static void handleAssertion(String actual, String expected ) {
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actual,expected,"Your textis not matching");
		                                   //optional, this msg will show only when this gets failed .
		sa.assertAll();
		
		
	}
	
	public static void handleExplictWait(WebDriver driver , int time , WebElement element ) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(element));
        //hpo.clickOnMyAccount1() - replaced with element
        
	}
	
}
