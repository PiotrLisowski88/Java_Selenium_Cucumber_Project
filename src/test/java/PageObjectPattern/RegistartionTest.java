package PageObjectPattern;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegistartionTest {

    @Test
    public void registerUserTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span"));
        signInButton.click();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.startRegistration("test12aasdasdas341sadas@wp.pl");

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.registerUser("Piotr","Lis", "tajnehaslo1223@");

    }
}
