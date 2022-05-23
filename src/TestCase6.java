import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase6 {
    public static void main(String[] args) {

        /*
        Validate ComfyElite Contact Us page "SEND" button
        Given user navigates to “https://comfyelite.com/”
        When user clicks on “CONTACT US” link in the header
        Then user should be navigated to “CONTACT US” page
        And validate "SEND" button is displayed and clickable
        And validate button text is displayed as “SEND”
         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://comfyelite.com/");

        WebElement contactUsLink = driver.findElement(By.xpath("(//li[@data-ux='ListItemInline'])[3]"));
        contactUsLink.click();
        String contactUsPageTitle = driver.getCurrentUrl();
        WebElement sendButton = driver.findElement(By.cssSelector("button[data-aid='CONTACT_SUBMIT_BUTTON_REND']"));


        System.out.println(contactUsPageTitle.equals("https://comfyelite.com/contact-us") ? "Contact us Link validation PASSED" : "Contact us Link validation FAILED");
        System.out.println(sendButton.isDisplayed() ? "PASSED" : "FAILED");
        System.out.println(sendButton.isEnabled() ? "PASSED" : "FAILED");
        System.out.println(sendButton.getText().equals("SEND") ? "PASSED" : "FAILED");

        Driver.getDriver();
    }
}
