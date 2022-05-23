package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

    public class Driver {

        private Driver(){

        }

        private static WebDriver driver;

        public static WebDriver getDriver() {
            if (driver == null) {
                System.setProperty("webdriver.chrome.driver", "/Users/taylorsimone/IdeaProjects/selenium_intro/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
            return driver;

        }

        public static void quitDriver(){
            if (driver != null){
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;
            }
        }
    }


