package steps;

import io.cucumber.java.en.*;
import pages.CineplanetPages;
import utils.DriverFactory;
import utils.PropertiesLoader;

public class CineplanetSteps {

    CineplanetPages cineplanetPages;

    @Given("estoy en la pagina inicial de Cineplanet")
    public void estoy_en_la_pagina_inicial_de_Cineplanet() {
        String base = PropertiesLoader.get("urlC");

        DriverFactory.getDriver().get(base);
        cineplanetPages = new CineplanetPages(DriverFactory.getDriver());
    }

    @And("cierro el modal de compra")
    public void cierroElModalDeCompra() {
        cineplanetPages.setBtnX();
    }

    @And("hago click en la combo pelicula")
    public void hagoClickEnComboPelicula() {
        cineplanetPages.setSelectPeli();
    }

    @And("selecciono Toy Story 5")
    public void seleccionoToyStory5() {
        cineplanetPages.setTextToy5();
    }

    @When("selecciono el boton filtrar")
    public void seleccionoElBotonFiltrar() {
        cineplanetPages.setBtnFiltrar();
    }

    @Then("verifico que se muestre el texto {string}")
    public void verificoQueSeMuestreElTexto(String Sip) {
        cineplanetPages.setTextSinopsis(Sip);
    }
}
