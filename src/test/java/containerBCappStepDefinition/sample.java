package containerBCappStepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class sample {
    WebDriver driver;
    @Given("User launches the browser")
    public void user_launches_the_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @When("Enter the url")
    public void enter_the_url() {
        driver.get("www.youtube.com");
    }
    @Then("Page should be loaded")
    public void page_should_be_loaded() {

        System.out.println("success");
    }

}
