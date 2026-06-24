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

  @Click
  Scenario: Hacer click en botones
    Given ingreso al link de AutomateNow
    And hago click en el boton para clickear opciones
    And hago click en el boton de Gato
    And valido que se muestre el texto "Meow!"
    And hago click en el boton de Perro
    And valido que se muestre el texto "Woof!"
    And hago click en el boton de Puerco
    And valido que se muestre el texto "Oink!"
    When hago click en el boton de Vaca
    Then valido que se muestre el texto "Moo!"

  @Iframe
  Scenario: Hacer click en iframes
    Given ingreso al link de AutomateNow
    And hago click en el boton para clickear iframes
    And ubico el iframe de playwright
    And ubico el iframe de selenium
    And bajo hasta encontrar la opcion "LEARN MORE"
    When hago click sobre el texto LEARN MORE
    And busco la opcion ShipFox
    Then hago click sobre la opcion ShipFox
