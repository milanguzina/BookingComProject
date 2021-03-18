package BookingComProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Resources.BaseHelper;



public class BaseTest extends BaseHelper
{
public WebDriver driver;	

	@BeforeTest
    public void testInit() throws IOException {
	   initializeDriver();
	   getProperties();
       driver.get(prop.getProperty("url"));
       driver.manage().window().maximize();
      }

   
    @AfterTest
    public void testTearDown() throws InterruptedException {
        driver.close();
        driver.quit();
    }

}