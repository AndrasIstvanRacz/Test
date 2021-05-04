package demoblaze.test.login;


import demoblaze.test.setup.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class LoginStepDefinitions {

    WebDriverWait wait = new WebDriverWait(Setup.driver,40);

    @Given("the site for login test")
    public void openWebSite(){
        WebDriverManager.chromedriver().setup();
        Setup.driver = new ChromeDriver();
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);*/
        Setup.driver.manage().window().maximize();
        Setup.driver.navigate().to("https://www.demoblaze.com");
    }

    @And("the Login page")
    public void navigateToLogin(){
        Setup.driver.findElement(By.cssSelector("#login2")).click();
    }

    @Given("user enters username {string}")
    public void giveUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginusername")));
        Setup.driver.findElement(By.cssSelector("#loginusername")).sendKeys(username);
    }

    @And("user enters password {string}")
    public void givePassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginpassword")));
        Setup.driver.findElement(By.cssSelector("#loginpassword")).sendKeys(password);
    }

    @When("clicks on Log in button")
    public void clickToLogin(){
        Setup.driver.findElement(By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary")).click();
    }

    @Then("user should see {string}")
    public void successfulLogin(String nameOfUser){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nameofuser")));
        String text = Setup.driver.findElement(By.cssSelector("#nameofuser")).getText();
        assertEquals(text, nameOfUser);
    }

    @Then("error message displayed")
    public void unsuccessfulLogin() throws InterruptedException {
        wait.until(ExpectedConditions.alertIsPresent());
        String alert = Setup.driver.switchTo().alert().getText();
        assertNotNull(alert);
        Thread.sleep(100);
    }
}
