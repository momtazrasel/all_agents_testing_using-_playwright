package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.LoginObject;
import objects.RegisterObject;
import pages.RegisterPage;
import utilities.BaseTest;
import utilities.ReusableMethod;


public class RegisterSteps extends BaseTest {
    RegisterPage registerPage;

    @Given("the user navigates to the home page and click on the register link")
    public void theUserNavigatesToTheHomePageAndClickOnTheRegisterLink() {
        BaseTest.test.info("Step: Navigate to the register link");
        registerPage = new RegisterPage(page, test);
        registerPage.clickRegisterLink();
        BaseTest.logStepWithScreenshot(BaseTest.page, BaseTest.test, "Click Register Link");

    }

    @When("the user navigates to the register link")
    public void theUserNavigatesToTheRegisterLink() throws InterruptedException {
        registerPage = new RegisterPage(page, test);
        registerPage.clickRegisterLink();
//        registerPage.clickRegisterLink();
        Thread.sleep(3000);
    }

    @And("fill up all the register values")
    public void fillUpAllTheRegisterValues() throws InterruptedException {
        registerPage.fillAllTheRegisterData();
        Thread.sleep(3000);
    }

    @And("click on the register button")
    public void clickOnTheRegisterButton() throws InterruptedException {
        ReusableMethod.clickElement(page, test, RegisterObject.REGISTER_BUTTON,"Click Create an Account Button" );
        Thread.sleep(3000);

    }
}
