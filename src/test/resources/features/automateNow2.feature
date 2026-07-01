@Now
Feature: AutomateNow2

  @Modal
  Scenario: Cerrar modales
    Given ingreso al link de AutomateNow2
    And hago click en el boton para cerrar modales
    And hago click en el boton para activar el modal simple
    And valido que se muestre el texto en la pagina "Simple Modal"
    And cierro el modal en la X
    And hago click en el boton para activar el modal de formulario
    And ingreso el nombre "Carlay" en el formulario del modal
    And ingreso el correo "prueba@gmail.com" en el formulario del modal
    And ingreso el mensaje "Prueba de Carlay" en el formulario del modal
    And hago click en el boton para cargar la informacion ingresada en el formulario
    And valido que se muestre el texto en la pagina "Carlay"
    And valido que se muestre el texto en la pagina "prueba@gmail.com"
    And valido que se muestre el texto en la pagina "Prueba de Carlay"
    When cierro el formulario del modal en la X
    Then valido que se muestre el texto en la pagina "Modals"