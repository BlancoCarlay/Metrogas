package pages;

import base.BasePage;
import org.openqa.selenium.Keys;
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

    //Caso 2
    @FindBy(xpath = "//a[@class='wp-block-button__link wp-element-button' and @href='https://practice-automation.com/calendars/']")
    private WebElement btnCalendario;

    @FindBy(xpath = "//label[@class='grunion-field-label date']")
    private WebElement btnTextCalendario;

    @FindBy(xpath = "//button[@class='dp-focusable dp-cal-year dp-cal-dropdown']")
    private WebElement btnAno;

    @FindBy(xpath = "//button[@class='dp-year' and @data-year='1988']")
    private  WebElement btn1988;

    @FindBy(xpath = "//button[@class='dp-focusable dp-cal-month dp-cal-dropdown']")
    private WebElement btnMes;

    @FindBy(xpath = "//button[@class='dp-month' and @data-month='10']")
    private WebElement btnNov;

    @FindBy(xpath = "//button[@class='dp-day ' and @data-date='595652400000']")
    private WebElement btn16;

    @FindBy(css = "#jp-form-d789f525b512b8c992166cfbd9a18204964b4777 > button")
    private WebElement btnSubmitCal;

    @FindBy(xpath = "//h4[@id='contact-form-success-header-d789f525b512b8c992166cfbd9a18204964b4777']")
    private WebElement txtGracias;

    @FindBy(xpath = "//div[text()='1988-11-16']")
    private WebElement txt161188;

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

            case "thank you for your response.":
                waitForVisibility(txtGracias);
                assertTextEquals(txtGracias, txt);
                scrollUp();
                esperarSegundos(1);
                enmarcarRojo(driver, txtGracias);
                esperarSegundos(1);
                break;

            case "1988-11-16":
                waitForVisibility(txt161188);
                assertTextEquals(txt161188, txt);
                esperarSegundos(1);
                enmarcarRojo(driver, txt161188);
                esperarSegundos(1);
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

    //Caso 2
    public void setBtnCalendario(){
        waitForVisibility(btnCalendario);
        waitForClickable(btnCalendario);
        scrollPageByElementHeight(btnCalendario,10);
        esperarSegundos(2);
        enmarcarRojo(driver, btnCalendario);
        btnCalendario.click();
        esperarSegundos(2);
    }

    public void setBtnTextCalendario(){
        waitForVisibility(btnTextCalendario);
        waitForClickable(btnTextCalendario);
        enmarcarRojo(driver, btnTextCalendario);
        btnTextCalendario.click();
        esperarSegundos(2);
    }

    public void setBtnAno(){
        waitForVisibility(btnAno);
        waitForClickable(btnAno);
        scrollPageByElementHeight(btnAno,20);
        esperarSegundos(2);
        enmarcarRojo(driver, btnAno);
        btnAno.click();
        esperarSegundos(2);

        waitForVisibility(btn1988);
        waitForClickable(btn1988);
        enmarcarRojo(driver, btn1988);
        btn1988.click();
        esperarSegundos(2);
    }

    public void setBtnMes(){
        waitForVisibility(btnMes);
        waitForClickable(btnMes);
        enmarcarRojo(driver, btnMes);
        btnMes.click();
        esperarSegundos(2);

        waitForVisibility(btnNov);
        waitForClickable(btnNov);
        enmarcarRojo(driver, btnNov);
        btnNov.click();
        esperarSegundos(2);
    }

    public void setBtn16(){
        waitForVisibility(btn16);
        waitForClickable(btn16);
        enmarcarRojo(driver, btn16);
        btn16.click();
        esperarSegundos(2);
        scrollUp();
        esperarSegundos(2);
    }

    public void setBtnSubmitCal(){
        waitForVisibility(btnSubmitCal);
        waitForClickable(btnSubmitCal);
        enmarcarRojo(driver, btnSubmitCal);
        btnSubmitCal.click();
        esperarSegundos(3);
    }

}
