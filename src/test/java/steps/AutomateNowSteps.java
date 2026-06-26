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

    //Pasos del caso 2
    //Para este caso se reutilizo el Given del caso 1
    @And("hago click en el boton para clickear opciones")
    public void hagoClickEnElBotonParaClickearOpciones() {
        automateNowPage.setBtnClick();
    }

    @And("hago click en el boton de Gato")
    public void hagoClickEnElBotonDeGato() {
        automateNowPage.setBtnGato();
    }

    @And("valido que se muestre el texto {string}")
    public void validoQueSeMuestreElTexto(String animal) {
        automateNowPage.setTextGato(animal);
    }

    @And("hago click en el boton de Perro")
    public void hagoClickEnElBotonDePerro() {
        automateNowPage.setBtnPero();
    }

    @And("hago click en el boton de Puerco")
    public void hagoClickEnElBotonDePuerco() {
        automateNowPage.setBtnPuerco();
    }

    @When("hago click en el boton de Vaca")
    public void hagoClickEnElBotonDeVaca() {
        automateNowPage.setBtnVaca();
    }

    //Pasos del caso 3
    //Para este caso se reutilizo el Given del caso 1
    @And("hago click en el boton para clickear iframes")
    public void hagoClickEnElBotonParaClickearIframes() {
        automateNowPage.setBtnIframes();
    }

    @And("ubico el iframe de playwright")
    public void ubicoElIframeDePlaywright() {
        automateNowPage.setIfrPlay();
    }

    @And("ubico el iframe de selenium")
    public void ubicoElIframeDeSelenium() {
        automateNowPage.setIfrSel();
    }

    @And("bajo hasta encontrar la opcion {string}")
    public void bajoHastaEncontrarLaOpcion(String opc) {

        automateNowPage.setTextLearn(opc);
    }

    @When("hago click sobre el texto LEARN MORE")
    public void hagoClickSobreElTextoLEARNMORE() {
        automateNowPage.setTextLearnClick();
    }

    @And("busco la opcion ShipFox")
    public void buscoLaOpcionShipFox() {
        automateNowPage.setBtnShip();
    }

    @Then("hago click sobre la opcion ShipFox")
    public void hagoClickSobreLaOpcionShipFox() {
        automateNowPage.setBtnShip2();
    }

    //Caso4
    //Para este caso se reutilizo el Given del caso 1
    @And("hago click en el boton para clickear popups")
    public void hagoClickEnElBotonParaClickearPopups() {
        automateNowPage.setBtnPop();
    }

    @And("hago click en Alert Popup")
    public void hagoClickEnAlertPopup() {
        automateNowPage.setBtnAlertPop();
    }

    @When("hago click en Confirm Popup")
    public void hagoClickEnConfirmPopup() {
        automateNowPage.setBtnConfirmPop();
    }

    @And("valido el texto {string}")
    public void validoElTexto(String RespPop) {
        automateNowPage.setTextRespPop(RespPop);
    }

    @And("hago click en cancelar alerta para la opcion Confirm Popup")
    public void hagoClickEnCancelarAlertaParaLaOpcionConfirmPopup() {
        automateNowPage.setBtnCancelarPop();
    }

    @And("hago click en la opcion Prompt Popup e ingreso {string}")
    public void hagoClickEnLaOpcionPromptPopupEIngreso(String name) {
        automateNowPage.setBtnProntPop(name);
    }

    @When("hago click en la opcion Prompt Popup y cancelo la opcion")
    public void hagoClickEnLaOpcionPromptPopup() {
        automateNowPage.setBtnCancelProntPop();
    }
}
