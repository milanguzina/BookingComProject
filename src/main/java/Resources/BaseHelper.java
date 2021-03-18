package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseHelper
{
	public WebDriver driverNULL; 
//	protected  WebDriver driver = new ChromeDriver();
	protected  WebDriverWait wdWait = new WebDriverWait(driver, 15);
	protected  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
	                                                                         .pollingEvery(Duration.ofSeconds(5))
	                                                                         .ignoring(Exception.class);
	protected  JavascriptExecutor js = (JavascriptExecutor) driver;
	public  Properties prop;
	
	public Properties getProperties() throws IOException {
		    prop = new Properties();
	    	FileInputStream fis = new FileInputStream("C:\\Users\\MicaiCora\\eclipse-AutomationProjects\\BookingComFunctionality\\src\\main\\java\\Resources\\data.properties");
	    	prop.load(fis);
	    	return prop;
	}
	
	
    public  WebDriver initializeDriver() throws IOException {
       
    	String browserName = prop.getProperty("browser");
    	
		if (browserName.equals("chrome")) 
    	{
    		System.setProperty("webdriver.chrome.driver","C:\\Users\\MicaiCora\\eclipse-AutomationProjects\\BookingComFunctionality\\chromedriver.exe");
    		driver = new ChromeDriver();
    	}
    	else if (browserName.equals("firefox")) 
    	{
    		System.setProperty("webdriver.gecko.driver","C:\\Users\\MicaiCora\\eclipse-AutomationProjects\\BookingComFunctionality\\geckodriver.exe");
		    driver = new FirefoxDriver();
     	}
    	else if (browserName.equals("IE")) 
    	{
    		System.setProperty("webdriver.ie.driver","C:\\Users\\MicaiCora\\eclipse-AutomationProjects\\BookingComFunctionality\\IEDriverServer.exe");
		    driver = new InternetExplorerDriver();
	}
//    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	return driver; 
}  
 

     public  void clickOnDropdown(WebElement viewElement,WebElement element, int index)
     {
        js.executeScript("arguments[0].scrollIntoView();", viewElement);   //scrolls into view of a chosen element
        Select dropdown = new Select(element);                                  //selects a chosen dropdown option by index
        dropdown.selectByIndex(index);
    }

    public  WebElement returnElementAttValue(String attributeName, String attributeValue)
    {
        String selector = "["+ attributeName + "=" + attributeValue +"]";
        WebElement element = driver.findElement(By.cssSelector(selector));
        return  element;
    }


}
