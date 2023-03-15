package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class GooglePage {
    GooglePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
