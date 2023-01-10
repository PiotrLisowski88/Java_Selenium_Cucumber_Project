package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {
    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) { this.driver = driver; }

    public void registerUser(String firstName, String lastName, String password) {

        WebElement firstNameField = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        lastNameField.sendKeys(lastName);
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        passwordField.sendKeys(password);

        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));
        registerButton.click();
        }
    }

