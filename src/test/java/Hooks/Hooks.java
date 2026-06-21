package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Hooks {

    // ============================================
    // MANEJAR ALERT SI EXISTE (ANTES DE SCREENSHOT)
    // ============================================
    private void manejarAlertSiExiste() {
        try {
            WebDriver driver = DriverFactory.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();

            System.out.println("⚠ ALERT DETECTADO EN HOOK: " + alert.getText());
            alert.accept();
            System.out.println("✔ ALERT CERRADO AUTOMÁTICAMENTE");

        } catch (Exception ignored) {
            // No hay alert, continuar normal
        }
    }

    @After
    public void tearDown(Scenario scenario) {

        // ============================
        // 0. Cerrar alert si existe
        // ============================
        manejarAlertSiExiste();

        // ============================
        // 1. Screenshot SIEMPRE
        // ============================
        byte[] screenshot = null;

        try {
            screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
        } catch (UnhandledAlertException e) {
            System.out.println("⚠ ALERT BLOQUEÓ EL SCREENSHOT. Reintentando...");

            manejarAlertSiExiste();

            screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
        }

        scenario.attach(screenshot, "image/png", scenario.getName());
        saveScreenshotToFramework(scenario.getName(), screenshot);

        // ============================
        // 2. Cerrar driver
        // ============================
        DriverFactory.quitDriver();
    }

    // ============================================
    // 3. EJECUTAR SOLO UNA VEZ AL FINAL DEL RUNNER
    // ============================================
    @AfterAll
    public static void generateReport() {

        try {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String resultsFolder = "reports/" + timestamp + "/allure-results/";
            String htmlFolder = "reports/" + timestamp + "/allure-report/";

            copyFolder(new File("build/allure-results"), new File(resultsFolder));

            ProcessBuilder pb = new ProcessBuilder(
                    "C:\\Users\\carlo\\scoop\\apps\\allure\\2.43.0\\bin\\allure.bat",
                    "generate",
                    resultsFolder,
                    "--clean",
                    "-o",
                    htmlFolder
            );

            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();

            System.out.println("HTML generado en: " + htmlFolder);

        } catch (Exception e) {
            System.out.println("⚠ No se pudo generar el HTML desde el Hook.");
            e.printStackTrace();
        }
    }

    // ============================================
    // GUARDAR SCREENSHOT EN CARPETA DEL FRAMEWORK
    // ============================================
    private void saveScreenshotToFramework(String scenarioName, byte[] screenshotBytes) {
        try {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String folderPath = "screenshots/";
            new File(folderPath).mkdirs();

            String filePath = folderPath + scenarioName + "_" + timestamp + ".png";

            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(screenshotBytes);
            fos.close();

            System.out.println("Screenshot guardado en: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ============================================
    // MÉTODO UTILITARIO PARA COPIAR CARPETAS
    // ============================================
    private static void copyFolder(File source, File dest) throws IOException {
        if (!dest.exists()) dest.mkdirs();

        for (File file : source.listFiles()) {
            File destFile = new File(dest, file.getName());
            if (file.isDirectory()) {
                copyFolder(file, destFile);
            } else {
                Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
