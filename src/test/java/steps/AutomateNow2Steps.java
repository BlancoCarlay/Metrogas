package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.AutomateNow2Page;
import pages.AutomateNowPage;
import utils.DriverFactory;
import utils.PropertiesLoader;

public class AutomateNow2Steps {

    AutomateNow2Page automateNow2Page;

    @Given("ingreso al link de AutomateNow2")
    public void ingresoAlLinkDeAutomateNow2() {
        String base = PropertiesLoader.get("urlA");
        DriverFactory.getDriver().get(base);
        automateNow2Page = new AutomateNow2Page(DriverFactory.getDriver());
    }

    @And("hago click en el boton para cerrar modales")
    public void hagoClickEnElBotonParaCerrarModales() {
        automateNow2Page.setBtnModal();
    }

    @And("hago click en el boton para activar el modal simple")
    public void hagoClickEnElBotonParaActivarElModalSimple() {
        automateNow2Page.setBtnSimple();
    }

    @And("valido que se muestre el texto en la pagina {string}")
    public void validoQueSeMuestreElTextoEnLaPagina(String txt) {
        automateNow2Page.setValidaTxt(txt);
    }

    @And("cierro el modal en la X")
    public void cierroElModalEnLaX() {
        automateNow2Page.setBtnX();
    }

    @And("hago click en el boton para activar el modal de formulario")
    public void hagoClickEnElBotonParaActivarElModalDeFormulario() {
        automateNow2Page.setBtnForm();
    }

    @And("ingreso el nombre {string} en el formulario del modal")
    public void ingresoElNombreEnElFormularioDelModal(String name) {
        automateNow2Page.setInputName(name);
    }

    @And("ingreso el correo {string} en el formulario del modal")
    public void ingresoElCorreoEnElFormularioDelModal(String email) {
        automateNow2Page.setInputEmail(email);
    }

    @And("ingreso el mensaje {string} en el formulario del modal")
    public void ingresoElMensajeEnElFormularioDelModal(String msj) {
        automateNow2Page.setInputMensaje(msj);
    }

    @And("hago click en el boton para cargar la informacion ingresada en el formulario")
    public void hagoClickEnElBotonParaCargarLaInformacionIngresadaEnElFormulario() {
        automateNow2Page.setBtnSub();
    }

    @When("cierro el formulario del modal en la X")
    public void cierroElFormularioDelModalEnLaX() {
        automateNow2Page.setBtnX2();
    }

    //Caso 2
    @And("hago click en el boton para seleccionar fechas del calenadio")
    public void hagoClickEnElBotonParaSeleccionarFechasDelCalenadio() {
        automateNow2Page.setBtnCalendario();
    }

    @And("hago click sobre el texto que despliega el calendario")
    public void hagoClickSobreElTextoQueDespliegaElCalendario() {
        automateNow2Page.setBtnTextCalendario();
    }

    @And("selecciono el ano {int} en el calendario")
    public void seleccionoElAnoEnElCalendario(int arg0) {
        automateNow2Page.setBtnAno();
    }

    @And("selecciono el mes de noviembre en el calendario")
    public void seleccionoElMesDeNoviembreEnElCalendario() {
        automateNow2Page.setBtnMes();
    }

    @And("selecciono el dia {int} en el calendario")
    public void seleccionoElDiaEnElCalendario(int arg0) {
        automateNow2Page.setBtn16();
    }

    @When("hago click sobre el boton submit")
    public void hagoClickSobreElBotonSubmit() {
        automateNow2Page.setBtnSubmitCal();
    }
}
