package PageObjects;


import Helpers.BookingComStringHelper;
import Resources.BaseHelper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class BookingComAccommodationPage extends BaseHelper
{

    @FindBy (className = "hprt-table-cell-roomtype--active")
    WebElement cell;
    @FindBy(id = "hprt_nos_select_6141029_265874267_3_1_0")
    WebElement classicDoubleRoom;
    @FindBy(id = "hprt_nos_select_6141029_265874267_2_1_0")
    WebElement classicDoubleRoomPlusChild;
    @FindBy (className = "txp-bui-main-pp")
    WebElement illReserveButton;
    @FindBy(className = "rt-bed-type-select")
    WebElement oneBedOptionClassicDoubleRoom;
    @FindBy (className = "hprt-reservation-total-price")
    WebElement priceTotal;

   public int priceTotalInt;

    WebDriver driver;

    public BookingComAccommodationPage(WebDriver driver) {
    	
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void chooseNumberOfRoomsClassicDoubleRoom() {
        clickOnDropdown(classicDoubleRoom,classicDoubleRoom,1);
    }        //clicks on dropdown and on one of the given options from dropdown

    private void chooseNumberOfRoomsClassicDoubleRoomPlusChild() {
        clickOnDropdown(classicDoubleRoomPlusChild,classicDoubleRoomPlusChild,1);
    }   //clicks on dropdown and on one of the given options from dropdown

    private void chooseBedClassicDouble(){
        wdWait.until(ExpectedConditions.elementToBeClickable(oneBedOptionClassicDoubleRoom));          //clicks on chosen element (radio button)
        js.executeScript("arguments[0].click()",oneBedOptionClassicDoubleRoom);   }

    private void toReservationDetailsPage(){js.executeScript("arguments[0].click()",illReserveButton);   } //clicks on chosen element(button)

    public int getTotalPrice() {
       	BookingComStringHelper.getPriceInt(priceTotal,3);                   //gets integer from chosen string in chosen element
        System.out.println("Total accommodation price: " + priceTotal.getText()); //prints out text from a chosen element
        return priceTotalInt;
    }


    public void chooseAccommodationType() throws InterruptedException
    {
        for (String winHandle : driver.getWindowHandles()) {        //Gets the new window handle
            driver.switchTo().window(winHandle);                     // switch focus of WebDriver to the next found window handle
        }
        chooseNumberOfRoomsClassicDoubleRoom();
        chooseNumberOfRoomsClassicDoubleRoomPlusChild();
        chooseBedClassicDouble();
        getTotalPrice();
        toReservationDetailsPage();
        Thread.sleep(3000);         //only for confirmation
    }

}
