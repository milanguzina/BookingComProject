package BookingComProject;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.BookingComAccommodationPage;
import PageObjects.BookingComDetailsConfirmationPage;
import PageObjects.BookingComHomePage;
import PageObjects.BookingComPaymentPage;
import PageObjects.BookingComResultsPage;
import PageObjects.BookingComSignInPage;


public class FinalReservationFunctionalityTest extends BaseTest{


	 BookingComSignInPage bcsip = new BookingComSignInPage(driver);
	    BookingComHomePage bchp = new BookingComHomePage(driver);
	    BookingComResultsPage bcrp = new BookingComResultsPage(driver);
	    BookingComAccommodationPage bcap = new BookingComAccommodationPage(driver);
	    BookingComDetailsConfirmationPage bdcp = new BookingComDetailsConfirmationPage(driver);
	    BookingComPaymentPage bcpp = new BookingComPaymentPage(driver);
	    
	  @Test (dataProvider = "getData")

	    public void reservationOfChosenAccommodationTest(String username, CharSequence[] password) throws InterruptedException {
	       driver.get("http:\\www.booking.com");
		   bcsip.userLogin(username,password);
	       bchp.accommodationSearch("Berlin");
	       bcrp.filterSearch();
	       bcrp.clickOnChooseYourRoom();
	       bcap.chooseAccommodationType();
	       bdcp.enterFinalReservationDetails();
	       bcpp.finishAccommodationPayment("658256738","Pay now","5","3", "5","2","8","3","1","0","0","0","2","6","1","1","9","9","1221");
	       Assert.assertTrue(bcpp.hotelName.getText().contains("Maritim Hotel Berlin"),"Reservation of chosen accommodation is not valid");
	       Assert.assertTrue(bcpp.checkInDateFinal.getText().contains("Thu, Dec 24, 2020"),"Check in date is not valid.");
	       Assert.assertTrue(bcpp.checkOutDateFinal.getText().contains("Mon, Dec 28, 2020"),"Check out date is not valid.");
	       Assert.assertEquals( bcap.priceTotalInt,bcpp.getFinalPrice(),"Total reservation price does not match.");
	       Assert.assertTrue(bcpp.completeBookingButton.isDisplayed(),"'Complete booking' button is not presented.");
	       Thread.sleep(5000);
	   }
	  
	  @DataProvider
	    
	    public Object[][] getData(){
	    Object[][] data = new Object[1][2];
	    
	    data[0][0] = "guzina.zavrsni@gmail.com";
	    data[0][1] = "guzinazavrsni123";
	   
	    return data;
	    } 
}
