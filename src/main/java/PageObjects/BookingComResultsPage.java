package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Resources.BaseHelper;

import java.util.List;

public class BookingComResultsPage extends BaseHelper {

    public
    @FindBy(xpath = "//*[@id=\"ss\"]")
    WebElement searchInfoBox;
    public
    @FindBy(xpath = "//*[@id=\"frm\"]/div[3]/div/div[1]/div[1]/div/div/div/div[2]")
    WebElement searchInfoBoxCheckIn;
    public
    @FindBy(xpath = "//*[@id=\"frm\"]/div[3]/div/div[1]/div[2]/div/div/div/div[2]")
    WebElement searchInfoBoxCheckOut;
    @FindBy(id = "filter_facilities")
    WebElement facilities;
    @FindBy(id = "filter_mealplan")
    WebElement meals;
    @FindBy(xpath = "//*[@id=\"filter_facilities\"]/div[2]/a[1]/label/div")
    WebElement parkingCheckBox;
    @FindBy(xpath = "//*[@id=\"filter_facilities\"]/div[2]/a[11]/label/div")
    WebElement wiFiCheckBox;
    @FindBy(xpath = "//*[@id=\"filter_facilities\"]/div[2]/a[13]/label/div")
    WebElement swimmingPoolCheckBox;
    @FindBy(xpath = "//*[@id=\"filter_mealplan\"]/div[2]/a[2]/label/div")
    WebElement breakfastCheckBox;

    @FindBy(className = "bicon-parking")
    WebElement parkingBadge;
    @FindBy(className = "bicon-wifi")
    WebElement wiFiBadge;
    @FindBy(className = "bicon-pool")
    WebElement swimmingpoolBadge;
    @FindBy(xpath = "//span[contains(text(),'Breakfast included')]")
    WebElement breakfastFlag;

    WebDriver driver;

    public BookingComResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void clickOnFilterCheckBox(WebElement group, WebElement checkBox, WebElement badge) {
    	 wdWait.until(ExpectedConditions.visibilityOf(checkBox)); 
    	 js.executeScript("arguments[0].scrollIntoView();", group);                                  // finds, scrolls into and clicks on chosen checkbox
         checkBox.click();
         wdWait.until(ExpectedConditions.visibilityOf(badge));
    }
   

    public void clickOnChooseYourRoom() {
        wdWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("sr_item_new")));                              //waits for certain elements to be presented
       // WebElement highlighted = driver.findElement(By.className("sr_item--highlighted"));
    	List<WebElement> newAccommodationList = driver.findElements(By.className("sr_item_new"));                                   //creates a list of elements
        for (WebElement newTopAccomm : newAccommodationList) {
            if (newTopAccomm.getText().contains("Pullman Berlin Schweizerhof"))
            {                                                           //finds a certain search result from list that contains given string
                js.executeScript("arguments[0].scrollIntoView();", newTopAccomm);                                                 //scrolls the result into view
                System.out.println("Chosen accommodation: " + newTopAccomm.findElement(By.className("sr-hotel__name")).getText());   //prints out text from a chosen element in the search result
                newTopAccomm.findElement(By.className("bui-button__text")).click();                             //clicks on chosen element (button)
                break;
            }
        }
    }

    public void filterSearch() throws InterruptedException {

        clickOnFilterCheckBox(facilities, parkingCheckBox, parkingBadge);

        clickOnFilterCheckBox(facilities, wiFiCheckBox, wiFiBadge);

        clickOnFilterCheckBox(facilities, swimmingPoolCheckBox, swimmingpoolBadge);

        clickOnFilterCheckBox(meals, breakfastCheckBox, breakfastFlag);

        Thread.sleep(4000);
    }

}







