package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ShoppingCartSummaryPage {

    private final WebDriver driver;

    public ShoppingCartSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmAddress() {
        WebElement confirmAddressButton = driver.findElement(By.name("confirm-addresses"));
        confirmAddressButton.click();
    }

    public void selectPickupMethod() {
        WebElement pickupMethod = driver.findElement(By.xpath("//*[@id=\"delivery_option_1\"]"));
        if (!pickupMethod.isSelected()) {
            pickupMethod.click();
        }
        driver.findElement(By.name("confirmDeliveryOption")).click();

    }

    public void selectPaymentOption() {
        driver.findElement(By.xpath("//*[@id=\"payment-option-1\"]")).click();
    }

    public void placeAnOrder() {
        driver.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).click();
    }

    public void takeScreenshot() {
        try {
            Robot robot = new Robot();

            // Get the screen size
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            // Capture the screen
            BufferedImage image = robot.createScreenCapture(new Rectangle(screenSize));

            // Save the screenshot to a file
            ImageIO.write(image, "png", new File("screenshot.png"));
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }
}