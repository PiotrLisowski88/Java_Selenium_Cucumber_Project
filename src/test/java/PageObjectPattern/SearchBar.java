package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBar {
    private WebDriver driver;

    public SearchBar(WebDriver driver) { this.driver = driver; }

    public void searchHotel(String hotelLocation, String checkInDate, String checkOutDate, String hotelName) {
        WebElement elementHotelLocation = driver.findElement(By.cssSelector("#hotel_location"));
        elementHotelLocation.sendKeys(hotelLocation);

        WebElement elementCheckInDate = driver.findElement(By.cssSelector("#check_in_time"));
        elementCheckInDate.sendKeys(checkInDate);

        WebElement elementCheckOutDate = driver.findElement(By.cssSelector("#check_out_time"));
        elementCheckOutDate.sendKeys(checkOutDate);

        WebElement elemenHotelClick = driver.findElement(By.cssSelector("#hotel_cat_name"));
        elemenHotelClick.click();

        WebElement elementHotelName = driver.findElement(By.cssSelector(".hotel_name"));
        elementHotelName.click();

        WebElement elementSearchButton = driver.findElement(By.cssSelector("button[id='search_room_submit'] span"));
        elementSearchButton.click();
    }
}
