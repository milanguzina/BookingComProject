package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import Resources.BaseHelper;

import java.util.List;

public class BookingComHomePage extends BaseHelper {


    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    WebElement signInButtonHome;
    @FindBy(id = "ss")
    WebElement destinationSearchBox;
    @FindBy(className = "xp__guests__count")
    WebElement guestsDropdown;
    @FindBy(className = "xp__button")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[4]/label")
    WebElement mapCheckBox;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/div[2]")
    WebElement checkIn;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[3]/div/div/div/div/div[2]")
    WebElement checkOut;
    @FindBy(xpath = "//*[@id=\"xp__guests__toggle\"]/span[2]/span[1]")
    WebElement numberOfAdults;
    @FindBy(xpath = "//*[@id=\"xp__guests__toggle\"]/span[2]/span[2]/span")
    WebElement numberOfChildren;

    WebDriver driver;

    String townText;
    String numberOfAdultsHomeText;
    String numberOfChildrenHomeText;


    public BookingComHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void getAddress(String webAddress)
    {
        driver.get(webAddress);
    }  //gets a  web address

    public void clickOnSignInButtonHome() {signInButtonHome.click();    }

    private void enterDestination(String town){                 //enters string(town destination) in the search box
        destinationSearchBox.click();
        destinationSearchBox.clear();
        destinationSearchBox.sendKeys(town);
        WebElement destinationChoice = driver.findElement(By.className("search_hl_name"));
        wait.until(ExpectedConditions.stalenessOf(destinationChoice));
    }

    private void destinationClick() {
        List<WebElement> townList = driver.findElements(By.className("search_hl_name"));
        for (WebElement chosenTown : townList) {
            if (chosenTown.getText().contains("Berlin City Centre")) {                  //creates element list and chooses an element form list that contains given string
                townText = chosenTown.getText();
                System.out.println("Chosen destination: " +townText);                      //also clicks on the chosen element
                //chosenTown.click();
                js.executeScript("arguments[0].click()",chosenTown);
                wdWait.until(ExpectedConditions.invisibilityOfAllElements(chosenTown));
           }
        }
    }
        

    private void chooseCheckInDate() {
        WebElement checkInDate = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[2]/td[1]/span"));
        checkInDate.click();
        System.out.println("Check in: " + checkIn.getText().trim());     //finds and clicks on the certain element in dropdown calendar. Also prints out text from the chosen element
    }

    private void chooseCheckOutDate(){
        WebElement checkOutDate = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[2]/td[4]/span"));
        checkOutDate.click();
        System.out.println("Check out: " +checkOut.getText().trim());      //finds and clicks on the certain element in dropdown calendar. Also prints out text from the chosen element
    }

    private void chooseNumberOfAdultGuests() {
        guestsDropdown.click();             //clicks to open dropdown menu
        WebElement adultsAddButton = driver.findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[1]/div/div[2]/button[2]"));
        for (int i = 0; i < 2; i++) {           //clicks twice on chosen element from dropdown
            adultsAddButton.click();
        }
        numberOfAdultsHomeText = numberOfAdults.getText();          //prints out text from chosen element
        System.out.println("Adults: " + numberOfAdultsHomeText);
    }

    private void chooseNumberOfChildGuests() {
        WebElement childrenAddButton = driver.findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[2]/div/div[2]/button[2]"));
        childrenAddButton.click();
        numberOfChildrenHomeText = numberOfChildren.getText();     //clicks on chosen element and prints out text from it.
        System.out.println("Children: "+numberOfChildren.getText());
    }

    private void selectChildAge() {
        wdWait.until(ExpectedConditions.elementToBeClickable(By.name("age")));
        WebElement childAge = driver.findElement(By.name("age"));
        childAge.click();                                           //clicks on the chosen element to open dropdown menu
        Select dropdown = new Select(childAge);
        dropdown.selectByIndex(9);                                  //select the ninth option from the dropdown menu
        String dropdownText = dropdown.getFirstSelectedOption().getText().trim();  //trims and prints out the text from the ninth option
        System.out.println("Child age: " +dropdownText);
    }

    private void uncheckMapOption() {mapCheckBox.click();}  // clicks on checkbox

    private void confirmSearch(){ searchButton.click();}  //clicks on button

    public void accommodationSearch(String town){// throws InterruptedException {
        enterDestination(town);
        destinationClick();
        chooseCheckInDate();
        chooseCheckOutDate();
        chooseNumberOfAdultGuests();
        chooseNumberOfChildGuests();
        selectChildAge();
        uncheckMapOption();
        confirmSearch();
       // Thread.sleep(5000);
        //Sluzi za konfirmaciju
    }



}
