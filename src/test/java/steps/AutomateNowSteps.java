package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import pages.AutomateNowPage;
import pages.CineplanetPages;
import pages.MetroGasIniPage;
import utils.DriverFactory;
import utils.PropertiesLoader;

public class AutomateNowSteps {

    AutomateNowPage automateNowPage;

    @Given("ingreso al link de AutomateNow")
    public void ingresoAlLinkDeAutomateNow() {
        String base = PropertiesLoader.get("urlA");
        DriverFactory.getDriver().get(base);
        automateNowPage = new AutomateNowPage(DriverFactory.getDriver());
    }

    @And("hago click en el boton para llenar un formulario")
    public void hagoClickEnElBotonParaLlenarUnFormulario() {
        automateNowPage.setBtnForm();
    }

    @And("ingreso el nombre {string} en el input name")
    public void ingresoElNombreEnElInputName(String name) {
        automateNowPage.setInputName(name);
    }

    @And("ingreso la contrasena {string} en el input contrasena")
    public void ingresoLaContrasenaEnElInputContrasena(String pass) {
        automateNowPage.setInputPass(pass);
    }

    @And("selecciono Leche y Cafe en bebidas favoritas")
    public void seleccionoLecheYCafeEnBebidasFavoritas() {
        automateNowPage.setBtnLecheCafe();
    }

    @And("selecciono el color amarillo como favorito")
    public void seleccionoElColorAmarilloComoFavorito() {
        automateNowPage.setBtnColor();
    }

    @And("respondo que si a la pregunta sobre automatizacion")
    public void respondoQueSiALaPreguntaSobreAutomatizacion() {
        automateNowPage.setSelectYes();
    }

    @And("verifico que la herramienta {string} existan")
    public void verificoQueLaHerramientaExistan(String Sel) {
        automateNowPage.setTextSel(Sel);
    }

    @And("ingreso el correo {string} al input del email")
    public void ingresoElCorreoAlInputDelEmail(String email) {
        automateNowPage.setInputEmail(email);
    }

    @When("ingreso el mensaje {string} en el area de texto")
    public void ingresoElMensajeEnElAreaDeTexto(String mensaje) {
        automateNowPage.setInputMensaje(mensaje);
    }

    @Then("presiono el boton Submit y veo el mensaje final")
    public void presionoElBotonSubmitYVeoElMensajeFinal() {
        automateNowPage.setBtnSub();
    }
}
