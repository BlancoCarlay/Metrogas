@NowTag
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

    @Calendario
    Scenario: Seleccionar fecha del calendario
      Given ingreso al link de AutomateNow2
      And hago click en el boton para seleccionar fechas del calenadio
      And hago click sobre el texto que despliega el calendario
      And selecciono el ano 1988 en el calendario
      And selecciono el mes de noviembre en el calendario
      And selecciono el dia 16 en el calendario
      When hago click sobre el boton submit
      Then valido que se muestre el texto en la pagina "Thank you for your response."
      And valido que se muestre el texto en la pagina "1988-11-16"
