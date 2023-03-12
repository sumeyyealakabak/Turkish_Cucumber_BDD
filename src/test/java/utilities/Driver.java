package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    public static WebDriver driver;


    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();

        if (driver==null){
            driver=new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;

    }


    public static void closeDriver(){
        if (driver!=null) {
            driver.close();
            driver=null;
        }
    }

    public static void quitDriver(){
        if (driver!=null) {
            driver.quit();
            driver=null;
        }
    }


    /*
       For more control and access to the driver without using extends.
       We will create the webDriver object with a static method in the Driver class.
       However, getDriver() creates a new driver each time it is used.
       To prevent this and make our code work properly
       on first use driver= new ChromeDriver(); let the code work.
       We need to develop a method so that it doesn't work in later uses.
       We can handle this using if
     */

}
