package Resources;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseHelper 
{
	
    protected  static WebDriver driver = new ChromeDriver();
	protected  static WebDriverWait wdWait = new WebDriverWait(driver, 15);
	protected  static Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
	                                                                         .pollingEvery(Duration.ofSeconds(5))
	                                                                         .ignoring(Exception.class);
	protected  static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public static void getUrl()  {driver.get("https:\\www.booking.com");
	}
	
     public  void clickOnDropdown(WebElement viewElement,WebElement element, int index)
     {
        js.executeScript("arguments[0].scrollIntoView();", viewElement);   //scrolls into view of a chosen element
        Select dropdown = new Select(element);                                  //selects a chosen dropdown option by index
        dropdown.selectByIndex(index);
    }

    public static WebElement returnElementAttValue(String attributeName, String attributeValue)
    {
        String selector = "["+ attributeName + "=" + attributeValue +"]";
        WebElement element = driver.findElement(By.cssSelector(selector));
        return  element;
    }

}
