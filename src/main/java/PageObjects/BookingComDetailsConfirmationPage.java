package PageObjects;

import Helpers.BookingComStringHelper;
import Resources.BaseHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingComDetailsConfirmationPage extends BaseHelper {

    @FindBy (id="bp_travel_purpose_leasure")
    WebElement leisureButton;
    @FindBy (id = "quiet_room_chosen")
    WebElement quietRoom;
    @FindBy (id = "checkin_eta_hour")
    WebElement checkInTime;
    @FindBy (id = "guest_name_6141029_265874267_3_1_0")
    WebElement secondGuestTextBox;
    @FindBy (id = "same_area_rooms")
    WebElement closeRooms;
    @FindBy (id = "remarks")
    WebElement specialRequestsTextBox;
    @FindBy (className = "e2e-bp-submit-button--next-step")
    WebElement finalDetailsButton;

    public WebDriver driver;

    public BookingComDetailsConfirmationPage(WebDriver driver) {
    	
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void clickOnLeisure(){
        js.executeScript("arguments[0].scrollIntoView()",leisureButton);
        wdWait.until(ExpectedConditions.visibilityOf(leisureButton));               //scrolls into view, clicks and prints out its selection
        leisureButton.click();
        System.out.println("Leisure trip is selected: " +leisureButton.isSelected());
    }

    private void enterSecondRoomGuestName(){
        js.executeScript("arguments[0].scrollIntoView()",secondGuestTextBox);  //sends chosen string in to a text box
        secondGuestTextBox.click();
        secondGuestTextBox.sendKeys("Claudia Schiffer");
    }

    private void enterSpecialRequests(){
        js.executeScript("arguments[0].scrollIntoView()",specialRequestsTextBox);  //sends chosen string in to a text box
        specialRequestsTextBox.click();
        specialRequestsTextBox.sendKeys("I have no special requests.");
    }

    private void clickOnCloseRooms(){
        closeRooms.click();
        System.out.println("Close rooms are selected: " +closeRooms.isSelected());  //clicks and prints out its selection
    }

    private void clickOnQuietRoom(){
      js.executeScript("arguments[0].scrollIntoView()",quietRoom);
      quietRoom.click();                                                         //clicks,scrolls into view and prints out its selection.
      System.out.println("Quiet rooms are selected: "+quietRoom.isSelected());
    }

    private void chooseTimeOfArrival(){
        clickOnDropdown(checkInTime,checkInTime,18);                       //clicks on the 18th dropdown option and prints out text from it
        BookingComStringHelper.getDropdownText("Check in time: ",checkInTime);
        }

    private void clickToPayOutPage(){ finalDetailsButton.click(); } //clicks  on the chosen element(button)

    public void enterFinalReservationDetails() throws InterruptedException {
        clickOnLeisure();
        enterSecondRoomGuestName();
        enterSpecialRequests();
        clickOnCloseRooms();
        clickOnQuietRoom();
        chooseTimeOfArrival();
        clickToPayOutPage();

        Thread.sleep(5000);

    }

}
