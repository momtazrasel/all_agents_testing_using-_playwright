package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.BaseTest;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;

    public LoginSteps() {
        if (page == null) {  // Ensure Playwright is initialized
            initializePlaywrightAndReports();
        }
        loginPage = new LoginPage(page, test);
    }

    @Given("the user navigates to the login page and click login link")
    public void the_user_navigates_to_the_login_page_and_click_login_link() {
        loginPage.clickLoginLink();
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.loginWithValidCredentials();
    }

    @And("clicks on the login button")
    public void clicks_on_the_login_button() throws InterruptedException {
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
    }
}
