import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase5 {
    public static void main(String[] args) {

        /*
        Validate ComfyElite Contact Us page "Sign up for our email list
        for updates, promotions, and more." Checkbox
        Given user navigates to “https://comfyelite.com/”
        When user clicks on “CONTACT US” link in the header
        Then user should be navigated to “CONTACT US” page
        And validate the "Sign up for our email list for updates, promotions, and more." checkbox
        Note: Checkbox validation includes checkbox being selected and deselected by user

         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://comfyelite.com/");


        WebElement contactUsLink = driver.findElement(By.xpath("(//li[@data-ux='ListItemInline'])[3]"));
        contactUsLink.click();
        String contactUsPageTitle = driver.getCurrentUrl();
        WebElement signUp = driver.findElement(By.xpath("(//div[@data-ux='Element'])[2]"));
        WebElement signUpInput = driver.findElement(By.cssSelector("input[data-aid='CONTACT_FORM_EMAIL_OPT_IN']"));
        signUp.click();


        System.out.println(contactUsPageTitle.equals("https://comfyelite.com/contact-us") ? "Contact us Link validation PASSED" : "Contact us Link validation FAILED");
        System.out.println(signUpInput.isSelected() ? "passed" : "failed");
        signUp.click();
        System.out.println(!signUpInput.isSelected() ? "passed" : "failed");

        Driver.quitDriver();
    }
}
