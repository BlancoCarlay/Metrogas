package pages;

import base.BasePage;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutomateNowPage extends BasePage {
    private WebDriver driver;

    public AutomateNowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='wp-block-button__link wp-element-button' and @href='https://practice-automation.com/form-fields/']")
    private WebElement btnForm;

    @FindBy(xpath = "//input[@id='name-input']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPass;

    @FindBy(xpath = "//input[@id='drink2']")
    private WebElement btnLeche;
    @FindBy(xpath = "//input[@id='drink3']")
    private WebElement btnCafe;

    @FindBy(xpath = "//input[@id='color3']")
    private WebElement btnColor;

    @FindBy(xpath = "//select[@id='automation']")
    private WebElement selectYes;

    @FindBy(xpath = "//li[normalize-space()='Selenium']")
    private WebElement textSel;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//textarea[@data-testid='message']")
    private WebElement inputMensaje;

    @FindBy(xpath = "//button[@id='submit-btn']")
    private WebElement btnSub;

    //Xpath del caso 2
    @FindBy(xpath = "//a[@class='wp-block-button__link wp-element-button' and @href='https://practice-automation.com/click-events/']")
    private WebElement btnClick;

    @FindBy(xpath = "//button[@onclick='catSound()']")
    private WebElement btnGato;

    @FindBy(xpath = "//h2[text()='Meow!']")
    private WebElement textGato;

    @FindBy(xpath = "//button[@onclick='dogSound()']")
    private WebElement btnPero;

    @FindBy(xpath = "//h2[text()='Woof!']")
    private WebElement textPerro;

    @FindBy(xpath = "//button[@onclick='pigSound()']")
    private WebElement btnPuerco;

    @FindBy(xpath = "//h2[text()='Oink!']")
    private WebElement textPrueco;

    @FindBy (xpath = "//button[@onclick='cowSound()']")
    private WebElement btnVaca;

    @FindBy(xpath = "//h2[text()='Moo!']")
    private WebElement textVaca;

    @FindBy(xpath = "//a[@class='wp-block-button__link wp-element-button' and @href='https://practice-automation.com/iframes/']")
    private WebElement btnIframes;

    @FindBy(xpath = "//iframe[contains(@src,'https://playwright.dev/')]")
    private WebElement ifrPlay;

    @FindBy(xpath = "//span[@class='highlight_gXVj' and text()='Playwright']")
    private WebElement ifrPlay2;

    @FindBy(xpath = "//iframe[contains(@src,'https://www.selenium.dev/')]")
    private WebElement ifrSel;

    @FindBy(xpath = "//a[@href='/sponsors' and @class='selenium-button selenium-white-cyan text-uppercase fw-bold']")
    private WebElement textLearn;

    @FindBy(xpath = "//a[@href='https://www.shipfox.io']")
    private WebElement btnShip;

    //Caso 4
    @FindBy(xpath = "//a[@class='wp-block-button__link wp-element-button' and @href='https://practice-automation.com/popups/']")
    private WebElement btnPop;

    @FindBy(xpath = "//button[@onclick='alertPopup()']")
    private WebElement btnAlertPop;

    @FindBy(xpath = "//button[@onclick='confirmPopup()']")
    private WebElement btnConfirmPop;

    @FindBy(xpath = "//p[@id='confirmResult' and text()='OK it is!']")
    private WebElement textConfirmPop;

    @FindBy(xpath = "//p[@id='confirmResult' and text()='Cancel it is!']")
    private WebElement textCancelPop;

    @FindBy(xpath = "//button[@onclick='promptPopup()']")
    private  WebElement btnProntPop;

    @FindBy(css = "#promptResult")
    private  WebElement textNice;

    @FindBy(css = "#promptResult")
    private WebElement textCancelNice;

    public void setBtnForm() {
        waitForClickable(btnForm);
        // Click forzado (evita interceptación)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnForm);
        esperarSegundos(2);
    }

    public void setInputName(String name){
        waitForVisibility(inputName);
        inputName.sendKeys(name);
        esperarSegundos(2);
    }

    public void setInputPass(String pass){
        waitForVisibility(inputPass);
        inputPass.sendKeys(pass);
        esperarSegundos(2);
    }

    public void setBtnLecheCafe(){
        waitForVisibility(btnLeche);
        waitForVisibility(btnCafe);
        scrollDown();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnLeche);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnCafe);
        esperarSegundos(2);
    }

    public void setBtnColor(){
        waitForVisibility(btnColor);
        btnColor.click();
        esperarSegundos(2);
    }

    public void setSelectYes(){
        waitForVisibility(selectYes);
        selectYes.click();
        selectYes.sendKeys(Keys.DOWN);
        selectYes.sendKeys(Keys.ENTER);
        esperarSegundos(2);
    }

    public void setTextSel(String Sel){
        waitForVisibility(textSel);
        scrollDown();
        //assertTextEquals(textSel,Sel);
        assertTextEquals(textSel,Sel);
        esperarSegundos(2);
    }

    public void setInputEmail(String email){
        waitForVisibility(inputEmail);
        inputEmail.sendKeys(email);
        esperarSegundos(2);
    }

    public void setInputMensaje(String mensaje){
        waitForVisibility(inputMensaje);
        inputMensaje.sendKeys(mensaje);
        esperarSegundos(2);
    }

    public void setBtnSub(){
        waitForVisibility(btnSub);
        scrollDown();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSub);
        esperarSegundos(2);
    }

    //Funsiones del caso 2
    public void setBtnClick(){
        waitForClickable(btnClick);
        scrollPageByElementHeight(btnClick,25);
        esperarSegundos(2);
        btnClick.click();
        esperarSegundos(2);
    }

    public void setBtnGato(){
        waitForClickable(btnGato);
        btnGato.click();
        esperarSegundos(2);
    }

    public void setTextGato(String animal){
        switch (animal.toLowerCase()) {

            case "meow!":
                waitForVisibility(textGato);
                assertTextEquals(textGato, animal);
                esperarSegundos(2);
                break;

            case "woof!":
                waitForVisibility(textPerro);
                assertTextEquals(textPerro, animal);
                esperarSegundos(2);
                break;

            case "oink!":
                waitForVisibility(textPrueco);
                assertTextEquals(textPrueco, animal);
                esperarSegundos(2);
                break;

            case "moo!":
                waitForVisibility(textVaca);
                assertTextEquals(textVaca, animal);
                esperarSegundos(2);
                break;

            default:
                throw new IllegalArgumentException("Animal no válido: " + animal);
        }
    }

    public void setBtnPero(){
        waitForClickable(btnPero);
        btnPero.click();
        esperarSegundos(2);
    }

    public void setBtnPuerco(){
        waitForClickable(btnPuerco);
        btnPuerco.click();
        esperarSegundos(2);
    }

    public void setBtnVaca(){
        waitForClickable(btnVaca);
        btnVaca.click();
        esperarSegundos(2);
    }

    //Caso 3
    public void setBtnIframes(){
        waitForClickable(btnIframes);
        scrollPageByElementHeight(btnIframes,30);
        esperarSegundos(2);
        btnIframes.click();
        esperarSegundos(2);
    }

    public void setIfrPlay(){
        waitForVisibility(ifrPlay);
        waitForClickable(ifrPlay);
        scrollPageByElementHeight(ifrPlay,1);
        driver.switchTo().frame(ifrPlay);
        esperarSegundos(2);

        waitForVisibility(ifrPlay2);
        scrollPageByElementHeight(ifrPlay2,35);
        driver.switchTo().defaultContent();
        esperarSegundos(2);
    }

    public void setIfrSel(){
        waitForVisibility(ifrSel);
        waitForClickable(ifrSel);
        scrollPageByElementHeight(ifrSel,1);
        driver.switchTo().frame(ifrSel);
        esperarSegundos(2);
    }

    public void setTextLearn(String opc){
        waitForVisibility(textLearn);
        waitForClickable(textLearn);
        scrollPageByElementHeight(textLearn,110);
        assertTextEquals(textLearn, opc);
        esperarSegundos(2);
    }

    public void setTextLearnClick(){
        waitForClickable(textLearn);
        textLearn.click();
        esperarSegundos(2);
    }

    public void setBtnShip(){
        waitForVisibility(btnShip);
        waitForClickable(btnShip);
        scrollPageByElementHeight(btnShip,55);
        esperarSegundos(2);
    }

    public void setBtnShip2(){
        waitForVisibility(btnShip);
        waitForClickable(btnShip);
        btnShip.click();
        esperarSegundos(2);
    }

    //Caso 4
    public void setBtnPop(){
        waitForVisibility(btnPop);
        waitForClickable(btnPop);
        scrollPageByElementHeight(btnPop,5);
        btnPop.click();
        esperarSegundos(2);
    }

    public void setBtnAlertPop(){
        waitForVisibility(btnAlertPop);
        waitForClickable(btnAlertPop);
        btnAlertPop.click();
        esperarSegundos(2);
        aceptarAlerta();
        esperarSegundos(2);
    }

    public void setBtnConfirmPop(){
        waitForVisibility(btnConfirmPop);
        waitForClickable(btnConfirmPop);
        btnConfirmPop.click();
        esperarSegundos(2);
        aceptarAlerta();
        esperarSegundos(2);
    }

    public void setTextRespPop(String RespPop){
        //waitForVisibility(textConfirmPop);
        //assertTextEquals(textConfirmPop, RespPop);
        //esperarSegundos(2);
        switch (RespPop.toLowerCase()) {

            case "ok it is!":
                waitForVisibility(textConfirmPop);
                assertTextEquals(textConfirmPop, RespPop);
                esperarSegundos(2);
                break;

            case "cancel it is!":
                waitForVisibility(textCancelPop);
                assertTextEquals(textCancelPop, RespPop);
                esperarSegundos(2);
                break;

            case "nice to meet you, carlay!":
                waitForVisibility(textNice);
                assertTextEquals(textNice, RespPop);
                esperarSegundos(2);
                break;

            case "fine, be that way...":
                waitForVisibility(textCancelNice);
                assertTextEquals(textCancelNice, RespPop);
                esperarSegundos(2);
                break;

            default:
                throw new IllegalArgumentException("Opción no válida: " + RespPop);
        }
    }

    public void setBtnCancelarPop(){
        waitForVisibility(btnConfirmPop);
        waitForClickable(btnConfirmPop);
        btnConfirmPop.click();
        esperarSegundos(2);
        cancelarAlerta();
        esperarSegundos(2);
    }

    public void setBtnProntPop(String name){
        waitForVisibility(btnProntPop);
        waitForClickable(btnProntPop);
        btnProntPop.click();
        esperarSegundos(2);
        ingresarTextoEnAlerta(name);
        esperarSegundos(2);
    }

    public void setBtnCancelProntPop(){
        waitForVisibility(btnProntPop);
        waitForClickable(btnProntPop);
        btnProntPop.click();
        esperarSegundos(2);
        cancelarAlerta();
        esperarSegundos(2);
    }

}