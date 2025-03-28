package objects;

public class LoginObject {
    public static final String LOGIN_LINK = "(//a[normalize-space()='Sign in'])[1]";
    public static final String USERNAME_INPUT = "(//input[@placeholder='Email address'])[1]";
    public static final String PASSWORD_INPUT = "(//input[@placeholder='Password'])[1]";
    public static final String SIGN_IN_BUTTON = "(//button[normalize-space()='Sign In'])[1]";
    public static final String ACCEPT_COOKIES = "//button[contains(text(), 'I Accept')]";
}
