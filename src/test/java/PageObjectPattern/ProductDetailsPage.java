package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class ProductDetailsPage {

    private WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {this.driver = driver;}

    public void verifyDiscount(String discount) {
        WebElement discountElement = driver.findElement(By.cssSelector(".product-flag.discount"));
        String discountText = discountElement.getText();
        if (!discountText.contains(discount)) {
            throw new AssertionError("Discount not found");
        }
    }
    public void selectSize(String size) {
        WebElement sizeDropdown = driver.findElement(By.id("group_1"));
        sizeDropdown.click();
        WebElement sizeOption = driver.findElement(By.cssSelector("#group_1 > option[value='" + size + "']"));
        sizeOption.click();
    }
    public void selectNumberOfPieces(String number) {
        WebElement quantity = driver.findElement(By.cssSelector("#quantity_wanted"));
        quantity.sendKeys(Keys.CONTROL + "a");
        quantity.sendKeys(Keys.DELETE);
        quantity.sendKeys(number);

    }
    public void addToCart() {
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
        addToCartButton.click();
        WebElement continueToCheckout = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        continueToCheckout.click();
    }
    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        checkoutButton.click();
    }
}
