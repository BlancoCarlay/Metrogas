package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MetroGasIniPage  extends BasePage {
    private WebDriver driver;

    public MetroGasIniPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[normalize-space(text())='Entendido']")
    private WebElement btnEntendido;

    @FindBy(xpath = "//h4[normalize-space(text())='Ya tengo un usuario']")
    private WebElement btnTengoUsuario;

    @FindBy(xpath = "//input[@data-testid='unifiedAuth.form.email']")
    private WebElement inputUsuario;

    @FindBy(xpath = "//input[@data-testid='unifiedAuth.form.password']")
    private WebElement inputPass;

    @FindBy(xpath = "//div[text()='Iniciar sesión']")
    private WebElement btnSesion;

    @FindBy(xpath = "//div[@data-testid='snackbar.label.error']")
    private WebElement textError;


    public void setBtnEntendido(){
        waitForClickable(btnEntendido);
        btnEntendido.click();
    }

    public void setBtnTengoUsuario(){
        waitForClickable(btnTengoUsuario);
        btnTengoUsuario.click();
    }

    public void setInputUsuario(String user){
        waitForVisibility(inputUsuario);
        inputUsuario.sendKeys(user);
    }

    public void setInputPass(String pass){
        waitForVisibility(inputPass);
        inputPass.sendKeys(pass);
    }

    public void setBtnSesion(){
        waitForClickable(btnSesion);
        btnSesion.click();
    }

    public void setValidoMensaje(String error){
        waitForVisibility(textError);
        textError.getText();
        assertContainsText(textError,error);
    }

}
