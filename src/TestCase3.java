import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase3 {
    public static void main(String[] args) {
        /*
         Validate ComfyElite Contact Us page "Contact Us" "SEND US A MESSAGE" form headings
        Given user navigates to “https://comfyelite.com/”
        When user clicks on “CONTACT US” link in the header
        Then user should be navigated to “CONTACT US” page
        And user should be able to see heading2 as "Contact Us"
        And user should be able to see heading4 as "SEND US A MESSAGE"

         */


        WebDriver driver = Driver.getDriver();
        driver.get("https://comfyelite.com/");

        WebElement contactUsLink = driver.findElement(By.xpath("(//li[@data-ux='ListItemInline'])[3]"));
        contactUsLink.click();
        String contactUsPageTitle = driver.getCurrentUrl();
        WebElement heading2 = driver.findElement(By.xpath("//h2[@role='heading']/*"));
        WebElement heading4 = driver.findElement(By.cssSelector("h4[data-ux='HeadingMinor']"));

        System.out.println(contactUsPageTitle.equals("https://comfyelite.com/contact-us") ? "Contact us Link validation PASSED" : "Contact us Link validation FAILED");
        System.out.println(heading2.isDisplayed() ? "Heading2  Display validation PASSED" : "Heading2 Display validation FAILED");
        System.out.println(heading2.getText().equals("Contact Us") ? "Heading2  equals validation PASSED" : "Heading2 equals validation FAILED");
        System.out.println(heading4.isDisplayed() ? "Heading4 Display validation PASSED" : "Heading4 Display validation FAILED");
        System.out.println(heading4.getText().equals("SEND US A MESSAGE") ? "Heading4  equals validation PASSED" : "Heading4 equals validation FAILED");

        Driver.quitDriver();
    }
}
