import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase4 {
    public static void main(String[] args) {
        /*
        Validate ComfyElite Contact Us page "SEND US A MESSAGE" form
        Given user navigates to “https://comfyelite.com/”
        When user clicks on “CONTACT US” link in the header
        Then user should be navigated to “CONTACT US” page
        And validate "First Name" input box
        And validate "Last Name" input box
        And validate "Email" input box
        And validate "Message" input box
        NOTE: Input validation includes input being displayed and user being able send keys to input box. It also requires validating the given labels and placeholders

         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://comfyelite.com/");

        WebElement contactUsLink = driver.findElement(By.xpath("(//li[@data-ux='ListItemInline'])[3]"));
        contactUsLink.click();
        String contactUsPageTitle = driver.getCurrentUrl();
        WebElement firstNameInputBox = driver.findElement(By.cssSelector("div[data-aid='First Name']>input"));
        WebElement lastNameInputBox = driver.findElement(By.cssSelector("div[data-aid='Last Name']>input"));
        WebElement emailInputBox = driver.findElement(By.cssSelector("div[data-aid='CONTACT_FORM_EMAIL']>input"));
        WebElement messageInputBox = driver.findElement(By.cssSelector("textarea[data-aid='CONTACT_FORM_MESSAGE']"));
        WebElement firstNameText = driver.findElement(By.xpath("(//label[@data-ux='InputFloatLabelLabel'])[1]"));
        WebElement lastNameText = driver.findElement(By.xpath("(//label[@data-ux='InputFloatLabelLabel'])[2]"));
        WebElement emailText = driver.findElement(By.xpath("(//label[@data-ux='InputFloatLabelLabel'])[3]"));
        WebElement message = driver.findElement(By.tagName("textarea"));

        firstNameInputBox.sendKeys("Taylor");
        lastNameInputBox.sendKeys("Green");
        emailInputBox.sendKeys("abc@123.com");
        messageInputBox.sendKeys("This is a test");

        System.out.println(contactUsPageTitle.equals("https://comfyelite.com/contact-us") ? "Contact us Link validation PASSED" : "Contact us Link validation FAILED");
        System.out.println(firstNameInputBox.isDisplayed() ? "First name input box is displayed: PASSED" : "First Name input box is displayed: FAILED");
        System.out.println(lastNameInputBox.isDisplayed() ? "Last name input box is displayed: PASSED" : "Last Name input box is displayed: FAILED");
        System.out.println(emailInputBox.isDisplayed() ? "Email input box is displayed: PASSED" : "Email input box is displayed: FAILED");
        System.out.println(message.isDisplayed() ? "Message input box is displayed: PASSED" : "Message input box is displayed: FAILED");
        System.out.println(firstNameInputBox.getAttribute("value").equals("Taylor") ? "User first name send keys: PASSED" : "User first name send keys: FAILED");
        System.out.println(lastNameInputBox.getAttribute("value").equals("Green") ? "User last name send keys: PASSED" : "User last name send keys: FAILED");
        System.out.println(emailInputBox.getAttribute("value").equals("abc@123.com") ? "User email send keys: PASSED" : "User email send keys: FAILED");
        System.out.println(message.getText().equals("This is a test") ? "User message send keys: PASSED" : "User message send keys: FAILED");
        System.out.println(firstNameText.getText().equals("First Name*") ? "First Name label: PASSED" : "First Name label: FAILED");
        System.out.println(lastNameText.getText().equals("Last Name*") ? "Last Name label: PASSED" : "Last Name label: FAILED");
        System.out.println(emailText.getText().equals("Email*") ? "Email label: PASSED" : "Email label: FAILED");
        System.out.println(message.getAttribute("placeholder").equals("Message*") ? "Message label: PASSED" : "Message label: FAILED");

        Driver.quitDriver();

    }
}
