package steps;

import io.cucumber.java.en.*;
import pages.MetroGasIniPage;
import utils.DriverFactory;
import utils.PropertiesLoader;

public class MetroGasIniSteps {

    MetroGasIniPage metroGasIniPage;

    @Given("estoy en la pagina inicial de Metrogas")
    public void estoy_en_la_pagina_inicial_de_Metrogas() {
        String base = PropertiesLoader.get("urlM");

        DriverFactory.getDriver().get(base);
        metroGasIniPage = new MetroGasIniPage(DriverFactory.getDriver());
    }

    @And("cierro el modal informativo")
    public void cierroElModalInformativo() {

        metroGasIniPage.setBtnEntendido();
    }

    @And("hago click en soy usuario")
    public void hagoClickEnSoyUsuario() {
        metroGasIniPage.setBtnTengoUsuario();
    }

    @And("ingreso usuario {string}")
    public void ingresoUsuario(String user) {
        metroGasIniPage.setInputUsuario(user);
    }

    @And("ingreso clave {string}")
    public void ingresoClave(String pass) {
        metroGasIniPage.setInputPass(pass);
    }

    @When("hago clic en el boton login")
    public void hagoClicEnElBotonLogin() {
        metroGasIniPage.setBtnSesion();
    }

    @Then("valido el mensaje {string}")
    public void validoElMensaje(String error) {
        metroGasIniPage.setValidoMensaje(error);
    }
}
