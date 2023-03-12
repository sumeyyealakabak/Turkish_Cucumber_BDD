package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QdPage {

    public QdPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id="login-email")
    public WebElement emailKutusu;

    @FindBy(id="login-password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement loginButonu;


    @FindBy(xpath = "//a[text()='Instructor']")
    public WebElement basariliGirisElementi;

    @FindBy(xpath = "//a[@onclick='cookieAccept();']")
    public WebElement cookie;


}
