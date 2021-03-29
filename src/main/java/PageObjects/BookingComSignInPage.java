package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Resources.BaseHelper;

public class BookingComSignInPage extends BaseHelper
{
    @FindBy(id = "username")
    WebElement usernameBox;
    @FindBy (xpath = "//span[contains(text(),'Continue with email')]")
    WebElement nextButton;
    @FindBy (xpath = "//span[contains(text(),'Sign in')]")
    public
    WebElement signInButton;
    @FindBy (id ="password")
    WebElement passwordBox;

    WebDriver driver;

    public BookingComSignInPage(WebDriver driver)
    {
    	this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private void clickOnNext(){ nextButton.click(); }               //clicks on chosen element(button)


    private void enterUsername(String username) {                   //enters given string in the text box
    wdWait.until(ExpectedConditions.visibilityOf(usernameBox));
    usernameBox.click();
    usernameBox.sendKeys(username);
    }

    private void enterPassword(CharSequence[] password)  {                     //enters given string in the text box
        wdWait.until(ExpectedConditions.visibilityOf(passwordBox));
        passwordBox.click();
        passwordBox.sendKeys(password);
    }

    private void clickOnSignIn() { signInButton.click();  }            //clicks on chosen element(button)

    public void userLogin(String username, CharSequence[] password ) throws InterruptedException {
        BookingComHomePage bchp = new BookingComHomePage(driver);
        bchp.clickOnSignInButtonHome();
        enterUsername(username);
        clickOnNext();
        enterPassword(password);
        clickOnSignIn();
        Thread.sleep(5000);     //just for confirmation

    }

}
