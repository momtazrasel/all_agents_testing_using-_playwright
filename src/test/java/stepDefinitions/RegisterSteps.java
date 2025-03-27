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
        Thread.sleep(3000);
    }

    @And("fill up all the register values")
    public void fillUpAllTheRegisterValues() throws InterruptedException {
        registerPage.fillAllTheRegisterData();
        Thread.sleep(3000);
    }

    @And("click on the register button")
    public void clickOnTheRegisterButton() {
        ReusableMethod.clickElement(page, test, RegisterObject.REGISTER_BUTTON,"Click Login Button" );


    }

    @Then("verify that the registration is completed")
    public void verifyThatTheRegistrationIsCompleted() {
        String expectedText = "The specified email already exists";
        ReusableMethod.verifyTextIsDisplayed(page, test, RegisterObject.EXIST_EMAIL, expectedText, "Email Error Message");

    }

    @Then("verify that the credentials are invalid")
    public void verifyThatTheCredentialsAreInvalid() {
        String expectedText = "Login was unsuccessful. Please correct the errors and try again.";
        ReusableMethod.verifyTextIsDisplayed(page, test, RegisterObject.LOGIN_ERROR, expectedText, "Invalid Credentials Error Message");

    }

    @Given("enter a product name in the search bar")
    public void enterAProductNameInTheSearchBar() {
        ReusableMethod.clickElement(page, test, RegisterObject.SEARCH_BAR, "Search bar");
        page.fill(RegisterObject.SEARCH_BAR, "laptop");


    }

    @And("clicks on the search button")
    public void clicksOnTheSearchButton() {
        ReusableMethod.clickElement(page, test, RegisterObject.SEARCH_BAR_BUTTON, "Search bar");

    }

    @Then("verify that the products is displayed")
    public void verifyThatTheProductsIsDisplayed() {
        String expectedText = "14.1-inch Laptop";
        ReusableMethod.verifyTextIsDisplayed(page, test, RegisterObject.PRODUCT, expectedText, "Product List");

    }

    @When("Click Add to Cart")
    public void clickAddToCart() throws InterruptedException {
        ReusableMethod.clickElement(page, test, RegisterObject.ADD_TO_CART_BUTTON, "Add to Cart button");
        Thread.sleep(2000);

    }

    @And("CLick on shopping cart link")
    public void clickOnShoppingCartLink() {
        ReusableMethod.clickElement(page, test, RegisterObject.SHOPPING_CART, "Add to Cart button");

    }

    @And("Update the product quantities")
    public void updateTheProductQuantities() {
        ReusableMethod.clearText(page, RegisterObject.PRODUCT_INPUT, "Clear input field", test);
        ReusableMethod.sendKeys(page, RegisterObject.PRODUCT_INPUT, "2","Enter new data", test);
//        ReusableMethod.clearText(page, RegisterObject.UPDATE_SHOPPING_CART_BUTTON, "Clear input field", test);
        ReusableMethod.clickElement(page, test, RegisterObject.UPDATE_SHOPPING_CART_BUTTON, "Update Button");
    }

    @And("Remove the product quantities")
    public void removeTheProductQuantities() {
        ReusableMethod.clearText(page, RegisterObject.PRODUCT_INPUT, "Clear input field", test);
        ReusableMethod.clickElement(page, test, RegisterObject.UPDATE_SHOPPING_CART_BUTTON, "Update Button");
    }

    @And("click on the agree checkbox and checkout button")
    public void clickOnTheAgreeCheckboxAndCheckoutButton() throws InterruptedException {
        ReusableMethod.clickElement(page, test, RegisterObject.AGREE_CHECKBOX, "Agree Button");
        ReusableMethod.clickElement(page, test, RegisterObject.CHECKOUT_BUTTON, "Checkout Button");

    }

    @And("Login with valid credentials")
    public void loginWithValidCredentials() throws InterruptedException {
        ReusableMethod.sendKeys(page, LoginObject.USERNAME_INPUT, "xyz@gmail.com","Enter email", test);
        ReusableMethod.sendKeys(page, LoginObject.PASSWORD_INPUT, "123456","Enter password", test);
        ReusableMethod.clickElement(page, test, LoginObject.LOGIN_BUTTON, "Login Button");

    }

    @And("enter billing address")
    public void enterBillingAddress() {
        try {
            ReusableMethod.selectFromDropdown(page,RegisterObject.COUNTRY_DROPDOWN,"United States","Select Country", test);
            ReusableMethod.sendKeys(page, RegisterObject.CITY, "New York","Enter City address", test);
            ReusableMethod.sendKeys(page, RegisterObject.ADDRESS_ONE, "New York","Enter address", test);
            ReusableMethod.sendKeys(page, RegisterObject.ZIP_CODE, "12356","Enter Zip code", test);
            ReusableMethod.sendKeys(page, RegisterObject.PHONE_NUM, "12356","Phone", test);
//        ReusableMethod.clickElement(page, test, RegisterObject.SHIPPING_CONTINUE_BUTTON, "Continue Button");
            ReusableMethod.clickElement(page, test, RegisterObject.SHIPPING_CONTINUE_BUTTON, "Shipping Continue Button");
            ReusableMethod.clickElement(page, test, RegisterObject.SHIPPING_SAVE_CONTINUE_BUTTON, "Shipping Save Continue Button");
            ReusableMethod.clickElement(page, test, RegisterObject.SHIPPING_METHOD_CONTINUE_BUTTON, "Shipping Method Continue Button");
            ReusableMethod.clickElement(page, test, RegisterObject.PAYMENT_METHOD_CONTINUE_BUTTON, "Payment Method Continue Button");
            ReusableMethod.clickElement(page, test, RegisterObject.PAYMENT_INFO_CONTINUE_BUTTON, "Payment Continue Continue Button");
            ReusableMethod.clickElement(page, test, RegisterObject.CONFIRM_BUTTON, "Confirm Button");
        }catch (Exception e){
            ReusableMethod.clickElement(page, test, RegisterObject.SHIPPING_CONTINUE_BUTTON, "Shipping Continue Button");
            ReusableMethod.clickElement(page, test, RegisterObject.SHIPPING_SAVE_CONTINUE_BUTTON, "Shipping Save Continue Button");
            ReusableMethod.clickElement(page, test, RegisterObject.SHIPPING_METHOD_CONTINUE_BUTTON, "Shipping Method Continue Button");
            ReusableMethod.clickElement(page, test, RegisterObject.PAYMENT_METHOD_CONTINUE_BUTTON, "Payment Method Continue Button");
            ReusableMethod.clickElement(page, test, RegisterObject.PAYMENT_INFO_CONTINUE_BUTTON, "Payment Continue Continue Button");
            ReusableMethod.clickElement(page, test, RegisterObject.CONFIRM_BUTTON, "Confirm Button");
        }

    }

    @And("click on the guest checkout button")
    public void clickOnTheGuestCheckoutButton() {
        ReusableMethod.clickElement(page, test, RegisterObject.GUEST_CHECKOUT, "Guest Checkout Button");
    }

    @And("enter guest billing address")
    public void enterGuestBillingAddress() throws InterruptedException {
        ReusableMethod.sendKeys(page, RegisterObject.BILLING_FIRST_NAME, "xyz","Enter billing first name", test);
        ReusableMethod.sendKeys(page, RegisterObject.BILLING_LAST_NAME, "xyz","Enter billing last name", test);
        ReusableMethod.sendKeys(page, RegisterObject.BILLING_EMAIL, "xyz@gmail.com","Enter email", test);
        ReusableMethod.selectFromDropdown(page,RegisterObject.COUNTRY_DROPDOWN,"United States","Select Country", test);
        ReusableMethod.sendKeys(page, RegisterObject.CITY, "New York","Enter City address", test);
        ReusableMethod.sendKeys(page, RegisterObject.ADDRESS_ONE, "New York","Enter address", test);
        ReusableMethod.sendKeys(page, RegisterObject.ZIP_CODE, "12356","Enter Zip code", test);
        ReusableMethod.sendKeys(page, RegisterObject.PHONE_NUM, "12356","Phone", test);
        ReusableMethod.clickElement(page, test, RegisterObject.SHIPPING_CONTINUE_BUTTON, "Shipping Continue Button");
        ReusableMethod.clickElement(page, test, RegisterObject.SHIPPING_SAVE_CONTINUE_BUTTON, "Shipping Save Continue Button");
        ReusableMethod.clickElement(page, test, RegisterObject.SHIPPING_METHOD_CONTINUE_BUTTON, "Shipping Method Continue Button");
        ReusableMethod.clickElement(page, test, RegisterObject.PAYMENT_METHOD_CONTINUE_BUTTON, "Payment Method Continue Button");
        ReusableMethod.clickElement(page, test, RegisterObject.PAYMENT_INFO_CONTINUE_BUTTON, "Payment Continue Continue Button");
        ReusableMethod.clickElement(page, test, RegisterObject.CONFIRM_BUTTON, "Confirm Button");


    }

    @And("apply coupon code")
    public void applyCouponCode() {
        ReusableMethod.sendKeys(page, RegisterObject.COUPON_INPUT_FIELD, "12356","enter coupon code", test);
        ReusableMethod.clickElement(page, test, RegisterObject.APPLY_COUPON_BUTTON, "Apply Coupon Button");

    }

    @Given("enter email in newsletter text field")
    public void enterEmailInNewsletterTextField() {
        ReusableMethod.sendKeys(page, RegisterObject.NEWSLETTER_INPUT, "xyz@gmail.com","Newsletter Email", test);
    }

    @And("click on the subscribe button")
    public void clickOnTheSubscribeButton() {
        ReusableMethod.clickElement(page, test, RegisterObject.SUBSCRIBE_BUTTON, "Subscribe Button");
    }

    @Then("verify that the user successfully subscribe")
    public void verifyThatTheUserSuccessfullySubscribe() {
        String expectedText = "Thank you for signing up! A verification email has been sent. We appreciate your interest.";
        ReusableMethod.verifyTextIsDisplayed(page, test, RegisterObject.NEWSLETTER_SUCCESS_TEXT, expectedText, "Expected Text");

    }

    @Given("the user navigates to the computer tab")
    public void theUserNavigatesToTheComputerTab() throws InterruptedException {
        ReusableMethod.hoverOverElement(page, test, RegisterObject.COMPUTERS_TAB, "Computer Tab");
        Thread.sleep(2000);
        ReusableMethod.hoverOverElement(page, test, RegisterObject.COMPUTERS_OPTION, "Select Desktop");
//        ReusableMethod.clickElement(page, test, RegisterObject.COMPUTERS_OPTION, "Select Desktop");

    }

    @And("Select Price Low to High sorting option")
    public void selectPriceLowToHighSortingOption() {
        ReusableMethod.selectFromDropdown(page,RegisterObject.SORT_BY_DROPDOWN,"Price: Low to High","Select price", test);

    }

    @And("click on the logout button")
    public void clickOnTheLogoutButton() {
        ReusableMethod.clickElement(page, test, RegisterObject.LOGOUT_LINK, "Logout Link");
    }

    @When("click on the displayed product")
    public void clickOnTheDisplayedProduct() {
        ReusableMethod.clickElement(page, test, RegisterObject.PRODUCT, "Product");
    }

    @And("product share with your friends")
    public void productShareWithYourFriends() {
        ReusableMethod.clickElement(page, test, RegisterObject.EMAIL_FRIEND_BUTTON, "Email button");
        ReusableMethod.sendKeys(page, RegisterObject.FRIEND_EMAIL_TEXT_FIELD, "xyz@gmail.com","Enter friend email", test);
        ReusableMethod.sendKeys(page, RegisterObject.YOUR_EMAIL_TEXT_FIELD, "yxz@gmail.com","Enter user email", test);
        ReusableMethod.clickElement(page, test, RegisterObject.SEND_EMAIL_BUTTON, "Send Email button");
    }

    @And("product add and remove from compare list")
    public void productAddAndRemoveFromCompareList() {
        ReusableMethod.clickElement(page, test, RegisterObject.ADD_TO_COMPARE_LIST_BUTTON, "Add to compare button");
        ReusableMethod.clickElement(page, test, RegisterObject.REMOVE_BUTTON, "Remove button");

    }


    // Travel site

    @Given("the user navigates to the login page and insert all the data")
    public void theUserNavigatesToTheLoginPageAndInsertAllTheData() throws InterruptedException {
        ReusableMethod.sendKeys(page, RegisterObject.FirstName, "Momtaz","Enter First Name", test);
        Thread.sleep(300);
        ReusableMethod.sendKeys(page, RegisterObject.LastName, "Rasel","Enter Last Name", test);
        Thread.sleep(300);
        ReusableMethod.sendKeys(page, RegisterObject.Email, "momtazrasel8@gmail.com","Enter Email", test);
        Thread.sleep(300);
        ReusableMethod.sendKeys(page, RegisterObject.ContactNumber, "+8801794558666","Phone Number", test);
        Thread.sleep(300);
        ReusableMethod.sendKeys(page, RegisterObject.ReferenceNumber, "AB12XH","Reference Number", test);
        Thread.sleep(300);
        ReusableMethod.sendKeys(page, RegisterObject.FlightNumber, "Flight Number","Phone Number", test);
        Thread.sleep(300);
//        ReusableMethod.sendKeys(page, RegisterObject.DepartureDate, "6-1-2025","Phone Number", test);
        Thread.sleep(300);
        ReusableMethod.clickElement(page, test, RegisterObject.DepartureDate, "Remove button");
        Thread.sleep(300);
        ReusableMethod.clickElement(page, test, RegisterObject.ChooseDate, "Remove button");
        Thread.sleep(300);
        ReusableMethod.clickElement(page, test, RegisterObject.DepartureTime, "Remove button");
        Thread.sleep(300);
        ReusableMethod.clickElement(page, test, RegisterObject.SelectTime, "Remove button");
        Thread.sleep(300);
        ReusableMethod.clickElement(page, test, RegisterObject.DepartureAirport, "Remove button");
        Thread.sleep(300);
        ReusableMethod.clickElement(page, test, RegisterObject.SelectAirport, "Remove button");
        Thread.sleep(300);

        ReusableMethod.clickElement(page, test, RegisterObject.FinalAirport, "Remove button");
        Thread.sleep(300);
        ReusableMethod.clickElement(page, test, RegisterObject.SelectFinalAirport, "Remove button");
        Thread.sleep(300);
//
        ReusableMethod.clickElement(page, test, RegisterObject.ArivalDate, "Remove button");
        Thread.sleep(300);
        ReusableMethod.clickElement(page, test, RegisterObject.ChooseDate, "Remove button");
        Thread.sleep(300);

        ReusableMethod.clickElement(page, test, RegisterObject.ArivalTime, "Remove button");
        Thread.sleep(300);
        ReusableMethod.clickElement(page, test, RegisterObject.SelectTime, "Remove button");
        Thread.sleep(300);
        ReusableMethod.clickElement(page, test, RegisterObject.SubmitButton, "Remove button");
        Thread.sleep(300);
    }
}
