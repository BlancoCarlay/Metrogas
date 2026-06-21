package steps;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.DriverFactory;
import utils.PropertiesLoader;

public class LoginSteps {

    LoginPage loginPage;

    @Given("que estoy en la página de login")
    public void que_estoy_en_la_pagina_de_login() {
        String base = PropertiesLoader.get("url");

        DriverFactory.getDriver().get(base);
        loginPage = new LoginPage(DriverFactory.getDriver());
    }
}
