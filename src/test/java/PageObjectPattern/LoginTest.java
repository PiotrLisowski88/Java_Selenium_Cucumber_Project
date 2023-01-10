package PageObjectPattern;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {
    @Test
    public void loginTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://hotel-testlab.coderslab.pl/en/login?back=my-account");

        String hotelLocation = "Gdańsk";
        String checkInDate = "27-12-2022";
        String checkOutDate = "30-12-2022";
        String hotelName = "The Hotel Prime";

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.loginAs("piotr@wp.pl", "siemankohaselko12");

        SearchBar searchBar = new SearchBar(driver);

        WebElement goHome = driver.findElement(By.cssSelector("a[title='Home'] span"));
        goHome.click();

        searchBar.searchHotel(hotelLocation,checkInDate,checkOutDate,hotelName);

    }
}
