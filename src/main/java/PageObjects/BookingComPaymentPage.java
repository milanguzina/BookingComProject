package PageObjects;

import Helpers.BookingComStringHelper;
import Resources.BaseHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class BookingComPaymentPage extends BaseHelper {

    @FindBy (className = "bp_pricedetails_total_value")
    WebElement roomPriceFinal;
    @FindBy(className = "bui-f-font-display_two")
    public
    WebElement hotelName;
    @FindBy(xpath = "//*[@id=\"bookForm\"]/div/div/div/div[1]/div[2]/div/div[1]/div[1]/time/span[1]")
    public
    WebElement checkInDateFinal;
    @FindBy(xpath = "//*[@id=\"bookForm\"]/div/div/div/div[1]/div[2]/div/div[1]/div[2]/time/span[1]")
    public
    WebElement checkOutDateFinal;
    @FindBy (id = "phone")
    WebElement phoneBox;
    @FindBy (xpath = "//span[contains(text(),'Pay now')]")
    WebElement choosePaymentTypeButton;
    @FindBy (id = "cc_type")
    WebElement cardType;
    @FindBy (xpath = "//*[@id=\"cc-number\"]")
    WebElement cardNumberBox;
//    @FindBy(xpath = "//*[@id=\"book_credit_card\"]/div[3]/span")
//    WebElement cardNumberBox;
    @FindBy (id = "expiry-date")
    WebElement expiryDateBox;
    @FindBy (className = "newsletter_subscription_checkbox")
    WebElement newsletterCheckBox;
    public
    @FindBy (xpath = "//span[contains(text(),'Complete booking')]")
    WebElement completeBookingButton;

    int priceFinalInt;

    WebDriver driver;

    public BookingComPaymentPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private void enterPhoneNumber(String phoneNumber){    //sends given string to the text box
        phoneBox.click();
        phoneBox.sendKeys(phoneNumber);
    }
    
    private void choosePaymentType(String payment) {
          choosePaymentTypeButton.click();
          driver.switchTo().frame(0);
    }
    
//    private void chooseCardType(){
//        Select dropdown = new Select(cardType);   //selects a first option from the dropdown
//        dropdown.selectByIndex(1);
//        wdWait.until(ExpectedConditions.textToBePresentInElementValue(cardType,"MasterCard"));
//    }

    private void enterCardNumber(String cN1, String cN2, String cN3, String cN4,String cN5,String cN6,String cN7,String cN8,String cN9,String cN10,String cN11,String cN12,String cN13,String cN14,String cN15,String cN16){
    	
    	js.executeScript("arguments[0].scrollIntoView();", cardNumberBox);       
    	cardNumberBox.click();
        cardNumberBox.sendKeys(cN1);
        wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox, cN1));
        cardNumberBox.sendKeys(cN2);
        wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN2));
        cardNumberBox.sendKeys(cN3);
        wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN3));
        cardNumberBox.sendKeys(cN4);
        wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN4));
        cardNumberBox.sendKeys(cN5);
        //wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN5));  // sends 16 different strings to
        cardNumberBox.sendKeys(cN6);                                                 // text box.(Credit Card Numbers)
        //wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN6));
        cardNumberBox.sendKeys(cN7);
        //wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN7));
        cardNumberBox.sendKeys(cN8);
        //wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN8));
        cardNumberBox.sendKeys(cN9);
        //wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN9));
        cardNumberBox.sendKeys(cN10);
        //wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN10));
        cardNumberBox.sendKeys(cN11);
        //wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN11));
        cardNumberBox.sendKeys(cN12);
        //wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN12));
        cardNumberBox.sendKeys(cN13);
        //wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN13));
        cardNumberBox.sendKeys(cN14);
        //wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN14));
        cardNumberBox.sendKeys(cN15);
        //wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN15));
        cardNumberBox.sendKeys(cN16);
       // wdWait.until(ExpectedConditions.textToBePresentInElement(cardNumberBox,cN16));
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("payin-form__field-validation")));
        driver.switchTo().defaultContent();
    }

    private void enterCardExpiryDate(String expiryDate){
       expiryDateBox.click();
       expiryDateBox.sendKeys(expiryDate);
       
    }

    private void uncheckGetAccessToMemberDealsOnly(){
        newsletterCheckBox.click();
        System.out.println("Receiving newsletter: " +newsletterCheckBox.isSelected());  //clicks on the chosen checkbox and prints out its selection
    }

    public int getFinalPrice() {
        BookingComStringHelper.getPriceInt(roomPriceFinal,3);    //gets integer from chosen string in chosen element
        System.out.println("Final price for payout: " + roomPriceFinal.getText().replace("*","")); //prints out text from a chosen element
        return priceFinalInt;
    }

    public void finishAccommodationPayment(String phoneNumber,String payment,String cN1, String cN2, String cN3, String cN4,String cN5,String cN6,String cN7,String cN8,String cN9,String cN10,String cN11,String cN12,String cN13,String cN14,String cN15,String cN16,String expiryDate){
        enterPhoneNumber(phoneNumber);
        choosePaymentType(payment);
     //   chooseCardType();
        enterCardNumber(cN1,cN2,cN3,cN4,cN5,cN6,cN7,cN8,cN9,cN10,cN11,cN12,cN13,cN14,cN15,cN16);
        enterCardExpiryDate(expiryDate);
        uncheckGetAccessToMemberDealsOnly();
    }

}
