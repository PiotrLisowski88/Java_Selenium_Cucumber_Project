package cucumber.finalProject;

import PageObjectPattern.AuthenticationPage;
import PageObjectPattern.ProductDetailsPage;
import PageObjectPattern.SearchForProduct;
import PageObjectPattern.ShoppingCartSummaryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class productPurchaseSteps {

    private WebDriver driver;
    private AuthenticationPage authenticationPage;
    private SearchForProduct searchForProduct;
    private ProductDetailsPage productDetailsPage;


    @Given("I open {string} page, enter my {string} and {string} and click the login button")
    public void iOpenPageEnterMyAndAndClickTheLoginButton(String websiteUrl, String email, String password) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(websiteUrl);
        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.loginAs(email, password);
    }

    @When("I search for the the product in searchbar and click on it")
    public void iSearchForTheTheProductInSearchbarAndClickOnIt() {
        searchForProduct = new SearchForProduct(driver);
        searchForProduct.SearchProduct();
    }

    @And("verify that there is a {string} discount on the product")
    public void verifyThatThereIsADiscountOnTheProduct(String discount) {
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.verifyDiscount(discount);
    }

    @And("select size {string}")
    public void selectSize(String size) {
        productDetailsPage.selectSize(size);
    }

    @And("select {string} of pieces")
    public void selectOfPieces(String number) {
        productDetailsPage.selectNumberOfPieces(number);
    }

    @Then("I add the product to my basket")
    public void iAddTheProductToMyBasket() {
        productDetailsPage.addToCart();
    }

    @And("I go to the checkout option")
    public void iGoToTheCheckoutOption() {
        productDetailsPage.proceedToCheckout();
    }

    @And("I confirm my address")
    public void iConfirmMyAddress() {
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        shoppingCartSummaryPage.confirmAddress();
    }

    @And("I select the pickup method pick up in store")
    public void iSelectThePickupMethodPickUpInStore() {
       ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
       shoppingCartSummaryPage.selectPickupMethod();
    }

    @And("I select the payment option Pay by Check")
    public void iSelectThePaymentOptionPayByCheck() {
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        shoppingCartSummaryPage.selectPaymentOption();
    }

    @And("I click on order with an obligation to pay")
    public void iPlaceAnOrderWithObligationToPay() {
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        shoppingCartSummaryPage.placeAnOrder();
    }

    @Then("I take a screenshot of the order confirmation and the amount")
    public void iTakeAScreenshotOfTheOrderConfirmationAndTheAmount() {
        WebElement screenshotConfirmation = driver.findElement(By.xpath("//*[@id=\"content-hook_order_confirmation\"]/div/div/div/h3"));
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        shoppingCartSummaryPage.takeScreenshot();
    }
}
