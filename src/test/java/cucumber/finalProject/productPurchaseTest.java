package cucumber.finalProject;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/purchase_product.feature",
        plugin = { "pretty", "html:report_purchase.html"}
)

public class productPurchaseTest {
}
