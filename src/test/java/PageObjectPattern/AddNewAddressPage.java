package PageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddressPage {

    private WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-postcode")
    private WebElement postalCodeInput;

    @FindBy(id = "id_country")
    private WebElement countryDropDown;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement buttonSave;

    public AddNewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createNewAddress(
            String alias,
            String address,
            String postalCode,
            String city,
            String country,
            String phone) {
        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        postalCodeInput.sendKeys(postalCode);
        cityInput.sendKeys(city);
//        countryDropDown.sendKeys(country);
        phoneInput.sendKeys(phone);
        buttonSave.click();
    }
}