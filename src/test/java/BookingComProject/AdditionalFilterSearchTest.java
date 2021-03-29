package BookingComProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.BookingComHomePage;
import PageObjects.BookingComResultsPage;


public class AdditionalFilterSearchTest extends BaseTest{

	  BookingComHomePage bchp = new BookingComHomePage(driver);
	  BookingComResultsPage bcrp = new BookingComResultsPage(driver);
	
	 @Test

	    public void additionalFilterSearchTest() throws InterruptedException {
		   driver.get("http:\\www.booking.com");
		    bchp.accommodationSearch("Berlin");
	        bcrp.filterSearch();
	        List<WebElement> newAccommodationList = driver.findElements(By.className("sr_property_block"));
	        for (WebElement newAccomm : newAccommodationList) {
	                Assert.assertTrue(newAccomm.findElement(By.className("bicon-parking")).isDisplayed(),"Parking badge is not presented.");
	                Assert.assertTrue(newAccomm.findElement(By.className("bicon-wifi")).isDisplayed(),"Wifi badge is not presented.");
	                Assert.assertTrue(newAccomm.findElement(By.className("bicon-pool")).isDisplayed(),"Swimming pool badge is not presented.");   
	                Assert.assertTrue(bcrp.breakfastChecker.isSelected(),"'Breakfast included' flag is not displayed.");
	             }
	    }

}
