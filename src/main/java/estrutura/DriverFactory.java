package estrutura;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory(){

    }
    public static WebDriver getDriver(){
            if (driver == null) {
                System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
        return driver;

        }
    }

