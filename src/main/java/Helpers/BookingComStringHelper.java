package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Resources.BaseHelper;

public class BookingComStringHelper extends BaseHelper {

	WebDriver driver;

    public BookingComStringHelper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void getDropdownText(String text, WebElement element) {
        Select dropdown = new Select(element);                                        //trims and prints out text from a chosen dropdown option
        String dropdownText = dropdown.getFirstSelectedOption().getText().trim();
        System.out.println(text + dropdownText);
    }

    public static int getPriceInt(WebElement element,int sub1) {
        String priceString = element.getText().substring(sub1).replace(",", "").replace("*","").trim();
        int priceInt = Integer.parseInt(priceString);
        return priceInt;                                //gets a string from the chosen element, substrings, trims and replace certain parts of string
    }                                                   //parses the string into integer
}
