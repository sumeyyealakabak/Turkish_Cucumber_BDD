package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    /*
         Pages classes are used to avoid having to locate the locates we use all the time.
         Each pages class uses the driver created in the Driver class.
         In order for @FindBy notation to use WebDriver in Driver class, we need to introduce it to this class.
         For this, when each Pages page is first created
         a constructor with no parameters per.
         In it, we introduce the driver to this class.
      */
    public AmazonPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")
    public WebElement resultBoxElement;

    @FindBy(xpath = "(//img[@class='s-image'])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement firstProductNameElement;
}
