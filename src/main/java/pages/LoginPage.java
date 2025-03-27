package pages;

import com.microsoft.playwright.Page;
import com.aventstack.extentreports.ExtentTest;
import objects.LoginObject;
import utilities.BaseTest;

public class LoginPage {
    private final Page page;
    private final ExtentTest test;

    public LoginPage(Page page, ExtentTest test) {
        this.page = page;
        this.test = test;
    }

//    public void loginToApplication() {
//        page.navigate("https://staging-submissionpage.ipurvey.com/");
//    }
    public void loginToApplication() {
        page.navigate("https://demowebshop.tricentis.com/");
    }

    public void clickLoginLink() {
        page.click(LoginObject.LOGIN_LINK);
    }

    public void loginWithValidCredentials() {
        page.fill(LoginObject.USERNAME_INPUT, "xyz@gmail.com");
        page.fill(LoginObject.PASSWORD_INPUT, "123456");
        test.pass("Login performed successfully.");
    }
    public void loginWithInValidCredentials() {
        page.fill(LoginObject.USERNAME_INPUT, "xyzzs@gmail.com");
        page.fill(LoginObject.PASSWORD_INPUT, "12345");
        test.pass("Login performed successfully.");
    }

    public void clickOnLoginButton() {
        page.click(LoginObject.LOGIN_BUTTON);
        test.pass("Login performed successfully.");
    }
}
