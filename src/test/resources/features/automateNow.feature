@Aut
Feature: AutomateNow

  @Form
  Scenario: Llenar campos del formulario
    Given ingreso al link de AutomateNow
    And hago click en el boton para llenar un formulario
    And ingreso el nombre "Carlay" en el input name
    And ingreso la contrasena "1234" en el input contrasena
    And selecciono Leche y Cafe en bebidas favoritas
    And selecciono el color amarillo como favorito
    And respondo que si a la pregunta sobre automatizacion
    And verifico que la herramienta "Selenium" existan
    And ingreso el correo "prueba@gmail.com" al input del email
    When ingreso el mensaje "Soy automatizadora" en el area de texto
    Then presiono el boton Submit y veo el mensaje final