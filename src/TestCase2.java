import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import javax.jws.soap.SOAPBinding;

public class TestCase2 {
    public static void main(String[] args) {

        /*
        Validate ComfyElite Contact Us page "Connect With Us" section
        Given user navigates to “https://comfyelite.com/”
        When user clicks on “CONTACT US” link in the header
        Then user should be navigated to “CONTACT US” page
        And user should be able to see heading1 as "Connect With Us"
        And user should be able to see “Facebook” icon and hyperlink reference for it should be “https://www.facebook.com/103179127717601”
        And user should be able to see “Instagram” icon and hyperlink reference for it should be “https://www.instagram.com/comfyelite”

         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://comfyelite.com/");


        WebElement contactUsLink = driver.findElement(By.xpath("(//li[@data-ux='ListItemInline'])[3]"));
        contactUsLink.click();
        String contactUsPageTitle = driver.getCurrentUrl();
        WebElement heading1 = driver.findElement(By.xpath("//h1[@role='heading']/span"));
        WebElement facebookIcon = driver.findElement(By.cssSelector("a[data-aid='SOCIAL_FACEBOOK_LINK']"));
        WebElement instagramIcon = driver.findElement(By.cssSelector("a[data-aid='SOCIAL_INSTAGRAM_LINK']"));

        System.out.println(contactUsPageTitle.equals("https://comfyelite.com/contact-us") ? "Contact us Link validation PASSED" : "Contact us Link validation FAILED");
        System.out.println(heading1.getText().equals("Connect With Us") ? "Heading1 validation PASSED" : "Heading1 validation FAILED");
        System.out.println(facebookIcon.isDisplayed() ?"Facebook DISPLAY validation PASSED" : "Facebook DISPLAY validation FAILED");
        System.out.println(facebookIcon.getAttribute("href").equals("https://www.facebook.com/103179127717601") ? "Facebook LINK validation PASSED" : "Facebook LINK validation FAILED");
        System.out.println(instagramIcon.isDisplayed() ?"Instagram DISPLAY validation PASSED" : "Instagram DISPLAY validation FAILED");
        System.out.println(instagramIcon.getAttribute("href").equals("https://www.instagram.com/comfyelite") ? "Instagram LINK validation PASSED" : "Instagram LINK validation FAILED");

        Driver.quitDriver();
    }
}
