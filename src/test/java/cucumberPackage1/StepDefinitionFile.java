package cucumberPackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionFile {

    WebDriver driver;

    // ---------- VALID LOGIN SCENARIO ----------

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hashirakb.github.io/Kerala-Tourism-Website/login.html");
        System.out.println("🌴 Browser launched and Kerala Tourism Login page opened successfully.");
    }

    @When("the user enters a valid username and password")
    public void the_user_enters_a_valid_username_and_password() {
        WebElement usernameField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("admin@geemail.com");
        passwordField.sendKeys("adminADMIN@12354");
        System.out.println("🧠 Entered valid credentials.");
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        System.out.println("🚀 Clicked on Login button.");
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        String currentURL = driver.getCurrentUrl();
        System.out.println("🌐 Current URL after login: " + currentURL);

        if (currentURL.contains("index.html") || currentURL.endsWith("/")) {
            System.out.println("✅ Login successful! User redirected to homepage.");
        } else {
            System.out.println("❌ Login failed. Homepage not reached.");
        }

        driver.quit();
        System.out.println("🧹 Browser closed.");
    }

    // ---------- INVALID LOGIN SCENARIO ----------

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        System.out.println("Entered credentials → Username: " + username + " | Password: " + password);
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        try {
            WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
            String errText = errorMessage.getText();
            System.out.println("⚠️ Error message displayed: " + errText);
        } catch (Exception e) {
            System.out.println("❌ No error message found. Validation missing on page.");
        }

        driver.quit();
        System.out.println("🧹 Browser closed after invalid login test.");
    }
}
