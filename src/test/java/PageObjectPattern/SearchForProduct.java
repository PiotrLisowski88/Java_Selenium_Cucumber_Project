package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchForProduct {

    private WebDriver driver;

    public SearchForProduct(WebDriver driver) { this.driver = driver; }

    public void SearchProduct(){

        String product = "Hummingbird Printed Sweater";

        WebElement searchInput = driver.findElement(By.cssSelector("input[placeholder='Search our catalog']"));
        searchInput.sendKeys(product);
        driver.findElement(By.cssSelector("#search_widget > form > button > i")).click();
        driver.findElement(By.cssSelector("img[alt='Brown bear printed sweater']")).click();
    }

}
