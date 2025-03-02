package mystory.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class UserSteps {
    WebDriver driver;

    @Given("The user is on the login page")
    public void openMyStoryShopPage() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }


    @When("I sign in")
    public void iSignIn() {
        driver.findElement(By.cssSelector("[class=\"user-info\"]")).click();

    }

    @And("The user logs in with email {string} and {string}")
    public void theUserLogsInWithEmailAnd(String email, String password) {
        driver.findElement(By.id("field-email")).sendKeys(email);
        driver.findElement(By.id("field-password")).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
    }


    @And("The user goes to {string}")
    public void theUserGoesTo(String Address) {
        driver.findElement(By.id("addresses-link")).click();
    }


    @And("The user clicks Create new address")
    public void theUserClicksCreateNewAddress() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=address");
    }


    @And("The user fills in the form with: {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserFillsInTheFormWith(String alias, String address, String city, String zip, String country, String phone) {
        driver.findElement(By.id("field-alias")).sendKeys(alias);
        driver.findElement(By.id("field-address1")).sendKeys(address);
        driver.findElement(By.id("field-city")).sendKeys(city);
        driver.findElement(By.id("field-postcode")).sendKeys(zip);
        WebElement countryDropdown = driver.findElement(By.id("field-id_country"));
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
        driver.findElement(By.id("field-phone")).sendKeys(phone);
    }


    @And("The user saves the address")
    public void theUserSavesTheAddress() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @Then("The new address should be displayed with the correct details {string}, {string}, {string}, {string}, {string}, {string}")
    public void theNewAddressShouldBeDisplayedWithTheCorrectDetails(String name, String street, String city, String zip, String country, String phone) {

        WebElement secondAddress = driver.findElement(By.xpath("(//div[@class='address-body'])[2]/address"));
        String actualText = secondAddress.getText().trim();
        String expectedText = String.join("\n", name, street, city, zip, country, phone);
        Assert.assertEquals("Adres nie jest poprawny!", expectedText, actualText);
    }

    @And("The user delete address")
    public void theUserDeleteAddress() {
        WebElement secondDeleteButton = driver.findElement(By.xpath("(//a[@data-link-action='delete-address'])[2]"));
        secondDeleteButton.click();
    }

    @And("The delete address should be displayed with the correct details{string}")
    public void theDeleteAddressShouldBeDisplayedWithTheCorrectDetails(String expectedText) {
        WebElement alert = driver.findElement(By.className("alert-success"));
        Assert.assertTrue("Address successfully deleted!", alert.isDisplayed());
        assertEquals(expectedText, alert.getText());
    }

    @And("The user close browser")
    public void theUserCloseBrowser() {
        driver.quit();
    }


}







