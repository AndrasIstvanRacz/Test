package demoblaze.test.navigationbar;

import demoblaze.test.setup.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class NavigationBarStepDefinitions extends Base {

    WebDriverWait wait = new WebDriverWait(driver,40);


    @Given("the user press the {string} button")
    public void buttonPressed(String btnXpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnXpath)));
        driver.findElement(By.xpath(btnXpath)).click();
    }

    @Then("the {string} page should be loaded")
    public void testLinkLoaded(String link) {
        assertEquals(driver.getCurrentUrl(), link);
    }

    @Then("the {string} should showed")
    public void testContact(String popupXpath) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popupXpath)));
        assertEquals(driver.findElement(By.xpath(popupXpath)).getAttribute("class"), "modal fade show");
    }

}

