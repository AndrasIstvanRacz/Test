package demoblaze.test;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"demoblaze.test"},
        plugin = { "pretty", "json:target/cucumber-reports/Cart.json",
                "junit:target/cucumber-reports/Cart.xml",
                "html:target/cucumber-reports" },
        strict = true)

public class AllTest {
}