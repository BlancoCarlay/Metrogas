package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CineplanetPages extends BasePage {
    private WebDriver driver;

    public CineplanetPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//span[@class='icon cineplanet-icon cineplanet-icon_close cineplanet-icon_small alert--title-icon-close']")
    private WebElement btnX;

    @FindBy(xpath = "//div[text()='Qué quieres ver']")
    private WebElement selectPeli;

    @FindBy(xpath = "//option[@value='TOY STORY 5']")
    private WebElement textToy5;

    @FindBy(xpath = "//button[contains(@class,'call-to-action') and contains(@class,'call-to-action_pink-solid')]")
    private WebElement btnFiltrar;

    @FindBy(xpath = "//h2[text()='Sinopsis.']")
    private WebElement textSinopsis;


    public void setBtnX(){
        waitForClickable(btnX);
        btnX.click();
    }

    public void setSelectPeli(){
        waitForVisibility(selectPeli);
        waitForClickable(selectPeli);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectPeli);
        // Click forzado (evita interceptación)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectPeli);
    }

    public void setTextToy5(){
        waitForVisibility(textToy5);
        waitForClickable(textToy5);
        textToy5.click();
    }

    public void setBtnFiltrar(){
        waitForClickable(btnFiltrar);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnFiltrar);
        // Click forzado (evita interceptación)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnFiltrar);
    }

    public void setTextSinopsis(String Sip){
        waitForVisibility(textSinopsis);
        waitForClickable(textSinopsis);
        assertContainsText(textSinopsis, Sip);
        System.out.println("FINNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
    }

    }


