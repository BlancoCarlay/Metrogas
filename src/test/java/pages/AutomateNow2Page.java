package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomateNow2Page extends BasePage {

    private WebDriver driver;

    public AutomateNow2Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='wp-block-button__link wp-element-button' and @href='https://practice-automation.com/modals/']")
    private WebElement btnModal;

    @FindBy(xpath = "//button[@id='simpleModal']")
    private WebElement btnSimple;

    @FindBy(xpath = "//div[@id='pum_popup_title_1318']")
    private WebElement txtSimple;

    @FindBy(css = "#popmake-1318 > button")
    private WebElement btnX;

    @FindBy(xpath = "//button[@id='formModal']")
    private WebElement btnForm;

    @FindBy(xpath = "//input[@id='g1051-name']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@id='g1051-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//textarea[@id='contact-form-comment-g1051-message']")
    private WebElement inputMensaje;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement btnSub;

    @FindBy(xpath = "//div[text()='Carlay']")
    private WebElement txtName;

    @FindBy(xpath = "//div[text()='prueba@gmail.com']")
    private WebElement txtEmail;

    @FindBy(xpath = "//div[text()='Prueba de Carlay']")
    private WebElement txtTexto;

    @FindBy(css = "#popmake-674 > button")
    private WebElement btnX2;

    @FindBy(xpath = "//h1[text()='Modals']")
    private WebElement txtModals;

    public void setBtnModal(){
        waitForVisibility(btnModal);
        waitForClickable(btnModal);
        scrollPageByElementHeight(btnModal,10);
        btnModal.click();
        esperarSegundos(2);
    }

    public void setBtnSimple(){
        waitForVisibility(btnSimple);
        waitForClickable(btnSimple);
        btnSimple.click();
        esperarSegundos(2);
    }

    public void setValidaTxt(String txt){
        switch (txt.toLowerCase()) {

            case "simple modal":
                waitForVisibility(txtSimple);
                assertTextEquals(txtSimple, txt);
                enmarcarRojo(driver, txtSimple);
                esperarSegundos(2);
                break;

            case "carlay":
                waitForVisibility(txtName);
                assertTextEquals(txtName, txt);
                enmarcarRojo(driver, txtName);
                esperarSegundos(2);
                break;

            case "prueba@gmail.com":
                waitForVisibility(txtEmail);
                assertTextEquals(txtEmail, txt);
                enmarcarRojo(driver, txtEmail);
                esperarSegundos(2);
                break;

            case "prueba de carlay":
                waitForVisibility(txtTexto);
                assertTextEquals(txtTexto, txt);
                enmarcarRojo(driver, txtTexto);
                esperarSegundos(2);
                break;

            case "modals":
                waitForVisibility(txtModals);
                assertTextEquals(txtModals, txt);
                scrollUp();
                esperarSegundos(2);
                enmarcarRojo(driver, txtModals);
                esperarSegundos(2);
                break;

            default:
                throw new IllegalArgumentException("Opción no válida: " + txt);
        }
    }

    public void setBtnX(){
        waitForVisibility(btnX);
        waitForClickable(btnX);
        btnX.click();
        esperarSegundos(2);
    }

    public void setBtnForm(){
        waitForVisibility(btnForm);
        waitForClickable(btnForm);
        btnForm.click();
        esperarSegundos(2);
    }

    public void setInputName(String name){
        waitForVisibility(inputName);
        inputName.sendKeys(name);
        esperarSegundos(2);
    }

    public void setInputEmail(String email){
        waitForVisibility(inputEmail);
        inputEmail.sendKeys(email);
        esperarSegundos(2);
    }

    public void setInputMensaje(String msj){
        waitForVisibility(inputMensaje);
        inputMensaje.sendKeys(msj);
        esperarSegundos(2);
    }

    public void setBtnSub(){
        waitForVisibility(btnSub);
        waitForClickable(btnSub);
        scrollPageByElementHeight(btnSub,10);
        btnSub.click();
        esperarSegundos(2);
    }

    public void setBtnX2(){
        waitForVisibility(btnX2);
        waitForClickable(btnX2);
        btnX2.click();
        esperarSegundos(2);
    }

}
