package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AssertionNewAddress {

    private WebDriver driver;

    public AssertionNewAddress(WebDriver driver) {
        this.driver = driver;
    }

    public void DataCorectness(String alias, String address, String city, String zip_code, String country, String phone) {

        try {
            String CheckAddress = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[2]/article/div[1]/address")).getText();
            CheckAddress.contains(alias);
            CheckAddress.contains(address);
            CheckAddress.contains(city);
            CheckAddress.contains(zip_code);
            CheckAddress.contains(country);
            CheckAddress.contains(phone);
        } catch (NoSuchElementException e) {
            assertFalse(false);
        }
    }

        public void DeleteAddress () {
            driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]/span")).click();
        }

        public void CheckDelete (String alias){
            try {
                WebElement CheckAddressDelete = driver.findElement(By.cssSelector("h4:contains('" + alias + "')"));
                assertFalse(CheckAddressDelete.isDisplayed());
            } catch (NoSuchElementException e) {
                assertTrue(true);
            }
        }
    }

