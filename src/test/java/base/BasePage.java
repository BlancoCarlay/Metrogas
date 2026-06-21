package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;          // Espera explícita estándar (20s)
    protected WebDriverWait shortWait;     // Espera explícita corta (5s)
    protected WebDriverWait longWait;      // Espera explícita larga (40s)

    public BasePage() {
        this.driver = DriverFactory.getDriver();

        // ============================
        // ESPERA IMPLÍCITA GLOBAL
        // ============================
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // ============================
        // ESPERAS EXPLÍCITAS
        // ============================
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.longWait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // ============================
        // ESPERAR CARGA COMPLETA REAL
        // ============================
        waitForFullLoad();
    }

    // ============================
    // ESPERA PARA CARGA COMPLETA DE PÁGINA (DOM + AJAX + jQuery)
    // ============================

    protected void waitForFullLoad() {

        // 1. Esperar que el DOM esté completo
        try {
            wait.until(driver -> ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState").equals("complete"));
        } catch (Exception ignored) {}

        // 2. Micro pausa para estabilizar animaciones
        try { Thread.sleep(300); } catch (Exception ignored) {}

        // 3. Esperar jQuery si existe
        try {
            wait.until(driver -> (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("return window.jQuery != null && jQuery.active === 0"));
        } catch (Exception ignored) {}

        // 4. Esperar fetch/requests personalizados
        try {
            wait.until(driver -> ((JavascriptExecutor) driver)
                    .executeScript("return (window.pendingRequests || 0) === 0"));
        } catch (Exception ignored) {}
    }

    // ============================
    // ESPERA INVOCABLE DESDE GHERKIN
    // ============================

    public void esperarSegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ============================
    // SCROLL
    // ============================

    public void scrollDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
    }

    public void scrollUp() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
    }

    public void scrollToElement(By locator) {
        WebElement element = waitForVisibility(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
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

    protected WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected boolean waitForInvisibility(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected List<WebElement> waitForAllVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
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

    protected boolean waitForInvisibility(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // ============================
    // ESPERAS AVANZADAS
    // ============================

    protected boolean waitForAttribute(By locator, String attribute, String value) {
        return wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    protected boolean waitForUrlContains(String fragment) {
        return wait.until(ExpectedConditions.urlContains(fragment));
    }

    protected boolean waitForUrlIs(String url) {
        return wait.until(ExpectedConditions.urlToBe(url));
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
    // MÉTODO PARA GENERAR DIFF VISUAL
    // ============================

    private String generarDiff(String expected, String actual) {
        int max = Math.min(expected.length(), actual.length());
        int index = -1;

        for (int i = 0; i < max; i++) {
            if (expected.charAt(i) != actual.charAt(i)) {
                index = i;
                break;
            }
        }

        if (index == -1 && expected.length() != actual.length()) {
            index = max;
        }

        if (index == -1) {
            return "No differences found.";
        }

        StringBuilder pointer = new StringBuilder();
        for (int i = 0; i < index; i++) {
            pointer.append(" ");
        }
        pointer.append("^");

        return "DIFF:\n" +
                expected + "\n" +
                actual + "\n" +
                pointer;
    }

    // ============================
    // ASSERTS PROFESIONALES (CON DIFF)
    // ============================

    protected void assertTextEquals(By locator, String expected) {
        String actual = getText(locator);

        System.out.println("\n================ ASSERT TEXT EQUALS ================");
        System.out.println("EXPECTED: [" + expected + "]");
        System.out.println("FOUND:    [" + actual + "]");
        System.out.println(generarDiff(expected, actual));
        System.out.println("====================================================\n");

        Assertions.assertEquals(expected, actual);
    }

    protected void assertTextEquals(WebElement element, String expected) {
        String actual = getText(element);

        System.out.println("\n================ ASSERT TEXT EQUALS ================");
        System.out.println("EXPECTED: [" + expected + "]");
        System.out.println("FOUND:    [" + actual + "]");
        System.out.println(generarDiff(expected, actual));
        System.out.println("====================================================\n");

        Assertions.assertEquals(expected, actual);
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
        Assertions.assertTrue(waitForInvisibility(locator));
    }

    protected void assertUrlContains(String fragment) {
        Assertions.assertTrue(waitForUrlContains(fragment));
    }

    protected void assertUrlIs(String expected) {
        Assertions.assertTrue(waitForUrlIs(expected));
    }


}
