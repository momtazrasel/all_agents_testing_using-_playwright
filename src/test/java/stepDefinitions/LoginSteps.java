package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.BaseTest;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;

    @Given("the user navigates to the login page and click login link")
    public void the_user_navigates_to_the_login_page_and_click_login_link() {
        loginPage = new LoginPage(page, test);
        loginPage.clickLoginLink();
//        page.navigate("");
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.loginWithValidCredentials();
    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        loginPage.loginWithInValidCredentials();
    }

    @And("clicks on the login button")
    public void clicks_on_the_login_button() throws InterruptedException {
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
    }



}