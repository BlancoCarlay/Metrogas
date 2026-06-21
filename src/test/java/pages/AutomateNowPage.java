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

}