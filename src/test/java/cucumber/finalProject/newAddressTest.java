package cucumber.finalProject;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/Cucumber/Features/adding_new_address.feature",
    plugin = { "pretty", "html:report_address.html"}
)

public class newAddressTest {
}

