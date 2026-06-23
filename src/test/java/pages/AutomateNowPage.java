package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

}