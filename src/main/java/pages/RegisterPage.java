package pages;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;
import objects.RegisterObject;
import utilities.BaseTest;
import utilities.ReusableMethod;

public class RegisterPage extends BaseTest {

    private final Page page;
    private final ExtentTest test;

    public RegisterPage(Page page, ExtentTest test) {
        this.page = page;
        this.test = test;
    }
    public void clickRegisterLink() {
        page.click(RegisterObject.SIGN_LINK);
        page.click(RegisterObject.REGISTER_LINK);
    }
    public void fillAllTheRegisterData() {
        page.fill(RegisterObject.USER_NAME, "momtazrasel");
        page.fill(RegisterObject.EMAIL, "momtazrasel7@gmail.com");
        page.fill(RegisterObject.PASSWORD, "Abc12345@#");
        page.fill(RegisterObject.CONFIRM_PASSWORD, "Abc12345@#");

    }


}
