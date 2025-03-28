package pages;

import com.microsoft.playwright.Page;
import com.aventstack.extentreports.ExtentTest;
import objects.LoginObject;
import utilities.BaseTest;
import utilities.ReusableMethod;

public class LoginPage {
    private final Page page;
    private final ExtentTest test;

    public LoginPage(Page page, ExtentTest test) {
        this.page = page;
        this.test = test;
    }

    public void loginToApplication() {
        page.navigate("https://www.allagents.co.uk/");
    }
    public void acceptAllCookies(){
        ReusableMethod.acceptCookies(LoginObject.ACCEPT_COOKIES);
    }

    public void clickLoginLink() {
        page.click(LoginObject.LOGIN_LINK);
    }

    public void loginWithValidCredentials() {
        page.fill(LoginObject.USERNAME_INPUT, "momtazrasel7@gmail.com");
        page.fill(LoginObject.PASSWORD_INPUT, "Abc12345@#");
        test.pass("Login performed successfully.");
    }
    public void clickOnLoginButton() {
        page.click(LoginObject.SIGN_IN_BUTTON);
        test.pass("Login performed successfully.");
    }
}
