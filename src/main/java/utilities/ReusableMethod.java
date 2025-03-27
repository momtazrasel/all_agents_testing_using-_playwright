package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;

public class ReusableMethod {

    public static void verifyTextIsDisplayed(Page page, ExtentTest test, String locator, String expectedText, String elementName) {
        page.waitForLoadState(); // Ensure the page is fully loaded

        // Get the actual text from the locator
        String actualText = page.textContent(locator).trim();

        if (actualText.equals(expectedText)) {
            test.pass(elementName + " is displayed with the expected text: \"" + expectedText + "\"");
        } else {
            test.fail(elementName + " text mismatch. Expected: \"" + expectedText + "\", Found: \"" + actualText + "\"");
            throw new AssertionError(elementName + " text mismatch. Expected: \"" + expectedText + "\", Found: \"" + actualText + "\"");
        }
    }

    public static void clickElement(Page page, ExtentTest test, String elementLocator, String stepDescription) {
        try {
            // Wait for the element to be visible
            page.waitForSelector(elementLocator);

            // Click the element
            page.click(elementLocator);

            // Log success in Extent Report
            test.pass(stepDescription + " - Element clicked successfully.");

        } catch (Exception e) {
            // Log failure in Extent Report with screenshot
            test.fail(stepDescription + " - Failed to click the element.");
            throw new RuntimeException(stepDescription + " - Click action failed.", e);
        }
    }

    public static void sendKeys(Page page, String locator, String textToEnter, String stepDescription, ExtentTest test) {
        try {
            // Fill the input field with the provided text
            page.fill(locator, textToEnter);

            // Log success to Extent Report
            test.pass(stepDescription + ": Text '" + textToEnter + "' entered successfully.");

            // Capture and attach a screenshot
        } catch (Exception e) {
            // Log failure to Extent Report
            test.fail(stepDescription + ": Failed to enter text '" + textToEnter + "'. Exception: " + e.getMessage());
            throw e;
        }
    }

    public static void clearText(Page page, String locator, String stepDescription, ExtentTest test) {
        try {
            // Clear the input field by filling it with an empty string
            page.fill(locator, "");

            // Log success to Extent Report
            test.pass(stepDescription + ": Text cleared successfully.");
        } catch (Exception e) {
            // Log failure to Extent Report
            test.fail(stepDescription + ": Failed to clear text. Exception: " + e.getMessage());

            throw e;
        }
    }

    public static void selectFromDropdown(Page page, String locator, String value, String stepDescription, ExtentTest test) {
        try {
            // Select the value from the dropdown
            page.selectOption(locator, value);

            // Log success to Extent Report
            test.pass(stepDescription + ": Selected value '" + value + "' successfully.");
        } catch (Exception e) {
            // Log failure to Extent Report
            test.fail(stepDescription + ": Failed to select value '" + value + "'. Exception: " + e.getMessage());
            throw e;
        }
    }

    public static void hoverOverElement(Page page, ExtentTest test, String elementLocator, String stepDescription) {
        try {
            // Wait for the element to be visible
            page.waitForSelector(elementLocator);

            // Perform hover action
            page.hover(elementLocator);

            // Log success in Extent Report
            test.pass(stepDescription + " - Mouse hovered over the element successfully.");
        } catch (Exception e) {
            // Log failure in Extent Report
            test.fail(stepDescription + " - Failed to hover over the element.");
            throw new RuntimeException(stepDescription + " - Hover action failed.", e);
        }
    }

}
