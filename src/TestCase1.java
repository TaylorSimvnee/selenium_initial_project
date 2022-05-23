import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase1 {
    public static void main(String[] args) {
     /*
                2. CssSelector
                -this is the second fastest after id
                tagName[att='value']

                3. Xpath
                -It is the most flexible one
                //tagName[@att='value']
         */

        /*
        Validate ComfyElite Contact Us Page heading section
        Given user navigates to “https://comfyelite.com/”
        When user clicks on “CONTACT US” link in the header
        Then user should be navigated to “CONTACT US” page
        And user should be able to see ComfyElite logo
        And user should be able to see heading2 as “High quality comfy pillows and accessories for travel, office and home.”
         */


        //Set up
            WebDriver driver = Driver.getDriver();
            driver.get("https://comfyelite.com/");

        //Validation
        WebElement contactUsLink = driver.findElement(By.xpath("(//li[@data-ux='ListItemInline'])[3]"));
        contactUsLink.click();
        String contactUsPageTitle = driver.getCurrentUrl();
        WebElement comfyEliteLogo = driver.findElement(By.id("n-48560"));
        WebElement heading2 = driver.findElement(By.id("dynamic-tagline-48605"));


        System.out.println(contactUsPageTitle.equals("https://comfyelite.com/contact-us") ? "Contact us Link validation PASSED" : "Contact us Link validation FAILED");
        System.out.println(comfyEliteLogo.isDisplayed() ? "Logo validation PASSED" : "Logo validation FAILED");
        System.out.println(heading2.isDisplayed() ? "Heading2 DISPLAY validation PASSED" : "Heading2 DISPLAY validation FAILED");
        System.out.println(heading2.getText().equals("High quality comfy pillows and accessories for travel, office and home.") ? "Heading2 validation PASSED" : "Heading2 validation FAILED");

            //TearDown
            Driver.quitDriver();

        }
    }