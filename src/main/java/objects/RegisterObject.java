package objects;

public class RegisterObject {

    public static final String REGISTER_LINK = "(//a[normalize-space()='Register'])[1]";
    public static final String SIGN_LINK = "(//a[normalize-space()='Sign in'])[1]";
    public static final String USER_NAME = "(//input[@placeholder='User Name'])[1]";
    public static final String EMAIL = "(//input[@placeholder='Email'])[1]";
    public static final String PASSWORD = "(//input[@placeholder='Password'])[1]";
    public static final String CONFIRM_PASSWORD = "(//input[@placeholder='Confirm Password'])[1]";
    public static final String REGISTER_BUTTON = "(//button[normalize-space()='Create Account'])[1]";
    public static final String EXIST_EMAIL = "(//li[normalize-space()='The specified email already exists'])[1]";
}
