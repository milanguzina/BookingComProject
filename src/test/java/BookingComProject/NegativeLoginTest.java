package BookingComProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.BookingComSignInPage;




public class NegativeLoginTest extends BaseTest{

	BookingComSignInPage bcsip = new BookingComSignInPage(driver);
	
	  @Test (dataProvider = "getData")

	    public void bookingComNegativeLoginTest(String username, CharSequence[] password) throws InterruptedException, IOException {
		    bcsip.userLogin(username,password);
	        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-description")));
	        WebElement errorMessage = driver.findElement(By.id("password-description"));
	        Assert.assertTrue( errorMessage.getText().contains("The email and password combination entered doesn't match."),"Error message is not displayed.");
	        Assert.assertTrue( bcsip.signInButton.isDisplayed(),"'Sign in' button is not displayed");
	    }
	  
	  @DataProvider
	    
	    public Object[][] getData(){
	    Object[][] data = new Object[1][2];
	    
	    data[0][0] = "guzina.zavrsni@gmail.com";
	    data[0][1] = "wrongpassword";
	   
	    
	    return data;
	  }
}
