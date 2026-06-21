package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ============================
    // ESPERAS PARA By
    // ============================

    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ============================
    // ESPERAS PARA WebElement
    // ============================

    protected WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // ============================
    // ACCIONES PARA By
    // ============================

    protected void click(By locator) {
        waitForClickable(locator).click();
    }

    protected void write(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    // ============================
    // ACCIONES PARA WebElement
    // ============================

    protected void click(WebElement element) {
        waitForClickable(element).click();
    }

    protected void write(WebElement element, String text) {
        waitForVisibility(element).clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        return waitForVisibility(element).getText();
    }

    // ============================
    // VISIBILIDAD
    // ============================

    protected boolean isDisplayed(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            return waitForVisibility(element).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // ============================
    // ASSERTS PROFESIONALES
    // ============================

    protected void assertTextEquals(By locator, String expected) {
        Assertions.assertEquals(expected, getText(locator));
    }

    protected void assertTextEquals(WebElement element, String expected) {
        Assertions.assertEquals(expected, getText(element));
    }

    protected void assertContainsText(By locator, String expected) {
        Assertions.assertTrue(getText(locator).contains(expected));
    }

    protected void assertContainsText(WebElement element, String expected) {
        Assertions.assertTrue(getText(element).contains(expected));
    }

    protected void assertVisible(By locator) {
        Assertions.assertTrue(isDisplayed(locator));
    }

    protected void assertVisible(WebElement element) {
        Assertions.assertTrue(isDisplayed(element));
    }

    protected void assertNotVisible(By locator) {
        Assertions.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)));
    }

    protected void assertUrlContains(String fragment) {
        Assertions.assertTrue(wait.until(ExpectedConditions.urlContains(fragment)));
    }

    protected void assertUrlIs(String expected) {
        Assertions.assertTrue(wait.until(ExpectedConditions.urlToBe(expected)));
    }
}
