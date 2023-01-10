package cucumber.finalProject;

import PageObjectPattern.AddNewAddressPage;
import PageObjectPattern.AssertionNewAddress;
import PageObjectPattern.AuthenticationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class newAddressSteps {

    private WebDriver driver;

    @Given("I am logging in on the {string} page using correct {string} and {string}")
    public void iAmLoggingInOnThePageUsingCorrectAnd(String websiteUrl, String email, String password) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(websiteUrl);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.loginAs(email, password);
    }
    @And("I click on the Addresses button and Create new address button")
    public void iClickOnTheAddressesButtonAndCreateNewAddressButton() {
        driver.findElement(By.id("addresses-link")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Create new address']")).click();
    }

    @And("I fill out the New Address form with {string}, {string}, {string}, {string}, {string}, and {string} and click save button.")
    public void iFillOutTheNewAddressFormWithAndAndClickSaveButton(String alias, String address, String city, String zip_code, String country, String phone) {
        AddNewAddressPage addNewAddressPage = new AddNewAddressPage(driver);
        addNewAddressPage.createNewAddress(alias,address,city,zip_code,country,phone);
    }

    @Then("the new address should be displayed with the correct {string}, {string},{string}, {string}, {string}, and {string}")
    public void theNewAddressShouldBeDisplayedWithTheCorrectAnd(String alias, String address, String city, String zip_code, String country, String phone) {
            AssertionNewAddress assertionNewAddress = new AssertionNewAddress(driver);
            assertionNewAddress.DataCorectness(alias, address, city, zip_code, country, phone);
    }

    @Then("delete address")
    public void deleteAddress() {
        AssertionNewAddress assertionNewAddress = new AssertionNewAddress(driver);
        assertionNewAddress.DeleteAddress();
            }

    @And("checking if address with proper {string} is deleted")
    public void checkingIfAddressWithProperIsDeleted(String alias) {
        AssertionNewAddress assertionNewAddress = new AssertionNewAddress(driver);
        assertionNewAddress.CheckDelete(alias);
        }
    }
