package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {
    private WebDriver driver;
    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void startRegistration(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("#email_create"));
        emailField.sendKeys(email);

        WebElement createAccountButton = driver.findElement(By.xpath("//span[normalize-space()='Create an account']"));
        createAccountButton.click();
    }

    public void loginAs(String email, String password) {
        driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();
        WebElement emailAdressInput = driver.findElement(By.id("field-email"));
        emailAdressInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(By.id("field-password"));
        passwordInput.sendKeys(password);
        WebElement logInButton = driver.findElement(By.id("submit-login"));
        logInButton.click();
    }
}
